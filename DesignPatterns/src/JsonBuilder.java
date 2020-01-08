import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Collection;

public class JsonBuilder implements Builder {
    protected Element document;
    protected String path;

    public JsonBuilder(String s) {
        this.path = s;
    }


    @Override
    public Element getResult() {
        return document;
    }

    @Override
    public void build() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            HashMap<String, Object> map = mapper.readValue(new File(this.path),
                    HashMap.class);
            this.document = (Element) processMap(map);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Element processMap(HashMap<String, Object> map) {
        String denumire = (String) map.get("class");
        if(denumire.equals("Section")) return buildSection(map);
        else if(denumire.equals("Paragraph")) return buildParagraph(map);
        else if(denumire.equals("Image")) return buildImage(map);
        else if(denumire.equals("ImageProxy")) return buildImageProxy(map);
        else return buildTable(map);
    }

    @Override
    public Element buildSection(HashMap<String, Object> map) {
        Section section = new Section((String) map.get("title"));
        Collection<HashMap<String, Object>> children = (Collection) map.get("children");
        children.forEach((childMap) -> {

            Element e = (Element) this.processMap(childMap);
            if (e != null) {
                try {
                    section.add(e);
                } catch (Exception var5) {
                    var5.printStackTrace();
                }
            }
        });
        return section;
    }


    @Override
    public Element buildParagraph(HashMap<String, Object> map) {
        Paragraph paragraph = new Paragraph((String) map.get("text"));
        return paragraph;
    }

    @Override
    public Element buildImage(HashMap<String, Object> map) {
        Image image = new Image((String) map.get("url"));
        return image;
    }

    @Override
    public Element buildImageProxy(HashMap<String, Object> map) {
        ImageProxy image = new ImageProxy((String) map.get("url"));
        return image;
    }

    @Override
    public Element buildTable(HashMap<String, Object> map) {
        Table table = new Table((String) map.get("name"));
        return table;
    }
}
