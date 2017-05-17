import java.sql.*;
import java.util.Scanner;

/**
 * Created by Piotr Czubkowski on 2017-05-17.
 */
public class Book {
    static void addBook(Connection connection) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the title of the book: ");
        String title = scanner.nextLine();
        System.out.println("provide the book's author: ");
        String author = scanner.nextLine();
        System.out.println("Specify the number of pages in the book: ");
        int pages = scanner.nextInt();

        String sql = "INSERT INTO book(title, author, pages) VALUES(?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, title);
        statement.setString(2, author);
        statement.setInt(3, pages);
        statement.execute();
        statement.close();

        System.out.println("A book has been added to the database");
    }

    static void showBooks(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet bookResult = statement.executeQuery("SELECT * FROM book");
        while (bookResult.next()) {
            System.out.println("---------------------------------------");
            System.out.println("Id: " + bookResult.getString("id"));
            System.out.println("title: " + bookResult.getString("title"));
            System.out.println("Author: " + bookResult.getString("author"));
            System.out.println("Number of pages: " + bookResult.getInt("pages"));
            System.out.println("---------------------------------------");
        }
        bookResult.close();

    }

}