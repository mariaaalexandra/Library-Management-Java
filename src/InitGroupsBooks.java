import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InitGroupsBooks {
    //returneaza grupul cu ID cautat
    public static EditorialGroup searchGroup(int ID, ArrayList<EditorialGroup> groups) {
        for (int i = 0; i < groups.size(); i++) {
            EditorialGroup auxGroup = groups.get(i);
            if (auxGroup.getID() == ID) {
                return auxGroup;
            }
        }
        return null;
    }

    //adaug carte in cu ID cautat in editorial
    public static void addBook(int ID, EditorialGroup group, ArrayList<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            Book auxBook = books.get(i);
            if (auxBook.getID() == ID) {
                ArrayList<Book> bookGroup = group.getBooks();
                if (bookGroup == null) {
                    bookGroup = new ArrayList<Book>();
                }
                bookGroup.add(auxBook);
                group.setBooks(bookGroup);
            }
        }
    }

    public static void Read (ArrayList<Book> books, ArrayList<EditorialGroup> groups) {
        try {
            File myFile = new File("init/editorial-groups-books.in");
            Scanner myReader = new Scanner(myFile);

            int logic = 0;
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] split = line.split("###");
                if (logic != 0) {
                    int idGroup = Integer.parseInt(split[0]);
                    int idBook = Integer.parseInt(split[1]);
                    EditorialGroup searchedGroup = searchGroup(idGroup, groups);
                    addBook(idBook, searchedGroup, books);
                }
                logic++;
            }
            myReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error InitGroupsBooks");
            ex.printStackTrace();
        }
    }
}
