import java.io.IOException;
import java.util.ArrayList;
import java.io.*;
public class BookSave implements Visitor {
    protected ArrayList<Image> ListaImagini = new ArrayList<Image>();
    protected ArrayList<Section> ListaSectiuni = new ArrayList<Section>();
    protected ArrayList<Paragraph> ListaParagrafe = new ArrayList<Paragraph>();
    protected ArrayList<Table> ListaTabele = new ArrayList<Table>();


    public void visit(Image i){
        if(i!=null) ListaImagini.add(i);
    }
    public void visit(ImageProxy ip){
        //if(ip!=null) ListaImagini.add(ip);
    }
    public void visit(Paragraph p){
        if(p!=null) ListaParagrafe.add(p);
    }
    public void visit(Table t){
        if(t!=null) ListaTabele.add(t);
    }
    public void visit(Section s){
        if(s!=null) ListaSectiuni.add(s);
    }

    @Override
    public void visit(Book b) { }

    public void saveToFile() throws IOException {
        try (FileWriter writer = new FileWriter("/Users/andreibochis/IdeaProjects/DesignPatterns/src/date.txt");
             BufferedWriter bw = new BufferedWriter(writer)) {
            for (Section s: ListaSectiuni) {
                bw.write(s.toString());
            }

            for (Paragraph p: ListaParagrafe) {
                bw.write(p.toString());
            }
            for (Image i: ListaImagini) {
                bw.write(i.toString());
            }

            for (Table t: ListaTabele) {
                bw.write(t.toString());
            }


        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

}
