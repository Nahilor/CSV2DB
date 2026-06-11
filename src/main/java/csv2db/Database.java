/* Database class for managing database connections and queries 
*  Resources: 
*       https://medium.com/@ValentinMouret/batch-inserts-in-postgresql-1b65f083fdc
*       https://jdbc.postgresql.org/documentation/use/
*       https://www.deshbandhucollege.ac.in/pdf/e-resources/computer-science/Bsc(P)-VI-InternetTechnologies-3.pdf
*/
// I am thinking that the user of this class should not be woring about error handling, so I will catch the exceptions in this class and print the error messages, instead of throwing the exceptions to the caller. 
// This way, the caller can focus on using the methods in this class without worrying about error handling. 
// However, I will still throw the exceptions to the caller for critical errors that cannot be handled in this class, such as connection errors.
// For other errors that can be handled in this class, such as query errors, I will catch the exceptions and print the error messages without throwing them to the caller. This way, the caller can still use the methods in this class without worrying about error handling, while still being informed about any errors that occur.
package csv2db;

import java.sql.*;

public class Database {
    private Connection connection = null; // this attribute shouldn't be directly accessed by the caller. thats why it is private. the caller should use the methods in this class to interact with the database, and not directly access the connection attribute.

    // Connection should be closed after use by the caller, so I will not close it in this class.
    // To close the connection, the caller calls a method in this class called closeConnection() that will close the connection.
    public Database(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    public void runQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(query);
    }

    public void batchProcessQuery(int batchSize, String query) {
        // TODO: Implement batch processing logic
    }


    public void checkHealth() {
        try {
            if (connection != null && connection.isValid(2)) {
                System.out.println("Database connection is healthy.");
            } else {
                System.out.println("Database connection is not healthy.");
            }
        } catch (SQLException e) {
            System.err.println("Error checking database health: " + e.getMessage());
        }
    }


    public boolean checkTableExists(String tableName) {
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, tableName, new String[] {"TABLE"});
            return resultSet.next();
        } catch (SQLException e) {
            System.err.println("Error checking if table exists: " + e.getMessage());
            return false;
        }
    }
    

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Error closing connection: " + e.getMessage());
        }
    }
}
