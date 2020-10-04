package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class contains variables and methods that controls the connection with Oracle Databases.
 */
public class OracleDriverFactory {

    private static Connection conn;
    private static final String db_url = "jdbc:oracle:thin:@conciliador-bd-hg.getnet.local:1521/CONCHGSRV";
    private static final String username = "dbauttar_portal";
    private static final String password = "aHyXw$vvzfTOzOX";

    /**
     * This method creates a instance of connection with Oracle Database.
     * @return Connection Instance with the Database.
     */
    public static Connection connectoToOracleDb() {
        try {

            conn = DriverManager.getConnection(db_url, username, password);

            if (conn != null) {
                return conn;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Report.logFail("Ocorreu erro ao conectar no banco de dado.");
        }
        return null;
    }

    /**
     * This method close the connection with Oracle Databases.
     */
    public static void closeConnection(){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
