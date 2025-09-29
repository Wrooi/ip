import java.util.Scanner;

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
