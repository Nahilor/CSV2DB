package csv2db;
import java.io.IOException;
import java.util.List;
import csv2db.CsvParser;
import csv2db.VehiclePostion;
/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException{
        CsvParser csvParser = new CsvParser("../../../../data/vehicles.csv");
        csvParser.readContent();
        csvParser.parse();

        System.out.println(csvParser.getContent().size());
        System.out.println(csvParser.getSuccessfulParse());
        System.out.println(csvParser.getFailedParse());

        List<VehiclePostion> vehiclePostions = csvParser.getVehiclePostionsAll();
        System.out.println(vehiclePostions.size());
        // for (VehiclePostion vp : vehiclePostions) {
        //     System.out.println(vp.getVehicle_id() + " " + vp.getLatitude() + " " + vp.getLongitude() + " " + vp.getTimestamp() + " " + vp.getRoute_id() + " " + vp.getSpeed());
        // }
    }
}
