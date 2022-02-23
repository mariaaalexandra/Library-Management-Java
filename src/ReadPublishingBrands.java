import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadPublishingBrands {
    public static ArrayList<PublishingBrand> Read() {
        ArrayList<PublishingBrand> brands = new ArrayList<PublishingBrand>();
        try {
            File myFile = new File("init/publishing-brands.in");
            Scanner myReader = new Scanner(myFile);

            int logic = 0;
            while (myReader.hasNextLine()) {
                PublishingBrand newBrand = new PublishingBrand();
                String line = myReader.nextLine();
                String[] split = line.split("###");
                if (logic != 0) {
                    newBrand.setID(Integer.parseInt(split[0]));
                    newBrand.setName(split[1]);
                    brands.add(newBrand);
                }
                logic++;
            }
            myReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error BrandRead");
            ex.printStackTrace();
        }
        return brands;
    }
}
