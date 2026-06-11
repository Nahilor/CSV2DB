package csv2db;
// This class will be responsible for parsing CSV files.
// and converts it into a more manageable format.
// To use this class, you will need to create an instance of it and then call the readContent() method to read the content of the CSV file. 
// After that, you can call the parse() method to parse the content and convert it into a list of VehiclePostion objects.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;


// This class will be responsible for parsing CSV files and converting them into a list of VehiclePostion objects.
// for now this class only can parse and convert this specific CSV file, but in the future it can be extended to parse and convert other CSV files as well.
// or at least that is a possibility, but for now it is not a requirement, so I will focus on parsing and converting this specific CSV file.
public class CsvParser {
    private Path filePath;
    private List<String> content;
    private int successfulParse = 0;
    private int failedParse = 0;
    private List<VehiclePostion> vehiclePostionsAll;
    private List<String> vehiclePostionsSuccessful;
    private List<String> vehiclePostionsFailed;
    
    public CsvParser(String filePath) {
        this.filePath = Path.of(filePath);
    }

    // This method will read the content of the CSV file and store it in a list of strings.
    public void readContent() throws IOException {
        content = new ArrayList<>();
        content = Files.readAllLines(filePath);
        content.remove(0); // remove the header line
    }


    // This method will parse the content of the CSV file and convert it into a list of VehiclePostion objects.
    public List<VehiclePostion> parse() {
        vehiclePostionsAll = new ArrayList<>();
        vehiclePostionsSuccessful = new ArrayList<>();
        vehiclePostionsFailed = new ArrayList<>();

        for (String vehiclepostion : content) {
            String[] attributes = vehiclepostion.split("[, | ; \t :]");
            int i = 0;
            VehiclePostion vp = new VehiclePostion();
            try {
                
                if (attributes.length != 6) {
                    failedParse++;
                    vehiclePostionsFailed.add(vehiclepostion);
                    continue;
                }
                vp.setVehicle_id(attributes[i++]);
                vp.setLatitude(Double.parseDouble(attributes[i++]));
                vp.setLongitude(Double.parseDouble(attributes[i++]));
                vp.setTimestamp(attributes[i++]);
                vp.setRoute_id(attributes[i++]);
                vp.setSpeed(Double.parseDouble(attributes[i++]));
                vehiclePostionsAll.add(vp);
                successfulParse++;
                vehiclePostionsSuccessful.add(vehiclepostion);
                } catch (Exception e) {
                    vehiclePostionsAll.add(null);
                    failedParse++;
                    vehiclePostionsFailed.add(vehiclepostion);
                }
            }

            return vehiclePostionsAll;
    }

    public List<String> getContent() {
        return this.content;
    }

    public Path getFilePath() {
        return this.filePath;
    }

    public int getSuccessfulParse() {
        return this.successfulParse;
    }

    public int getFailedParse() {
        return this.failedParse;
    }

    public List<String> getVehiclePostionsSuccessful() {
        return this.vehiclePostionsSuccessful;
    }

    public List<String> getVehiclePostionsFailed() {
        return this.vehiclePostionsFailed;
    }

    public List<VehiclePostion> getVehiclePostionsAll() {
        return this.vehiclePostionsAll;
    }

}
