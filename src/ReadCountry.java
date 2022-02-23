import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCountry {
    public static ArrayList<Countries> Read() {
        ArrayList<Countries> countries = new ArrayList<Countries>();
        try {
            File myFile = new File("init/countries.in");
            Scanner myReader = new Scanner(myFile);

            int logic = 0;

            while(myReader.hasNextLine()) {
                Countries newCountry = new Countries();
                String line = myReader.nextLine();
                String[] split = line.split("###");
                if (logic != 0) {
                    newCountry.setID(Integer.parseInt(split[0]));
                    newCountry.setCountryCode(split[1]);
                    countries.add(newCountry);
                }
                logic++;
            }
            myReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error CountryRead");
            ex.printStackTrace();
        }
        return countries;
    }
}
