import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadBooks {
    public static ArrayList<Book> Read() {
        //initializare array de books
        ArrayList<Book> books = new ArrayList<Book>();
        try {
            //fisierul de input
            File myFile = new File("init/books.in");
            Scanner myReader = new Scanner(myFile);

            int logic = 0;
            //citesc linie cu linie
            while (myReader.hasNextLine()) {
                Book newBook = new Book();
                String line = myReader.nextLine();
                //despart linia dupa delimitator
                String[] split = line.split("###");
                //daca nu este primul rand initializez campurile
                if (logic != 0) {
                    newBook.setID(Integer.parseInt(split[0]));
                    newBook.setName(split[1]);
                    newBook.setSubtitle(split[2]);
                    newBook.setISBN(split[3]);
                    newBook.setPageCount(Integer.parseInt(split[4]));
                    newBook.setKeywords(split[5]);
                    newBook.setLanguageID(Integer.parseInt(split[6]));
                    newBook.setCreatedOn(split[7]);
                    books.add(newBook);
                }
                logic++;
            }
            myReader.close();
            //prinderea erorilor
        } catch (FileNotFoundException ex) {
            System.out.println("Error BookRead");
            ex.printStackTrace();
        }
        return books;
    }

}
