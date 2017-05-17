import java.sql.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Piotr Czubkowski on 2017-05-17.
 */
public class User {

    static void addUser(Connection connection) throws SQLException{
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give name: ");
        String name = scanner.nextLine();

        System.out.println("Give lastname: ");
        String lastName = scanner.nextLine();

        String telephoneNumber = "0";
        Boolean status;
        do {
            System.out.println("Give Your phone number: ");
            System.out.println("example phone number: +48 123 456 789");
            telephoneNumber = scanner.nextLine();

            Pattern tele = Pattern.compile("\\+[0-9]{2}( [0-9]{3}){3}");
            Matcher telephone = tele.matcher(telephoneNumber);
            if (telephone.matches()) {
                status = true;
            } else {
                System.out.println("Enter the phone number just like the pattern");
                status = false;
            }
        } while (status == false);

        String sql = "INSERT INTO user(name, lastname, number) VALUES(?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, lastName);
        statement.setString(3, telephoneNumber);
        statement.execute();
        statement.close();

        System.out.println("User add into base");
    }

    static void showUsers(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM user");

        while (resultSet.next()) {
            System.out.println("---------------------------------------");
            System.out.println("Id: " + resultSet.getString("id"));
            System.out.println("Name: " + resultSet.getString("name"));
            System.out.println("Lastname: " + resultSet.getString("lastname"));
            System.out.println("Phone number: " + resultSet.getString("number"));
            System.out.println("---------------------------------------");
        }
        resultSet.close();

    }

}
