import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InitRetailerGroup {
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
    //adauga artifactul grupului cu ID cautat in retailer
    public static void addArtifact (int ID, PublishingRetailer retailer, ArrayList<EditorialGroup> groups) {
        for (int i = 0; i < groups.size(); i++) {
            EditorialGroup auxGroup = groups.get(i);
            if (auxGroup.getID() == ID) {
                ArrayList<IPublishingArtifact> artifactGroup = retailer.getPublishingArtifacts();
                if (artifactGroup == null) {
                    artifactGroup = new ArrayList<IPublishingArtifact>();
                }
                artifactGroup.add(auxGroup);
                retailer.setPublishingArtifacts(artifactGroup);
            }
        }
    }
    public static void Read (ArrayList<PublishingRetailer> retailers, ArrayList<EditorialGroup>groups) {
        try {
            File myFile = new File("init/publishing-retailers-editorial-groups.in");
            Scanner myReader = new Scanner(myFile);

            int logic = 0;
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] split = line.split("###");
                if (logic != 0) {
                    int idRetailer = Integer.parseInt(split[0]);
                    int idGroup = Integer.parseInt(split[1]);
                    PublishingRetailer searchedRetailer = searchRetailer(idRetailer, retailers);
                    addArtifact(idGroup, searchedRetailer,groups);
                }
                logic++;
            }
            myReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error InitRetailerGroup");
            ex.printStackTrace();
        }
    }
}
