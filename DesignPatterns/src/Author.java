public class Author {
    protected String nume;

    @Override
    public String toString() {
        return "Author{" +
                "nume='" + nume + '\'' +
                '}';
    }

    public Author(String nume){
        this.nume=nume;

    }

    public void print(){
        System.out.println("Author: " + nume);
    }
}
