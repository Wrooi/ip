package rudeus.storage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import rudeus.task.Deadline;
import rudeus.task.Event;
import rudeus.task.Task;
import rudeus.task.Todo;
import rudeus.ui.Ui;

public class Storage {
    // Update the save file path to the data directory
    private static final String SAVE_FILE_PATH = "./text-ui-test/tasks.txt";

    /**
     * Saves the list of tasks to a file.
     *
     * @param taskList The list of tasks to be saved.
     */
    public static void saveTasksToFile(List<Task> taskList) {
        try (FileWriter writer = new FileWriter(SAVE_FILE_PATH)) {
            for (Task task : taskList) {
                writer.write(serializeTask(task) + System.lineSeparator());
            }
        } catch (IOException e) {
            Ui.printMessageWithBorders("Failed to save tasks: " + e.getMessage());
        }
    }

    private static String serializeTask(Task task) {
        String type;
        if (task instanceof Todo) {
            type = "T";
        } else if (task instanceof Deadline) {
            type = "D";
        } else if (task instanceof Event) {
            type = "E";
        } else {
            type = "?";
        }
        String status = task.getIsDone() ? "1" : "0";
        String desc = task.getDescription();
        if (task instanceof Deadline) {
            return String.format("%s | %s | %s | %s", type, status, desc, (task)
                    .toString().replace("[D]" + task, "").trim());
        } else if (task instanceof Event) {
            return String.format("%s | %s | %s | %s", type, status, desc, (task)
                    .toString().replace("[E]" + task, "").trim());
        } else {
            return String.format("%s | %s | %s", type, status, desc);
        }
    }
}
