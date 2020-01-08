public class FinancialBook extends BookStatistics{
    protected int suma = 0;
    protected int pretImagine = 3;
    protected int pretParagrafe = 2;
    protected int pretSectiuni = 10;
    protected int pretTabele = 5;


    public FinancialBook(BookStatistics stats){
        suma+=stats.getNrImagini()*pretImagine;
        suma+=stats.getNrParagrafe()*pretParagrafe;
        suma+=stats.getNrSectiuni()*pretSectiuni;
        suma+=stats.getNrTabele()*pretTabele;

    }
    public void print(){
        System.out.println("Pretul cartii este: " +suma);
    }

}
