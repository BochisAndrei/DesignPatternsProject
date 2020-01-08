import java.util.ArrayList;
import java.util.Stack;

public class DocumentManager {
    private static DocumentManager instance=null;
    protected Book myBook;
    protected Section mySection;
    protected FirstObserver f = new FirstObserver();
    protected SecondObserver s = new SecondObserver();
    protected Stack<Memento> stiva = new Stack<Memento>();

    private DocumentManager(){

    }

    public static DocumentManager getInstance(){
        if(instance==null){
            instance=new DocumentManager();
        }
        return instance;
    }
    public Book getBook(){
        Book b = new Book("Carte Goala");
        if(myBook!=null) return myBook;
        return b;
    }
    public Section getSection(){
        Section s = new Section("Sectiune goala");
        if(mySection!=null) return mySection;
        return s;
    }
    public Observer getFirstObserver(){
        return f;
    }
    public Observer getSecondObserver(){
        return s;
    }

    public void setBook(Book book){
        myBook=book;
    }

    public void setSection(Section section){mySection=section;}

    public void push(Memento e){
        if(e!=null) this.stiva.push(e);
    }
    public Memento pop(){
        Memento m = new Memento();
        if(stiva!=null) return stiva.pop();
        return m;
    }
}


