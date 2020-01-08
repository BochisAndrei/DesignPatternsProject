import java.util.ArrayList;

public class Table implements Element, Observable{
    protected String nume;
    protected String oldValue;
    protected ArrayList<Observer> observersList = new ArrayList<Observer>();

    @Override
    public String toString() {
        return "Table{" +
                "nume='" + nume + '\'' +
                '}';
    }

    public Table(String nume){
        this.nume = nume;
        addObserver(DocumentManager.getInstance().getFirstObserver());
    }

    public void print(){
        System.out.println("Tabel with Title: " + nume);
    }

    public void accept(Visitor v){
        v.visit(this);
    }

    public void setNewValue(String s){
        this.oldValue=this.nume;
        this.nume=s;
        this.notifyObserver();
    }

    @Override
    public Element copy() {
        return this;
    }

    @Override
    public void addObserver(Observer obs) {
        if(obs!=null)observersList.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        for (Observer o : observersList) {
            if(o.equals(obs)) observersList.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observersList) {
            o.update(oldValue,nume);
        }
    }

}
