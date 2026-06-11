package csv2db;
import java.io.IOException;
import java.util.List;


public class App {
    public static void main(String[] args) throws IOException{
        CsvParser csvParser = new CsvParser("data/vehicles.csv");
        csvParser.readContent();
        csvParser.parse();

        System.out.println("This is the number of rows parsed: " + csvParser.getContent().size());
        System.out.println("Successful parses: " + csvParser.getSuccessfulParse());
        System.out.println("Failed parses: " + csvParser.getFailedParse());

        List<VehiclePostion> vehiclePostions = csvParser.getVehiclePostionsAll();
        System.out.println("Number of vehicle positions: " + vehiclePostions.size());
        // for (VehiclePostion vp : vehiclePostions) {
        //     System.out.println(vp.getVehicle_id() + " " + vp.getLatitude() + " " + vp.getLongitude() + " " + vp.getTimestamp() + " " + vp.getRoute_id() + " " + vp.getSpeed());
        // }
    }
}
