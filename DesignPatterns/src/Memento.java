public class Memento {
    protected Element state;
    public Memento(){

    }
    public Element getState(){
        return state;

    }
    public void setState(Element e){
        this.state=e.copy();

    }
}
