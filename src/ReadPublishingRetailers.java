import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadPublishingRetailers {
    public static ArrayList<PublishingRetailer> Read () {
        ArrayList<PublishingRetailer> retailers = new ArrayList<PublishingRetailer>();
        try {
            File myFile = new File("init/publishing-retailers.in");
            Scanner myReader = new Scanner(myFile);

            int logic = 0;
            while (myReader.hasNextLine()) {
                PublishingRetailer newRetailer = new PublishingRetailer();
                String line = myReader.nextLine();
                String[] split = line.split("###");
                if (logic != 0) {
                    newRetailer.setID(Integer.parseInt(split[0]));
                    newRetailer.setName(split[1]);
                    retailers.add(newRetailer);
                }
                logic++;
            }
            myReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error RetailerRead");
            ex.printStackTrace();
        }
        return retailers;
    }
}
