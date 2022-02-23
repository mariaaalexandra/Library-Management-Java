import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadLanguages {
    public static ArrayList<Language> Read() {
        ArrayList<Language> languages = new ArrayList<Language>();
        try {
            File myFile = new File("init/languages.in");
            Scanner myReader = new Scanner(myFile);

            int logic = 0;
            while (myReader.hasNextLine()) {
                Language newLanguage = new Language();
                String line = myReader.nextLine();
                String[] split = line.split("###");
                if (logic != 0) {
                    newLanguage.setID(Integer.parseInt(split[0]));
                    newLanguage.setCode(split[1]);
                    newLanguage.setName(split[2]);
                    languages.add(newLanguage);
                }
                logic++;
            }
            myReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error LanguageRead");
            ex.printStackTrace();
        }
        return languages;
    }
}
