package csv2db;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import csv2db.Database;


public class App {
    public static void main(String[] args) throws IOException{
        CsvParser csvParser = new CsvParser("data/vehicles.csv");
        csvParser.readContent();
        csvParser.parse();

        System.out.println("This is the number of rows parsed: " + csvParser.getContent().size());
        System.out.println("Successful parses: " + csvParser.getSuccessfulParse());
        System.out.println("Failed/skipped parses: " + csvParser.getFailedParse());

        try {
            Database database = new Database("jdbc:postgresql://localhost/", "postgres", "ambachew1234");
            database.checkHealth();
            final boolean tableExists = database.checkTableExists("Vehicles");
            System.out.println("Table 'Vehicles' exists: " + tableExists);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
