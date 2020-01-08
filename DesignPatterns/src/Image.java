import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Image implements Element, Observable{
    protected String image;
    protected String oldValue;
    protected ArrayList<Observer> observersList = new ArrayList<Observer>();

    @Override
    public String toString() {
        return "Image{" +
                "image='" + image + '\'' +
                '}';
    }

    public Image(String nume){

        this.image=nume;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addObserver(DocumentManager.getInstance().getFirstObserver());
    }

    public void print(){
        System.out.println("Imagine with name: " + image);
    }

    public void accept(Visitor v){
        v.visit(this);
    }

    public void setNewValue(String s){
        this.oldValue=this.image;
        this.image=s;
        this.notifyObserver();
    }

    @Override
    public Element copy() {
        return this;
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
            if(o.equals(obs)) observersList.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observersList) {
            o.update(oldValue,image);
        }
    }
}
