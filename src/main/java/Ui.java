public class Ui {
    public static final int MAX_INDENT_LEVEL = 4;

    public static void printWithIndents(String message) {
        String indent = " ".repeat(MAX_INDENT_LEVEL);
        System.out.println(indent + message);
    }

    public static void printMessageWithBorders(String message) {
        String border = "──────────────────────────────────────────────────────────────────────────";
        printWithIndents(border);
        printWithIndents(message);
        printWithIndents(border);
    }

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

