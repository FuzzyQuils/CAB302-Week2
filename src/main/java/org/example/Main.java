package org.example;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static ArrayList<User> users = new ArrayList<>();

    // Mock authentication; no hashing and salting passwords here!
    private static IAuthenticationService authService = new IAuthenticationService() {
        @Override
        public User signUp (String username, String password) {
            return null;
        }

        @Override
        public User logIn (String username, String password) {
            return users.get(0);
        }
    };
    private static boolean isRunning = true;

    /**
     * Application entrypoint.
     */
    public static void main (String[] args) {
        users.Add(new User("test", "test"));
        while (isRunning) {
            showMenu();
        }
    }

    /**
     * Displays the main menu to the user. Assumes stdout is a terminal window.
     */
    public static void showMenu () {
        System.out.println("Welcome to the To-Do List Application!");
        System.out.println("1. Login");
        System.out.println("2. Sign-up");
        System.out.println("3. Exit");
        System.out.print("Enter your choice:");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        handleMenu(choice);
    }

    /**
     * Handles the user's choice, which is a number entered in the prompt shown by showMenu()
     * @param choice the user's choice.
     */
    public static void handleMenu(int choice) {
        switch (choice) {
            case 1:
                onLogIn();
                break;
            case 2:
                onSignUp();
                break;
            case 3:
                onExit();
                break;
            default:
                System.out.println("Invalid choice!");
                showMenu();
        }
    }

    /**
     * Handles user logins and the post login operations.
     * TODO: post login operations.
     */
    public static void onLogIn () {
        System.out.print("Enter your username:");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.print("Enter your password:");
        String password = scanner.nextLine();
        User user = authService.logIn(username, password);
        System.out.println("Welcome, " + user.getUsername() + "!");
        /* TODO: add to-do list operations. */
    }

    /**
     * Handles the sign-up process.
     */
    public static void onSignUp () {
        System.out.print("Enter your username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        User user = authService.signUp(username, password);
        /* TODO: Show a message based on the result. */
    }

    /**
     * Exits the application by setting isRunning to false.
     */
    public static void onExit () {
        isRunning = false;
    }
}