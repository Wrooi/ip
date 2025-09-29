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
                        Ui.printMessageWithBorders("Hold on! You forgot to tell me which task to mark. "
                                + "Even a genius like me needs a number!");
                        break;
                    }
                    try {
                        int idx = Integer.parseInt(args) - 1;
                        TaskManager.markTaskIsDone(idx, true);
                    } catch (NumberFormatException e) {
                        Ui.printMessageWithBorders("Nice try hehe, that's not a number! "
                                + "Try again with a proper task number, okay?");
                    }
                    break;
                case UNMARK:
                    if (args.isEmpty()) {
                        Ui.printMessageWithBorders("Which one did you want to unmark again? "
                                + "Give me a task number please!");
                        break;
                    }
                    try {
                        int idx = Integer.parseInt(args) - 1;
                        TaskManager.markTaskIsDone(idx, false);
                    } catch (NumberFormatException e) {
                        Ui.printMessageWithBorders("That's not a number, you know? "
                                + "Even I can't cast my magic on that!");
                    }
                    break;
                case OTHER:
                    String[] cmdSplit = userInput.split(" ", 2);
                    String firstWord = cmdSplit[0].toLowerCase();
                    if (!firstWord.equals("todo") && !firstWord.equals("deadline") && !firstWord.equals("event")) {
                        Ui.printMessageWithBorders("Hmm? Never heard of that spell! Try something I know, okay?");
                    } else {
                        TaskManager.addTask(userInput);
                    }
                    break;
                default:
                    Ui.printMessageWithBorders("Hmm? Never heard of that spell! Try something I know, okay?");
                    break;
                }
            } catch (Exception e) {
                Ui.printMessageWithBorders("Yikes! Something went wrong: " + e.getMessage()
                        + "\nEven I mess up sometimes. Try again!");
            }
        }
    }
}
