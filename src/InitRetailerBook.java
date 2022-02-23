import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InitRetailerBook {
    //returneaza retailer cu ID cautat
    public static PublishingRetailer searchRetailer (int ID, ArrayList<PublishingRetailer> retailers) {
        for (int i = 0; i < retailers.size(); i++) {
            PublishingRetailer auxRetailer = retailers.get(i);
            if (auxRetailer.getID() == ID) {
                return auxRetailer;
            }
        }
        return null;
    }
    //adauga artifactul cartii cu ID cautat in retailer
    public static void addArtifact (int ID, PublishingRetailer retailer, ArrayList<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            Book auxBook = books.get(i);
            if (auxBook.getID() == ID) {
                ArrayList<IPublishingArtifact> artifactBook = retailer.getPublishingArtifacts();
                if (artifactBook == null) {
                    artifactBook = new ArrayList<IPublishingArtifact>();
                }
                artifactBook.add(auxBook);
                retailer.setPublishingArtifacts(artifactBook);
            }
        }
    }

    public static void Read (ArrayList<PublishingRetailer> retailers, ArrayList<Book>books) {
        try {
            File myFile = new File("init/publishing-retailers-books.in");
            Scanner myReader = new Scanner(myFile);

            int logic = 0;
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] split = line.split("###");
                if (logic != 0) {
                    int idRetailer = Integer.parseInt(split[0]);
                    int idBook = Integer.parseInt(split[1]);
                    PublishingRetailer searchedRetailer = searchRetailer(idRetailer, retailers);
                    addArtifact(idBook, searchedRetailer, books);
                }
                logic++;
            }
            myReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error InitRetailerBook");
            ex.printStackTrace();
        }
    }
}
