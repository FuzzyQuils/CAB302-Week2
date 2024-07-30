package org.example;
import java.util.*;

public class toDoList {
    private User user;
    private boolean isRunning;

    /**
     * Initialises the To Do list with the specified user.
     */
    public toDoList (User user) {
        this.user = user;
        this.isRunning = true;
    }

    /**
     * Shows the menu to the user for interacting with the To Do list.
     */
    private void showMenu () {
        System.out.println("1. Show all items");
        System.out.println("2. Add an item");
        System.out.println("3. Mark an item as done");
        System.out.println("4. Mark an item as undone"); /* TODO: Shouldn't this be marked "not done?" */
        System.out.println("5. Delete an item");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        handleMenu(choice);
    }

    /**
     * The run method; basically a nested main() but for the user.
     */
    public void run () {
        while (isRunning) {
            showMenu();
        }
    }

    /**
     * Handles the choice made in showMenu by the user.
     * @param choice the user's choice, expressed as an integer.
     */
    public void handleMenu (int choice) {
        switch (choice) {
            case 1:
                onShowAllItems();
                break;
            case 2:
                onAddItem();
                break;
            case 3:
                onMarkAsDone();
                break;
            case 4:
                onMarkAsUndone();
                break;
            case 5:
                onDeleteItem();
                break;
            case 6:
                onExit();
                break;
            default:
                System.out.println("Invalid choice!");
                showMenu();
        }
    }

    /**
     * Displays all items to the user, with an additional marker to show if it's marked done or not
     * per entry.
     */
    public void onShowAllItems () {
        for (int i = 0; i < user.getToDoItems().size(); ++i) {
            ToDoItem item = user.getToDoItems().get(i);
            /** NOTE: This is a ternary operation, aka. another way of doing an if statement.
             * more or less, <condition> ? <outcome if true> : <outcome if false> is how it works.
             */
            System.out.println(i + (item.isDone() ? ". [X]" : ". [ ]") + item.getDescription());
        }
    }

    /**
     * Adds an item to the list after accepting a description from the user as input.
     * New entries are automatically marked undone.
     */
    public void onAddItem () {
        System.out.print("Enter the description of the item: ");
        Scanner scanner = new Scanner(System.in);
        String description = scanner.nextLine();
        user.getToDoItems().add(new ToDoItem(description));
    }

    /**
     * Marks an entry as done.
     * TODO: Test error handling if an invalid index is parsed in.
     */
    public void onMarkAsDone () {
        onShowAllItems();
        System.out.print("Enter the number of the item to mark as done: ");
        Scanner scanner = new Scanner(System.in);
        int itemNo = scanner.nextInt();
        try {
            user.getToDoItems().get(itemNo).markDone();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid item number!");
        }
    }

    /**
     * Marks an entry as undone.
     * TODO: Test error handling if an invalid index is parsed in.
     */
    public void onMarkAsUndone () {
        onShowAllItems();
        System.out.print("Enter the number of the item to mark as undone: ");
        Scanner scanner = new Scanner(System.in);
        int itemNo = scanner.nextInt();
        try {
            user.getToDoItems().get(itemNo).unmarkDone();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid item number!");
        }
    }

    /**
     * Deletes an entry.
     * TODO: Test error handling when an invalid index is parsed in.
     */
    public void onDeleteItem () {
        onShowAllItems();
        System.out.print("Enter the number of the item to delete: ");
        Scanner scanner = new Scanner(System.in);
        int itemNo = scanner.nextInt();
        try {
            user.getToDoItems().remove(user.getToDoItems().get(itemNo));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid item number!");
        }
    }

    /**
     * Exits this user's To Do List.
     * Sets isRunning to false, which results in run() stopping. 
     */
    public void onExit () {
        isRunning = false;
    }
}
