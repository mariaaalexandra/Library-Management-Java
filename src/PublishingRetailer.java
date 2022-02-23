import java.util.ArrayList;

public class PublishingRetailer {
    //identificator unic
    private int ID;
    //nume
    private String name;
    //lista de entitati publicabilie
    private ArrayList<IPublishingArtifact> publishingArtifacts;
    //lista cu tarile in care respectivul retailer publica
    private ArrayList<Countries> countries;

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

    public ArrayList<IPublishingArtifact> getPublishingArtifacts() {
        return publishingArtifacts;
    }

    public void setPublishingArtifacts(ArrayList<IPublishingArtifact> publishingArtifacts) {
        this.publishingArtifacts = publishingArtifacts;
    }

    public ArrayList<Countries> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<Countries> countries) {
        this.countries = countries;
    }
}
