import java.util.ArrayList;

public class Paragraph implements Element, Observable{
    protected String paragraph;
    protected AlignStrategy align;
    protected String oldValue;
    protected ArrayList<Observer> observersList = new ArrayList<Observer>();

    public Paragraph(String nume){
        this.paragraph=nume;
        addObserver(DocumentManager.getInstance().getFirstObserver());
    }



    @Override
    public String toString() {
        return "Paragraph{" +
                "paragraph='" + paragraph + '\'' +
                '}';
    }
    public void setAlignStrategy(AlignStrategy align){
        this.align = align;

    }
    public void print() {
        if(align!=null) align.print(paragraph);
        else System.out.println(paragraph);
    }
    public void accept(Visitor v){
        v.visit(this);
    }

    public void setNewValue(String s){
        this.oldValue=this.paragraph;
        this.paragraph=s;
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
            o.update(oldValue,paragraph);
        }
    }
}
