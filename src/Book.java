import java.util.ArrayList;
public class Book implements IPublishingArtifact{
    //identificator unic
    private int ID;
    //nume de publicare al cartii
    private String name;
    //subtitlu al cartii, optional
    private String subtitle;
    //identificator unic al cartii
    private String ISBN;
    //numar de pagini
    private int pageCount;
    //cuvinte cheie ale cartii
    private String keywords;
    //limba in care este scrisa
    private int languageID;
    //data adaugarii in sistem
    private String createdOn;
    //lista de autori
    private ArrayList<Author> authors;

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

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getLanguageID() {
        return languageID;
    }

    public void setLanguageID(int languageID) {
        this.languageID = languageID;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    //numele autorilor
    public String authorNames(ArrayList<Author> authors) {
        String buffer = new String();
        int len = authors.size();
        int count = 1;
        for (Author aux : authors) {
            buffer += aux.getFirstName() + " " + aux.getLastName();
            if (len != count) {
                buffer += " ";
            }
            count++;
        }
        return buffer;
    }

    @Override
    //publicare carte cu antet
    public String Publish() {
        String xmlFormat = "<xml>\n" +
                            "\t<title>" + this.name + "</title>\n" +
                            "\t<subtitle>" + this.subtitle + "</subtitle>\n" +
                            "\t<isbn>" + this.ISBN + "</isbn>\n" +
                            "\t<pageCount>" + this.pageCount + "</pageCount>\n" +
                            "\t<keywords>" + this.keywords + "</keywords>\n" +
                            "\t<languageID>" + this.languageID + "</languageID>\n" +
                            "\t<createdOn>" + this.createdOn + "<createdOn>\n" +
                            "\t<authors>" + this.authorNames(authors) + "<authors>\n" +
                            "</xml>\n";
        return xmlFormat;
    }

    //publicare carte fara antet
    public String noHeader() {
        String xmlFormat = "\t<title>" + this.name + "</title>\n" +
                            "\t<subtitle>" + this.subtitle + "</subtitle>\n" +
                            "\t<isbn>" + this.ISBN + "</isbn>\n" +
                            "\t<pageCount>" + this.pageCount + "</pageCount>\n" +
                            "\t<keywords>" + this.keywords + "</keywords>\n" +
                            "\t<languageID>" + this.languageID + "</languageID>\n" +
                            "\t<createdOn>" + this.createdOn + "<createdOn>\n" +
                            "\t<authors>" + this.authors + "<authors>\n";
        return xmlFormat;
    }

}
