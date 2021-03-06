package employee.database;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Manage the connection to SQLite database
 */
public class DatabaseConnectionManager {

    private static final String DATABASE_JDBC_NAME = "org.sqlite.JDBC";
    private static final String DATABASE_SOURCE_TYPE = "jdbc:sqlite:";
    private static final String DATABASE_PATH = "./employees";
    private Connection connection;
    private static DatabaseConnectionManager instance;

    private DatabaseConnectionManager() {
    }

    public synchronized static DatabaseConnectionManager getDatabaseSource(){
        if(instance == null){
            instance = new DatabaseConnectionManager();
        }
        return instance;
    }

    /**
     *
     * @return Current database connection.
     */
    public Connection openConnection() {
        try {
            Class.forName(DATABASE_JDBC_NAME);
            connection = DriverManager.getConnection(DATABASE_SOURCE_TYPE + DATABASE_PATH);
        }
        catch ( SQLException ex ) {
            Logger.getLogger(DatabaseConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch ( ClassNotFoundException ex ) {
            Logger.getLogger(DatabaseConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    /**
     * Closes database current connection.
     */
    public void closeConnection() {
        try {
            connection.close();
        }
        catch ( SQLException ex ) {
            Logger.getLogger(DatabaseConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}