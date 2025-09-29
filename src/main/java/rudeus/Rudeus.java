package rudeus;

import rudeus.command.CommandManager;
import rudeus.ui.Ui;

public class Rudeus {
    public static void main(String[] args) {
        try {
            Ui.printGreetingMessage();
            CommandManager.readAndProcessUserInput();
        } catch (Exception e) {
            Ui.printMessageWithBorders("An unexpected error occurred: " + e.getMessage());
        }
    }
}
