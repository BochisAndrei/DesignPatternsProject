public class BookStatistics implements Visitor {
    protected int nrImagini = 0;
    protected int nrParagrafe = 0;
    protected int nrTabele = 0;
    protected int nrSectiuni = 0;

    public void visit(Image i){
        if(i!=null){
            this.nrImagini+=1;
        }
    }
    public void visit(ImageProxy ip){
        if(ip!=null){
            this.nrImagini+=1;
        }
    }
    public void visit(Paragraph p){
        if(p!=null){
            this.nrParagrafe+=1;
        }
    }
    public void visit(Table t){
        if(t!=null){
            this.nrTabele+=1;
        }
    }
    public void visit(Section s){
        if(s!=null){
            this.nrSectiuni+=1;
        }
    }

    @Override
    public void visit(Book b) {

    }

    public int getNrSectiuni() {
        return nrSectiuni;
    }

    public int getNrTabele() {
        return nrTabele;
    }

    public int getNrParagrafe() {
        return nrParagrafe;
    }

    public int getNrImagini() {
        return nrImagini;
    }

    public void print(){
        System.out.println("Numar imagini: "+this.nrImagini);
        System.out.println("Numar paragrafe: "+this.nrParagrafe);
        System.out.println("Numar tabele: "+this.nrTabele);
        System.out.println("Numar sectiuni: "+this.nrSectiuni);
    }
}
