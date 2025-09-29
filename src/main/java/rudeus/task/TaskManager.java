package rudeus.task;

import java.util.ArrayList;
import java.util.List;

import rudeus.command.Parser;
import rudeus.storage.Storage;
import rudeus.ui.Ui;

public class TaskManager {
    private static final List<Task> taskList = new ArrayList<>();

    static {
        loadTasksFromFile();
    }

    /**
     * Loads tasks from file at startup.
     */
    public static void loadTasksFromFile() {
        List<Task> loaded = Storage.loadTasksFromFile();
        if (!loaded.isEmpty()) {
            taskList.clear();
            taskList.addAll(loaded);
        }
    }

    /**
     * Adds a task to the task list after parsing the user input.
     *
     * @param userInput The user input string containing task details.
     */
    public static void addTask(String userInput) {
        try {
            Task task = Parser.parseTask(userInput);
            taskList.add(task);
            Ui.printMessageWithBorders("added: " + taskList.get(taskList.size() - 1));
            Storage.saveTasksToFile(taskList);
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

    /**
     * Marks a task as done or not done based on the provided index and status.
     *
     * @param index  The index of the task in the task list (0-based).
     * @param isDone True to mark as done, false to mark as not done.
     */
    public static void markTaskIsDone(int index, boolean isDone) {
        String extraIndent = " ".repeat(Ui.MAX_INDENT_LEVEL + 2); // 6 spaces per indent level
        if (index < 0 || index >= taskList.size()) {
            Ui.printMessageWithBorders("Oi! That task number doesn't even exist. Are you trying to trick me?");
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
        Storage.saveTasksToFile(taskList);
    }
}
