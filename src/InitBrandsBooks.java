import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InitBrandsBooks {
    //returneaza brand cu ID cautat
    public static PublishingBrand searchBrand (int ID, ArrayList<PublishingBrand> brands) {
        for (int i = 0; i < brands.size(); i++) {
            PublishingBrand auxBrand = brands.get(i);
            if (auxBrand.getID() == ID) {
                return auxBrand;
            }
        }
        return null;
    }
    //adauga cartea cu ID cautat in grup
    public static void addBook (int ID, PublishingBrand brand, ArrayList<Book>books) {
        for (int i = 0; i < books.size(); i++) {
            Book auxBook = books.get(i);
            if (auxBook.getID() == ID) {
                ArrayList<Book> bookBrand = brand.getBooks();
                if (bookBrand == null) {
                    bookBrand = new ArrayList<Book>();
                }
                bookBrand.add(auxBook);
                brand.setBooks(bookBrand);
            }
        }
    }

    public static void Read (ArrayList<Book> books, ArrayList<PublishingBrand> brands) {
        try {
            File myFile = new File("init/publishing-brands-books.in");
            Scanner myReader = new Scanner(myFile);

            int logic = 0;
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] split = line.split("###");
                if (logic != 0) {
                    int idBrand = Integer.parseInt(split[0]);
                    int idBook = Integer.parseInt(split[1]);
                    PublishingBrand searchedBrand = searchBrand(idBrand, brands);
                    addBook(idBook, searchedBrand, books);
                }
                logic++;
            }
            myReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error InitBrandBook");
            ex.printStackTrace();
        }
    }
}
