import java.util.ArrayList;

public class Section implements Element, Observable{
    protected String nume;
    protected ArrayList<Element> listaElemente = new ArrayList<Element>();
    protected String oldValue;
    protected ArrayList<Observer> observersList = new ArrayList<Observer>();

    public Section(String nume){
        this.nume=nume;
        addObserver(DocumentManager.getInstance().getFirstObserver());

    }

    public void print(){
        System.out.println("Section: " + nume);
        for (Element var : listaElemente)
        {
            if(var!=null) var.print();
        }

    }
    public int add(Element el){
        listaElemente.add(el);
        return listaElemente.indexOf(el);
    }

    public Element getElement(int index){
        return (Element) listaElemente.get(index);
    }
    public void removeSection(Element e){
        for (Element elm:listaElemente) {
            if(elm == e)
                listaElemente.remove(elm);
        }
    }
    public void accept(Visitor v){
        v.visit(this);
        for (Element e:listaElemente) {
            e.accept(v);
        }
    }


    public void setNewValue(String s){
        this.oldValue=this.nume;
        this.nume=s;
        this.notifyObserver();
    }
    @Override
    public void addObserver(Observer obs) {
        if(obs!=null) {
            observersList.add(obs);
        }
    }

    @Override
    public void removeObserver(Observer obs) {
        for (Observer o : observersList) {
            if(o.equals(obs)) observersList.remove(obs);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observersList) {
            o.update(oldValue,nume);
        }
    }
    public Element getLastElement(){
        return listaElemente.get(listaElemente.size()-1);
    }

    public void removeLastElement(){
        listaElemente.remove(listaElemente.get(listaElemente.size()-1));
    }

    public Element copy(){
        Section s = new Section(this.nume);
        for(Element e : listaElemente){
            s.add(e.copy());
        }
        return s;
    }
}
