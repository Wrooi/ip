public class Parser {
    /**
     * Parses user input and returns the corresponding Task.
     *
     * @param userInput The user input string.
     * @return Task object corresponding to the input.
     * @throws IllegalArgumentException if the input is invalid.
     */
    public static Task parseTask(String userInput) {
        String trimmedInput = userInput.trim();
        String[] split = trimmedInput.split(" ", 2);
        String command = split[0];
        String args = split.length > 1 ? split[1].trim() : "";

        switch (command) {
        case "todo":
            if (args.isEmpty()) {
                throw new IllegalArgumentException("The description of a todo cannot be empty.");
            }
            return new Todo(args);
        case "deadline":
            String[] parts = args.split(" /by ", 2);
            if (parts.length < 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
                throw new IllegalArgumentException("Usage: deadline <desc> /by <date>");
            }
            return new Deadline(parts[0].trim(), parts[1].trim());
        case "event":
            String[] firstSplit = args.split(" /from ", 2);
            if (firstSplit.length < 2) {
                throw new IllegalArgumentException("Usage: event <desc> /from <start> /to <end>");
            }
            String desc = firstSplit[0].trim();
            String[] secondSplit = firstSplit[1].split(" /to ", 2);
            if (secondSplit.length < 2 || desc.isEmpty() || secondSplit[0].trim().isEmpty()
                    || secondSplit[1].trim().isEmpty()) {
                throw new IllegalArgumentException("Usage: event <desc> /from <start> /to <end>");
            }
            return new Event(desc, secondSplit[0].trim(), secondSplit[1].trim());
        default:
            return new Task(userInput);
        }
    }
}
