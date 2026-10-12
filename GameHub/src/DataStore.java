import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class DataStore {

    public static DefaultTableModel pcModel =
        new DefaultTableModel(
            new String[]{"PC ID", "PC Name", "PC Type", "Price/Hour", "Status"}, 0);

    public static DefaultTableModel customerModel =
        new DefaultTableModel(
            new String[]{"Customer ID", "Customer Name", "Contact", "Email"}, 0);

    public static DefaultTableModel rentalModel =
        new DefaultTableModel(
            new String[]{"Rental ID", "Customer ID", "PC ID", "Hours", "Total"}, 0);
     private static final String URL =
            "jdbc:mysql://localhost:3306/gamehub";

    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}