import java.util.ArrayList;

public class PublishingBrand implements IPublishingArtifact{
    //identificator unic
    private int ID;
    //nume
    private String name;
    //lista de carti publicate de un brand anume
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
        String booksBrand= "";

        for (Book book : books) {
            booksBrand = booksBrand+ book.noHeader();
        }

        String xmlFormat = "<xml>\n" +
                            "\t<publishingBrand>\n" +
                            "\t<ID>" + this.ID + "</ID>\n" +
                            "\t<Name>" + this.name + "</Name>" +
                            "\t</publishingBrand>\n" +
                            "\t<books>\n" + books +
                            "\t</books>\n" +
                            "</xml>";
        return xmlFormat;

    }

}
