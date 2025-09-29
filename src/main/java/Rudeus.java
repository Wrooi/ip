import java.util.Scanner;
import java.util.Vector;

public class Rudeus {
    /**
     * Maximum indent level
     */
    private static final int MAX_INDENT_LEVEL = 4;
    /**
     * Vector to store tasks dynamically
     */
    private static final Vector<Task> taskList = new Vector<>();

    /**
     * Automatically prints a message with indents.
     *
     * @param message The message to print.
     */
    private static void printWithIndents(String message) {
        String indent = " ".repeat(MAX_INDENT_LEVEL); // 4 spaces per indent level
        System.out.println(indent + message);
    }

    /**
     * Automatically prints a message with borders.
     *
     * @param message The message to print.
     */
    private static void printMessageWithBorders(String message) {
        String border = "──────────────────────────────────────────────────────────────────────────";
        printWithIndents(border);
        printWithIndents(message);
        printWithIndents(border);
    }

    /**
     * Adds a task based on user input.
     *
     * @param userInput The user input string.
     */
    private static void addTask(String userInput) {
        try {
            if (userInput.startsWith("todo ")) {
                String desc = userInput.substring(5).trim();
                if (desc.isEmpty()) {
                    throw new IllegalArgumentException("The description of a todo cannot be empty.");
                }
                taskList.add(new Todo(desc));
                printMessageWithBorders("added: " + taskList.lastElement());
            } else if (userInput.startsWith("deadline ")) {
                String[] parts = userInput.substring(9).split(" /by ", 2);
                if (parts.length < 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
                    throw new IllegalArgumentException("Usage: deadline <desc> /by <date>");
                }
                taskList.add(new Deadline(parts[0].trim(), parts[1].trim()));
                printMessageWithBorders("added: " + taskList.lastElement());
            } else if (userInput.startsWith("event ")) {
                String[] firstSplit = userInput.substring(6).split(" /from ", 2);
                if (firstSplit.length < 2) {
                    throw new IllegalArgumentException("Usage: event <desc> /from <start> /to <end>");
                }
                String desc = firstSplit[0].trim();
                String[] secondSplit = firstSplit[1].split(" /to ", 2);
                if (secondSplit.length < 2 || desc.isEmpty() || secondSplit[0].trim().isEmpty()
                        || secondSplit[1].trim().isEmpty()) {
                    throw new IllegalArgumentException("Usage: event <desc> /from <start> /to <end>");
                }
                taskList.add(new Event(desc, secondSplit[0].trim(), secondSplit[1].trim()));
                printMessageWithBorders("added: " + taskList.lastElement());
            } else {
                taskList.add(new Task(userInput));
                printMessageWithBorders("added: " + userInput);
            }
        } catch (IllegalArgumentException e) {
            printMessageWithBorders(e.getMessage());
        }
    }

    /**
     * Prints the current task list.
     */
    private static void printTaskList() {
        if (taskList.isEmpty()) {
            printMessageWithBorders("No tasks available.");
            return;
        }
        StringBuilder taskListMessage = new StringBuilder("Here are the tasks in your list:\n");
        String indent = " ".repeat(MAX_INDENT_LEVEL); // 4 spaces per indent level
        for (int i = 0; i < taskList.size(); i++) {
            taskListMessage.append(indent)
                    .append((i + 1))
                    .append(". ")
                    .append(taskList.get(i).toString())
                    .append("\n");
        }
        printMessageWithBorders(taskListMessage.toString().trim());
    }

    /**
     * Marks a task as done or not done.
     *
     * @param index  The index of the task in the list (0-based).
     * @param isDone True to mark as done, false to mark as not done.
     */
    private static void markTaskIsDone(int index, boolean isDone) {
        String extraIndent = " ".repeat(MAX_INDENT_LEVEL + 2); // 6 spaces per indent level
        if (index < 0 || index >= taskList.size()) {
            printMessageWithBorders("Invalid task number.");
            return;
        }
        if (isDone) {
            if (taskList.get(index).getIsDone()) {
                printMessageWithBorders("Task is already marked as done:\n" + extraIndent + taskList.get(index));
            } else {
                taskList.get(index).setIsDone(true);
                printMessageWithBorders("Nice! I've marked this task as done:\n" + extraIndent + taskList.get(index));
            }
        } else {
            if (!taskList.get(index).getIsDone()) {
                printMessageWithBorders("Task is already not marked as done:\n" + extraIndent + taskList.get(index));
            } else {
                taskList.get(index).setIsDone(false);
                printMessageWithBorders("OK, I've marked this task as not done yet:\n" + extraIndent
                        + taskList.get(index));
            }
        }
    }

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
                printTaskList();
            } else if (userInput.startsWith("mark ")) {
                try {
                    int idx = Integer.parseInt(userInput.substring(5).trim()) - 1; // Convert to zero-based index
                    markTaskIsDone(idx, true);
                } catch (NumberFormatException e) {
                    printMessageWithBorders("Please provide a valid task number to mark.");
                }
            } else if (userInput.startsWith("unmark ")) {
                try {
                    int idx = Integer.parseInt(userInput.substring(7).trim()) - 1; // Convert to zero-based index
                    markTaskIsDone(idx, false);
                } catch (NumberFormatException e) {
                    printMessageWithBorders("Please provide a valid task number to unmark.");
                }
            } else {
                addTask(userInput);
            }
        } while (true);
        printMessageWithBorders("See you around! Don’t get into too much trouble without me!");
        scanner.close();
    }

    /**
     * Prints the greeting message.
     */
    private static void printGreetingMessage() {
        String logo =
                " ──────────────────────────────────────────────────────────────────────\n"
                        + "│░█████████  ░██     ░██ ░███████   ░██████████ ░██     ░██   ░██████  │\n"
                        + "│░██     ░██ ░██     ░██ ░██   ░██  ░██         ░██     ░██  ░██   ░██ │\n"
                        + "│░██     ░██ ░██     ░██ ░██    ░██ ░██         ░██     ░██ ░██        │\n"
                        + "│░█████████  ░██     ░██ ░██    ░██ ░█████████  ░██     ░██  ░████████ │\n"
                        + "│░██   ░██   ░██     ░██ ░██    ░██ ░██         ░██     ░██         ░██│\n"
                        + "│░██    ░██   ░██   ░██  ░██   ░██  ░██          ░██   ░██   ░██   ░██ │\n"
                        + "│░██     ░██   ░██████   ░███████   ░██████████   ░██████     ░██████  │\n"
                        + " ──────────────────────────────────────────────────────────────────────\n";
        System.out.println("Yo! The name's \n" + logo
                + "At your service, as always. Need some magic—or maybe just a hand? Ask away!\n"
                + "──────────────────────────────────────────────────────────────────────────");
    }

    public static void main(String[] args) {
        try {
            printGreetingMessage();
            readAndProcessUserInput();
        } catch (Exception e) {
            printMessageWithBorders("An unexpected error occurred: " + e.getMessage());
        }
    }
}
