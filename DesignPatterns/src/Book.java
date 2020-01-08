import java.util.ArrayList;

public class Book {
    protected String nume;
    protected ArrayList<Author>  listaAutori = new ArrayList<Author>();
    protected ArrayList<Element> listaElemente = new ArrayList<Element>();

    public Book(String nume){
        this.nume=nume;

    }
    public int addContent(Element e){
        listaElemente.add(e);
        return listaElemente.indexOf(e);
    }

    public void addAuthor(String authorName){
        Author au = new Author(authorName);
        listaAutori.add(au);
    }
    public void addAuthor(Author au){
        listaAutori.add(au);
    }

    public ArrayList<Element> getElements(){
        return listaElemente;
    }
    @Override
    public String toString() {
        return "Book{" +
                "nume='" + nume + '\'' +
                ", listaAutori=" + listaAutori +
                ", listaElemente=" + listaElemente +
                '}';
    }
    public void print(){
        System.out.println("Book: " + nume);
        for(Author a: listaAutori){
            a.print();
        }
        for(Element e : listaElemente ){
            e.print();
        }
    }
    public void accept(Visitor v){
        v.visit(this);
        for (Element e:listaElemente) {
            e.accept(v);
        }
    }

}
