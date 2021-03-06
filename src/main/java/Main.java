import java.sql.SQLException;

/**
 * Created by Piotr Czubkowski on 2017-05-17.
 */
public class Main {

    public static void main(String[] args) {

        do {
            switch (Menu.showMenu()) {
                case 1:
                    try {
                        User.addUser(DataBase.baseConnection());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    try {
                        Book.addBook(DataBase.baseConnection());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    try {
                        Rent.addRent(DataBase.baseConnection());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 4:
                    try {
                        Rent.addEndRent(DataBase.baseConnection());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;


                case 5:
                    try {
                        User.showUsers(DataBase.baseConnection());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 6:
                    try {
                        Book.showBooks(DataBase.baseConnection());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 7:
                    try {
                        Rent.showRents(DataBase.baseConnection());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 8:
                    System.exit(0);
                    break;
            }

        } while (true);
    }
}
