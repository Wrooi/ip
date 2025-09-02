import java.util.Scanner;

public class Rudeus {
    private static final int MAX_INDENT_LEVEL = 4; // Maximum indent level

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

    public static void main(String[] args) {
        String logo =
                "┌────────────────────────────────────────────────────────────────────────┐\n" +
                        "│ ░█████████  ░██     ░██ ░███████   ░██████████ ░██     ░██   ░██████   │\n" +
                        "│ ░██     ░██ ░██     ░██ ░██   ░██  ░██         ░██     ░██  ░██   ░██  │\n" +
                        "│ ░██     ░██ ░██     ░██ ░██    ░██ ░██         ░██     ░██ ░██         │\n" +
                        "│ ░█████████  ░██     ░██ ░██    ░██ ░█████████  ░██     ░██  ░████████  │\n" +
                        "│ ░██   ░██   ░██     ░██ ░██    ░██ ░██         ░██     ░██         ░██ │\n" +
                        "│ ░██    ░██   ░██   ░██  ░██   ░██  ░██          ░██   ░██   ░██   ░██  │\n" +
                        "│ ░██     ░██   ░██████   ░███████   ░██████████   ░██████     ░██████   │\n" +
                        "└────────────────────────────────────────────────────────────────────────┘\n";
        System.out.println("Yo! The name's \n" + logo + "At your service, as always. Need some magic—or maybe just a hand? Ask away!\n" +
                "──────────────────────────────────────────────────────────────────────────");

        Scanner scanner = new Scanner(System.in);
        String userInput;
        do {
            userInput = scanner.nextLine().trim();
            if (userInput.equalsIgnoreCase("bye")) {
                break;
            }
            printMessageWithBorders(userInput, true);
        } while (true);
        scanner.close();

        printMessageWithBorders("See you around! Don’t get into too much trouble without me!", true);
    }
}
