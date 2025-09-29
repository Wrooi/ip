import java.util.Scanner;

public class CommandManager {
    private enum CommandType {
        BYE, LIST, MARK, UNMARK, OTHER;

        public static CommandType fromString(String command) {
            switch (command) {
            case "bye":
                return BYE;
            case "list":
                return LIST;
            case "mark":
                return MARK;
            case "unmark":
                return UNMARK;
            default:
                return OTHER;
            }
        }
    }

    public static void readAndProcessUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        while (true) {
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
                try {
                    int idx = Integer.parseInt(args) - 1;
                    TaskManager.markTaskIsDone(idx, true);
                } catch (NumberFormatException e) {
                    Ui.printMessageWithBorders("Please provide a valid task number to mark.");
                }
                break;
            case UNMARK:
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
            }
        }
    }
}
