public class Ui {
    public static final int MAX_INDENT_LEVEL = 4;

    /**
     * Prints a message with a specified indentation level.
     *
     * @param message The message to be printed.
     */
    public static void printWithIndents(String message) {
        String indent = " ".repeat(MAX_INDENT_LEVEL);
        System.out.println(indent + message);
    }

    /**
     * Prints a message enclosed within borders for emphasis.
     *
     * @param message The message to be printed.
     */
    public static void printMessageWithBorders(String message) {
        String border = "──────────────────────────────────────────────────────────────────────────";
        printWithIndents(border);
        printWithIndents(message);
        printWithIndents(border);
    }

    /**
     * Prints a greeting message logo.
     */
    public static void printGreetingMessage() {
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
}

