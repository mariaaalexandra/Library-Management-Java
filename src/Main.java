import javax.naming.InitialContext;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //lista carti
        ArrayList<Book> books = ReadBooks.Read();
        //lista autori
        ArrayList<Author> authors = ReadAuthors.Read();
        //lista limbi
        ArrayList<Language> languages = ReadLanguages.Read();
        //lista grupuri
        ArrayList<EditorialGroup> groups = ReadEditorialGroup.Read();
        //lista tari
        ArrayList<Countries> countries = ReadCountry.Read();
        //lista brands
        ArrayList<PublishingBrand> brands = ReadPublishingBrands.Read();
        //lista retailers
        ArrayList<PublishingRetailer> retailers = ReadPublishingRetailers.Read();

        InitBooksAuthors.Read(books, authors);

        InitGroupsBooks.Read(books, groups);

        InitBrandsBooks.Read(books, brands);

        InitRetailerBook.Read(retailers, books);

        InitRetailerBrand.Read(retailers, brands);

        InitRetailerGroup.Read(retailers, groups);

        InitRetailersCountries.Read(retailers, countries);

//      apel metode Administration

        //met 1
        Integer[] IDs = {1, 2, 3, 4, 5};
        for (int id : IDs) {
            ArrayList<Book> retailerBooks = Aministration.getBooksForPublishingRetailerID(id, retailers);
            String buffer = "";
            String path = "outputs/FirstMethod/BooksRetailer" + String.valueOf(id);
            try (FileWriter file = new FileWriter(path)) {
                try (BufferedWriter buff = new BufferedWriter(file)) {
                    for (Book book : retailerBooks) {
                        buffer += book.Publish();
                    }
                    buff.write(buffer);
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        //met2
        for (int id : IDs) {
            ArrayList<Language> retailerLanguages = Aministration.getLanguagesForPublishingRetailerID(id, retailers, languages);
            String buffer = "";
            String path = "outputs/SecondMethod/LanguagesRetailer" + String.valueOf(id);
            try (FileWriter file = new FileWriter(path)) {
                try (BufferedWriter buff = new BufferedWriter(file)) {
                    for (Language language : retailerLanguages) {
                        String name = language.getName() + "\n";
                        buffer += name;
                    }
                    buff.write(buffer);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        //met3
        Integer[] bookIDs = {204, 440, 483, 488, 489};
        for (int id : bookIDs) {
            ArrayList<Countries> bookCountries = Aministration.getCountriesForBookID(id, retailers);
            String buffer = "";
            String path = "outputs/ThirdMethod/CountriesBook" + String.valueOf(id);
            try (FileWriter file = new FileWriter(path)) {
                try (BufferedWriter buff = new BufferedWriter(file)) {
                    for (Countries country : bookCountries) {
                        String name = country.getCountryCode() + "\n";
                        buffer += name;
                    }
                    buff.write(buffer);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        //met4
        for (int id : IDs) {
            ArrayList<Book> commonBooks = Aministration.getCommonBooksForRetailerIDs(id, id + 1, retailers);
            String buffer = "";
            String path = "outputs/FourthMethod/CommonBooks" + String.valueOf(id) + "-" + String.valueOf(id + 1);
            try (FileWriter file = new FileWriter(path)) {
                try (BufferedWriter buff = new BufferedWriter(file)) {
                    for (Book book : commonBooks) {
                        String name = book.Publish();
                        buffer += name;
                    }
                    buff.write(buffer);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        //met5
        for (int id : IDs) {
            ArrayList<Book> allBooks = Aministration.getAllBooksForRetailerIDs(id, id + 1, retailers);
            String buffer = "";
            String path = "outputs/FifthMethod/AllBooks" + String.valueOf(id) + "-" + String.valueOf(id + 1);
            try (FileWriter file = new FileWriter(path)) {
                try (BufferedWriter buff = new BufferedWriter(file)) {
                    for (Book book : allBooks) {
                        String name = book.Publish();
                        buffer += name;
                    }
                    buff.write(buffer);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
