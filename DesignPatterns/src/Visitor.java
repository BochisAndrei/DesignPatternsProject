public interface Visitor {
    public void visit(Image i);
    public void visit(ImageProxy ip);
    public void visit(Paragraph p);
    public void visit(Table t);
    public void visit(Section s);
    public void visit(Book b);
}
