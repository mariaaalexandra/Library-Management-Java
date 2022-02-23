import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadAuthors {
    public static ArrayList<Author> Read () {
        ArrayList<Author> authors = new ArrayList<Author>();
        try {
            File myFile = new File("init/authors.in");
            Scanner myReader = new Scanner(myFile);

            int logic = 0;
            while (myReader.hasNextLine()) {
                Author newAuthor = new Author();
                String line = myReader.nextLine();
                String[] split = line.split("###");
                if (logic != 0) {
                    newAuthor.setID(Integer.parseInt(split[0]));
                    newAuthor.setFirstName(split[1]);
                    newAuthor.setLastName(split[2]);
                    authors.add(newAuthor);
                }
                logic++;
            }
            myReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error AuthorRead");
            ex.printStackTrace();
        }
        return authors;
    }
}
