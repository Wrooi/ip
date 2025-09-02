import java.util.Scanner;

public class Rudeus {
    private static final int MAX_INDENT_LEVEL = 4; // Maximum indent level
    private static final Task[] taskList = new Task[100]; // Array to store tasks
    private static int taskCount = 0; // Counter for tasks

    // Method to automatically print with indents
    private static void printWithIndents(String message) {
        String indent = " ".repeat(MAX_INDENT_LEVEL); // 4 spaces per indent level
        System.out.println(indent + message);
    }

    // Method to automatically print messages with borders
    private static void printMessageWithBorders(String message, boolean hasIndents) {
        String border = "──────────────────────────────────────────────────────────────────────────";
        if (hasIndents) {
            printWithIndents(border);
            printWithIndents(message);
            printWithIndents(border);
        } else {
            System.out.println(border);
            System.out.println(message);
            System.out.println(border);
        }
    }

    // Method to add a task to the task list
    private static void addTask(String description) {
        taskList[taskCount] = new Task(description);
        taskCount++;
        printMessageWithBorders("added: " + description, true);
    }

    // Method to print the task list
    private static void printTaskList() {
        if (taskCount == 0) {
            printMessageWithBorders("No tasks available.", true);
            return;
        }
        StringBuilder taskListMessage = new StringBuilder("Here are the tasks in your list:\n");
        String indent = " ".repeat(MAX_INDENT_LEVEL); // 4 spaces per indent level
        for (int i = 0; i < taskCount; i++) {
            taskListMessage.append(indent);
            taskListMessage.append((i + 1)).append(". ").append(taskList[i].getDescription()).append("\n");
        }
        printMessageWithBorders(taskListMessage.toString().trim(), true);
    }

    // Method to read and process user input
    public static void readAndProcessUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        do {
            userInput = scanner.nextLine().trim();
            if (userInput.equalsIgnoreCase("bye")) {
                break;
            } else if (userInput.equalsIgnoreCase("list")) {
                printTaskList();
            } else {
                addTask(userInput);
            }
        } while (true);
        printMessageWithBorders("See you around! Don’t get into too much trouble without me!", true);
        scanner.close();
    }

    // Method to print greeting message
    private static void printGreetingMessage() {
        String logo =
                "┌──────────────────────────────────────────────────────────────────────┐\n" +
                        "│░█████████  ░██     ░██ ░███████   ░██████████ ░██     ░██   ░██████  │\n" +
                        "│░██     ░██ ░██     ░██ ░██   ░██  ░██         ░██     ░██  ░██   ░██ │\n" +
                        "│░██     ░██ ░██     ░██ ░██    ░██ ░██         ░██     ░██ ░██        │\n" +
                        "│░█████████  ░██     ░██ ░██    ░██ ░█████████  ░██     ░██  ░████████ │\n" +
                        "│░██   ░██   ░██     ░██ ░██    ░██ ░██         ░██     ░██         ░██│\n" +
                        "│░██    ░██   ░██   ░██  ░██   ░██  ░██          ░██   ░██   ░██   ░██ │\n" +
                        "│░██     ░██   ░██████   ░███████   ░██████████   ░██████     ░██████  │\n" +
                        "└──────────────────────────────────────────────────────────────────────┘\n";
        System.out.println("Yo! The name's \n" + logo + "At your service, as always. Need some magic—or maybe just a hand? Ask away!\n" +
                "──────────────────────────────────────────────────────────────────────────");
    }

    public static void main(String[] args) {
        printGreetingMessage();
        readAndProcessUserInput();
    }
}
