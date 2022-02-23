import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InitRetailersCountries {
    //returneaza retailer cu ID cautat
    public static PublishingRetailer searchRetailer (int ID, ArrayList<PublishingRetailer>retailers) {
        for (int i = 0; i < retailers.size(); i++) {
            PublishingRetailer auxRetailer = retailers.get(i);
            if (auxRetailer.getID() == ID) {
                return auxRetailer;
            }
        }
        return null;
    }
    //adauga tarile cu ID cautat in Retailer
    public static void addCountry (int ID, PublishingRetailer retailer, ArrayList<Countries> countries) {
        for (int i = 0; i < countries.size(); i++) {
            Countries auxCountry = countries.get(i);
            if (auxCountry.getID() == ID) {
                ArrayList<Countries> retailerCountries = retailer.getCountries();
                if (retailerCountries == null) {
                    retailerCountries = new ArrayList<Countries>();
                }
                retailerCountries.add(auxCountry);
                retailer.setCountries(retailerCountries);
            }
        }
    }
    public static void Read (ArrayList<PublishingRetailer> retailers, ArrayList<Countries> countries) {
        try {
            File myFile = new File("init/publishing-retailers-countries.in");
            Scanner myReader = new Scanner(myFile);

            int logic = 0;
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] split = line.split("###");
                if (logic != 0) {
                    int idRetailer = Integer.parseInt(split[0]);
                    int idCountry = Integer.parseInt(split[1]);
                    PublishingRetailer searchedRetailer = searchRetailer(idRetailer, retailers);
                    addCountry(idCountry, searchedRetailer,countries);
                }
                logic++;
            }
            myReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error InitRetailerCountry");
            ex.printStackTrace();
        }
    }
}
