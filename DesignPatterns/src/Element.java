public interface Element {
    public void print();
    public void accept(Visitor v);
    public void setNewValue(String s);
    public Element copy();
}
