import java.util.Vector;

public class TaskManager {
    private static final Vector<Task> taskList = new Vector<>();

    public static void addTask(String userInput) {
        try {
            Task task = Parser.parseTask(userInput);
            taskList.add(task);
            Ui.printMessageWithBorders("added: " + taskList.lastElement());
        } catch (IllegalArgumentException e) {
            Ui.printMessageWithBorders(e.getMessage());
        }
    }

    /**
     * Prints the list of tasks with proper indentation.
     */
    public static void printTaskList() {
        if (taskList.isEmpty()) {
            Ui.printMessageWithBorders("No tasks available.");
            return;
        }
        StringBuilder taskListMessage = new StringBuilder("Here are the tasks in your list:\n");
        String indent = " ".repeat(Ui.MAX_INDENT_LEVEL); // 4 spaces per indent level
        for (int i = 0; i < taskList.size(); i++) {
            taskListMessage.append(indent)
                    .append((i + 1))
                    .append(". ")
                    .append(taskList.get(i).toString())
                    .append("\n");
        }
        Ui.printMessageWithBorders(taskListMessage.toString().trim());
    }

    public static void markTaskIsDone(int index, boolean isDone) {
        String extraIndent = " ".repeat(Ui.MAX_INDENT_LEVEL + 2); // 6 spaces per indent level
        if (index < 0 || index >= taskList.size()) {
            Ui.printMessageWithBorders("Invalid task number.");
            return;
        }
        if (isDone) {
            if (taskList.get(index).getIsDone()) {
                Ui.printMessageWithBorders("Task is already marked as done:\n" + extraIndent + taskList.get(index));
            } else {
                taskList.get(index).setIsDone(true);
                Ui.printMessageWithBorders("Nice! I've marked this task as done:\n" + extraIndent
                        + taskList.get(index));
            }
        } else {
            if (!taskList.get(index).getIsDone()) {
                Ui.printMessageWithBorders("Task is already not marked as done:\n" + extraIndent + taskList.get(index));
            } else {
                taskList.get(index).setIsDone(false);
                Ui.printMessageWithBorders("OK, I've marked this task as not done yet:\n" + extraIndent
                        + taskList.get(index));
            }
        }
    }
}

