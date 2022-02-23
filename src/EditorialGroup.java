import java.util.ArrayList;

public class EditorialGroup implements IPublishingArtifact{
    //identificator unic
    private int ID;
    //nume
    private String name;
    //lista de carti publicate de un brand in parte
    private ArrayList<Book> books;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public String Publish() {
        String booksEditorial = "";

        for (Book book : books) {
            booksEditorial = booksEditorial + book.noHeader();
        }

        String xmlFormat = "<xml>\n" +
                "\t<editorialGroup>\n" +
                "\t<ID>" + this.ID + "</ID>\n" +
                "\t<Name>" + this.name + "</Name>" +
                "\t</editorialGroup>\n" +
                "\t<books>\n" + booksEditorial +
                "\t</books>\n" +
                "</xml>";
        return xmlFormat;
    }
}
