import java.util.ArrayList;

public class Temperatures {
    String location;
    ArrayList<Integer> temperatures = new ArrayList<Integer>();

    // constructor to set location name and fill ArrayList
    public Temperatures(String toParse){

        String[] parsedArray = toParse.split(" ");
        String name = "";

        for (int i = 0; i < parsedArray.length; i++) {
            try {
                int num = Integer.parseInt(parsedArray[i]);
                temperatures.add(num);
            } catch (NumberFormatException nfe) {
                if (name.equals("")) name += parsedArray[i];
                else name = name + " " + parsedArray[i];
            }
        }
        location = name;
    }

    double averageTemperature(){ // works
        double averageTemp = 0;
        for (int i : temperatures) {
            averageTemp += i;
        }
        averageTemp = averageTemp / temperatures.size();
        return averageTemp;
    }
    double warmestTemperature(){
        double maxValue = temperatures.get(0);
        for(int i=0; i<temperatures.size(); i++){
            if(temperatures.get(i)> maxValue){
                maxValue = temperatures.get(i);
            }
        }
        return maxValue;
    }

    double coldestTemperature(){
        double minValue = temperatures.get(0);
        for(int i=0; i<temperatures.size(); i++){
            if(temperatures.get(i) < minValue){
                minValue = temperatures.get(i);
            }
        }
        return minValue;
    }

    double averageTemperatureWithoutExtremes(){
        double max = warmestTemperature();
        double min = coldestTemperature();

        double averageTemp = 0;
        for (int i=0; i<temperatures.size(); i++) {
            averageTemp += temperatures.get(i);
        }
        averageTemp = averageTemp - max - min;
        averageTemp = averageTemp / (temperatures.size() - 2);
        return averageTemp;
    }
}

