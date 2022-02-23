import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InitBooksAuthors {
    //returneaza carte cu ID cautat
    public static Book searchBook (int ID, ArrayList<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            Book auxBook = books.get(i);
            if (auxBook.getID() == ID) {
                return auxBook;
            }
        }
        return null;
    }
    //adauga autorii cu ID cautat in carte
    public static void addAuthor (int ID, Book book, ArrayList<Author> authors) {
        for (int i = 0; i < authors.size(); i++) {
            Author auxAuthor = authors.get(i);
            if (auxAuthor.getID() == ID) {
                ArrayList<Author> bookAuthors = book.getAuthors();
                if (bookAuthors == null) {
                    bookAuthors= new ArrayList<Author>();
                }
                bookAuthors.add(auxAuthor);
                book.setAuthors(bookAuthors);
            }
        }
    }

    public static void Read (ArrayList<Book> books, ArrayList<Author> authors) {
        try {
            File myFile = new File("init/books-authors.in");
            Scanner myReader = new Scanner(myFile);

            int logic = 0;
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] split = line.split("###");
                if (logic != 0) {
                    int idBook = Integer.parseInt(split[0]);
                    int idAuthor = Integer.parseInt(split[1]);
                    Book searchedBook = searchBook(idBook, books);
                    addAuthor(idAuthor, searchedBook, authors);
                }
                logic++;
            }
            myReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error InitBookAuthor");
            ex.printStackTrace();
        }
    }
}
