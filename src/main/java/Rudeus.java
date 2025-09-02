import java.util.Scanner;

public class Rudeus {
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
                "──────────────────────────────────────────────────────────────────────────\n");
        Scanner scanner = new Scanner(System.in);
        String userInput;
        do{
            userInput = scanner.nextLine().trim();
            System.out.print("──────────────────────────────────────────────────────────────────────────\n");
            if(userInput.equalsIgnoreCase("bye")){
                break;
            }
            System.out.println(userInput);
            System.out.println("──────────────────────────────────────────────────────────────────────────\n");
        } while (true);
        scanner.close();

        System.out.println("See you around! Don’t get into too much trouble without me!\n" +
                "──────────────────────────────────────────────────────────────────────────");
    }
}
