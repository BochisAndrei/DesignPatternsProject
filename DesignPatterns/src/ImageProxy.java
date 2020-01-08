import java.util.ArrayList;

public class ImageProxy implements Element, Observable{
    protected String imageName;
    protected String oldValue;
    protected Image realImage;
    protected ArrayList<Observer> observersList = new ArrayList<Observer>();
    public ImageProxy(String img){
        this.imageName = img;
        addObserver(DocumentManager.getInstance().getFirstObserver());
    }
    public void print(){
        if(realImage == null){
            realImage = new Image(imageName);
        }
        realImage.print();
    }
    public void accept(Visitor v){
        v.visit(this);
    }

    public void setNewValue(String s){
        this.oldValue=this.imageName;
        this.imageName=s;
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
            o.update(oldValue,imageName);
        }
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
