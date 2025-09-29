package rudeus.storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

    /**
     * Loads the list of tasks from a file.
     *
     * @return The list of tasks loaded from the file.
     */
    public static List<Task> loadTasksFromFile() {
        List<Task> tasks = new ArrayList<>();
        File file = new File(SAVE_FILE_PATH);
        if (!file.exists()) {
            return tasks;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Task task = deserializeTask(line);
                if (task != null) {
                    tasks.add(task);
                }
            }
        } catch (IOException e) {
            Ui.printMessageWithBorders("Failed to load tasks: " + e.getMessage());
        }
        return tasks;
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
        if (task instanceof Deadline d) {
            return String.format("%s | %s | %s | %s", type, status, desc, d.toString()
                    .replace("[D]" + d, "").trim());
        } else if (task instanceof Event e) {
            return String.format("%s | %s | %s | %s", type, status, desc, e.toString()
                    .replace("[E]" + e, "").trim());
        } else {
            return String.format("%s | %s | %s", type, status, desc);
        }
    }

    private static Task deserializeTask(String line) {
        try {
            String[] parts = line.split(" \\| ");
            String type = parts[0];
            boolean isDone = "1".equals(parts[1]);
            String desc = parts[2];
            switch (type) {
            case "T":
                Todo todo = new Todo(desc);
                todo.setIsDone(isDone);
                return todo;
            case "D":
                if (parts.length < 4) {
                    return null;
                }
                Deadline deadline = new Deadline(desc, parts[3]);
                deadline.setIsDone(isDone);
                return deadline;
            case "E":
                if (parts.length < 4) {
                    return null;
                }
                // Try to extract from and to from the event string
                return getEvent(parts, desc, isDone);
            default:
                return null;
            }
        } catch (Exception e) {
            // Ignore malformed lines
            return null;
        }
    }

    private static Event getEvent(String[] parts, String desc, boolean isDone) {
        String eventInfo = parts[3];
        String from = "";
        String to = "";
        int fromIdx = eventInfo.indexOf("from:");
        int toIdx = eventInfo.indexOf("to:");
        if (fromIdx != -1 && toIdx != -1) {
            from = eventInfo.substring(fromIdx + 5, toIdx).trim();
            to = eventInfo.substring(toIdx + 3).trim();
        }
        Event event = new Event(desc, from, to);
        event.setIsDone(isDone);
        return event;
    }
}
