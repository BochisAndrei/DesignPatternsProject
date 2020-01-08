public class UndoCommand implements Command {
    protected  Section mySection;
    public UndoCommand(){
        mySection=DocumentManager.getInstance().getSection();
    }

    @Override
    public void execute() {
        Memento m = DocumentManager.getInstance().pop();
        mySection.add(m.getState());
        DocumentManager.getInstance().setSection(mySection);
    }
}
