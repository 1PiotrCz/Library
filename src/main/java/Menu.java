import java.util.Scanner;

/**
 * Created by Piotr Czubkowski on 2017-05-17.
 */
public class Menu {

    static int showMenu() {

        System.out.println("┌-------------------------------┐");
        System.out.println("|             LIBRARY           |");
        System.out.println("|-------------------------------|");
        System.out.println("|    Choose one of the options  |");
        System.out.println("|-------------------------------|");
        System.out.println("|  1. Add user                  |");
        System.out.println("|  2. Add book                  |");
        System.out.println("|-------------------------------|");
        System.out.println("|  3. Rent a book               |");
        System.out.println("|  4. Give back the book        |");
        System.out.println("|-------------------------------|");
        System.out.println("|  5. View all users            |");
        System.out.println("|  6. View all books            |");
        System.out.println("|  7. View all rentals          |");
        System.out.println("|-------------------------------|");
        System.out.println("|  8. Exit program              |");
        System.out.println("└-------------------------------┘");

        Scanner scanner = new Scanner(System.in);
        int numb = scanner.nextInt();

        return numb;
    }

}

