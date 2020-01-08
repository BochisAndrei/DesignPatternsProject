import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
            Section cap1 = new Section("Capitolul 1");
            cap1.add(new Paragraph("Moto capitol"));
            cap1.add(new Paragraph("Another One"));
            cap1.add(new Paragraph("Another Two"));
            cap1.add(new Paragraph("Another Three"));
            DocumentManager.getInstance().setSection(cap1);
            System.out.println("Book Content: ");
            DocumentManager.getInstance().getSection().print();

            new DeleteCommand().execute();
            System.out.println("Book Content after the first delete: ");
            DocumentManager.getInstance().getSection().print();
            new DeleteCommand().execute();
            System.out.println("Book Content after the second delete: ");
            DocumentManager.getInstance().getSection().print();


            Command undoCommand = new UndoCommand();
            undoCommand.execute();
            System.out.println("Book Content after first undo: ");
            DocumentManager.getInstance().getSection().print();
            undoCommand.execute();
            System.out.println("Book Content after second undo: ");
            DocumentManager.getInstance().getSection().print();

        }
}


