import java.util.Scanner;

public class CommandManager {
    private enum CommandType {
        BYE, LIST, MARK, UNMARK, OTHER;

        public static CommandType fromString(String command) {
            return switch (command) {
            case "bye" -> BYE;
            case "list" -> LIST;
            case "mark" -> MARK;
            case "unmark" -> UNMARK;
            default -> OTHER;
            };
        }
    }

    /**
     * Reads and processes user input commands in a loop until the "bye" command is
     * received.
     */
    public static void readAndProcessUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        while (true) {
            try {
                userInput = scanner.nextLine().trim();
                if (userInput.isEmpty()) {
                    continue;
                }
                String[] split = userInput.split(" ", 2);
                String command = split[0].toLowerCase();
                String args = split.length > 1 ? split[1].trim() : "";

                CommandType commandType = CommandType.fromString(command);

                switch (commandType) {
                case BYE:
                    Ui.printMessageWithBorders("See you around! Don’t get into too much trouble without me!");
                    scanner.close();
                    return;
                case LIST:
                    TaskManager.printTaskList();
                    break;
                case MARK:
                    if (args.isEmpty()) {
                        Ui.printMessageWithBorders("Please provide a task number to mark.");
                        break;
                    }
                    try {
                        int idx = Integer.parseInt(args) - 1;
                        TaskManager.markTaskIsDone(idx, true);
                    } catch (NumberFormatException e) {
                        Ui.printMessageWithBorders("Please provide a valid task number to mark.");
                    }
                    break;
                case UNMARK:
                    if (args.isEmpty()) {
                        Ui.printMessageWithBorders("Please provide a task number to unmark.");
                        break;
                    }
                    try {
                        int idx = Integer.parseInt(args) - 1;
                        TaskManager.markTaskIsDone(idx, false);
                    } catch (NumberFormatException e) {
                        Ui.printMessageWithBorders("Please provide a valid task number to unmark.");
                    }
                    break;
                case OTHER:
                    TaskManager.addTask(userInput);
                    break;
                default:
                    // Defensive: code should not reach here, but handle gracefully
                    Ui.printMessageWithBorders("Unknown command. Please try again.");
                    break;
                }
            } catch (Exception e) {
                Ui.printMessageWithBorders("An error occurred while processing your command: " + e.getMessage());
            }
        }
    }
}
