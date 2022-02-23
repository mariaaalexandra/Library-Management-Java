import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadEditorialGroup {
    public static ArrayList<EditorialGroup> Read () {
        ArrayList<EditorialGroup> editorialGroups = new ArrayList<EditorialGroup>();
        try {
            File myFile = new File("init/editorial-groups.in");
            Scanner myReader = new Scanner(myFile);

            int logic = 0;
            while (myReader.hasNextLine()) {
                EditorialGroup newGroup = new EditorialGroup();
                String line = myReader.nextLine();
                String[] split = line.split("###");
                if (logic != 0) {
                    newGroup.setID(Integer.parseInt(split[0]));
                    newGroup.setName(split[1]);
                    editorialGroups.add(newGroup);
                }
                logic++;
            }
            myReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error EditorialGroupRead");
            ex.printStackTrace();
        }
        return editorialGroups;
    }
}
