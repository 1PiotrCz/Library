import java.sql.*;
import java.util.Scanner;

/**
 * Created by Piotr Czubkowski on 2017-05-17.
 */
public class Rent {
    static void addRent(Connection connection) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Give id the book");
        int book = scanner.nextInt();

        System.out.println("Enter user id");
        int user = scanner.nextInt();

        System.out.println("Enter the rental time in days");
        int rentTime = scanner.nextInt();

        String sgl = "INSERT INTO rent(book, user, rentTime) VALUES(?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sgl);
        statement.setInt(1, book);
        statement.setInt(2, user);
        statement.setInt(3, rentTime);
        statement.execute();
        statement.close();

        System.out.println("Rental book - saved in database");
    }

    static void showRents(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet rentResult = statement.executeQuery("SELECT * FROM rent");
        while (rentResult.next()) {
            System.out.println("---------------------------------------");
            System.out.println("Id: " + rentResult.getString("id"));
            System.out.println("Id book: " + rentResult.getString("book"));
            System.out.println("Id user: " + rentResult.getString("user"));
            System.out.println("Date start of rental: " + rentResult.getDate("startRent"));

            if (rentResult.getInt("endRent") == 0) {
                System.out.println("Rental status - in progress");
            } else {
                System.out.println("Date end of rental: " + rentResult.getDate("endRent"));
            }

            System.out.println("Rental time in days: " + rentResult.getInt("rentTime"));
            System.out.println("---------------------------------------");
            System.out.println("Rental time: " + rentResult.getDate("startRent").equals(rentResult.getDate("endRent")));
        }
        rentResult.close();
    }

    static void addEndRent(Connection connection) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Give id the book");
        int idRent = scanner.nextInt();
        String sgl = "UPDATE `rent` SET `endRent`=LOCALTIMESTAMP WHERE `id`=" + Integer.valueOf(idRent);
        PreparedStatement statement = connection.prepareStatement(sgl);
        statement.execute();
        statement.close();

        System.out.println("Return the book - saved in database");
    }

}
