public class StatisticCommand implements Command {
    protected Book myBook;
    public StatisticCommand(Book book){
        myBook=book;
    }
    @Override
    public void execute() {

        BookStatistics stats = new BookStatistics();
        if(myBook!=null) myBook.accept(stats);
        stats.print();
    }
}
