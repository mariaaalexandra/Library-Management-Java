import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InitRetailerBrand {
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
    //adauga artifactul brandului cu ID cautat in retailer
    public static void addArtifact (int ID, PublishingRetailer retailer, ArrayList<PublishingBrand> brands) {
        for (int i = 0; i < brands.size(); i++) {
            PublishingBrand auxBrand = brands.get(i);
            if (auxBrand.getID() == ID) {
                ArrayList<IPublishingArtifact> artifactBrands = retailer.getPublishingArtifacts();
                if (artifactBrands == null) {
                    artifactBrands = new ArrayList<IPublishingArtifact>();
                }
                artifactBrands.add(auxBrand);
                retailer.setPublishingArtifacts(artifactBrands);
            }
        }
    }
    public static void Read (ArrayList<PublishingRetailer> retailers, ArrayList<PublishingBrand>brands) {
        try {
            File myFile = new File("init/publishing-retailers-publishing-brands.in");
            Scanner myReader = new Scanner(myFile);

            int logic = 0;
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] split = line.split("###");
                if (logic != 0) {
                    int idRetailer = Integer.parseInt(split[0]);
                    int idBrand = Integer.parseInt(split[1]);
                    PublishingRetailer searchedRetailer = searchRetailer(idRetailer, retailers);
                    addArtifact(idBrand, searchedRetailer, brands);
                }
                logic++;
            }
            myReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error InitRetailerBrand");
            ex.printStackTrace();
        }
    }
}
