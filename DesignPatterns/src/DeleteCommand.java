public class DeleteCommand implements Command{
    protected Section mySection;
    protected Memento m = new Memento();
    public DeleteCommand(){
        mySection=DocumentManager.getInstance().getSection();
    }

    @Override
    public void execute() {
        if(mySection!=null) m.setState(mySection);
        DocumentManager.getInstance().push(m);
        if(mySection!=null) mySection.removeLastElement();
        DocumentManager.getInstance().setSection(mySection);
    }
}
