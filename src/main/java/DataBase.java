import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Piotr Czubkowski on 2017-05-17.
 */
public class DataBase {

    private static final String DB = "";
    private static final String USER = "";
    private static final String USERPW = "";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    static Connection baseConnection() {

        Connection connection = null;

        try {
            Class.forName(DRIVER).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = (Connection) DriverManager.getConnection(DB, USER, USERPW);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}