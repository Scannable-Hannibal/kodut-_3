import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClimateControl {

    public static void main(String[] args) {

        // reading lines from file and put them in arraylist
        ArrayList<String> linesInText = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(new File("/Users/user/IdeaProjects/kodutöö_3/src/input_file.txt"));

            while (scanner.hasNextLine()) {
                linesInText.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // fetch data from list
        for(int i=0; i<linesInText.size();i++){
            Temperatures currentLocation = new Temperatures(linesInText.get(i));

            System.out.printf("In %s: \n", currentLocation.location);
            System.out.printf("the average temperature is %.1f.\n", currentLocation.averageTemperature());
            System.out.printf("the warmest temperature is %.1f.\n", currentLocation.warmestTemperature());
            System.out.printf("the coldest temperature is %.1f.\n", currentLocation.coldestTemperature());
            System.out.printf("the average temperature without extremes is %.1f.\n\n", currentLocation.averageTemperatureWithoutExtremes());
        }
    }
}
