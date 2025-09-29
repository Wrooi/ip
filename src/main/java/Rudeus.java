import java.util.Scanner;

public class Rudeus {
    /**
     * Reads and processes user input in a loop until "bye" is entered.
     */
    public static void readAndProcessUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        do {
            userInput = scanner.nextLine().trim();
            if (userInput.equalsIgnoreCase("bye")) {
                break;
            } else if (userInput.equalsIgnoreCase("list")) {
                TaskManager.printTaskList();
            } else if (userInput.startsWith("mark ")) {
                try {
                    int idx = Integer.parseInt(userInput.substring(5).trim()) - 1; // Convert to zero-based index
                    TaskManager.markTaskIsDone(idx, true);
                } catch (NumberFormatException e) {
                    Ui.printMessageWithBorders("Please provide a valid task number to mark.");
                }
            } else if (userInput.startsWith("unmark ")) {
                try {
                    int idx = Integer.parseInt(userInput.substring(7).trim()) - 1; // Convert to zero-based index
                    TaskManager.markTaskIsDone(idx, false);
                } catch (NumberFormatException e) {
                    Ui.printMessageWithBorders("Please provide a valid task number to unmark.");
                }
            } else {
                TaskManager.addTask(userInput);
            }
        } while (true);
        Ui.printMessageWithBorders("See you around! Don’t get into too much trouble without me!");
        scanner.close();
    }

    public static void main(String[] args) {
        try {
            Ui.printGreetingMessage();
            readAndProcessUserInput();
        } catch (Exception e) {
            Ui.printMessageWithBorders("An unexpected error occurred: " + e.getMessage());
        }
    }
}
