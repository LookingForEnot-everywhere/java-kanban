package Test;

import managers.Managers;
import managers.TaskManager;
import models.Task;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class InMemoryHistoryManagerTest {

    private static final TaskManager taskManager = Managers.getDefault();

    @Test
    void shouldReturnViewingHistory() {
        assertNotNull(taskManager.getViewingHistory(), "Not Valid Viewing History Return");
    }

    @Test
    void shouldAddToViewingHistory() {
        Task task = new Task(1, "Some new task", "Some new description");
        taskManager.addTask(task);
        taskManager.getTaskByID(task.getIdentifier());
        ArrayList<Task> listOfAddedTasks = taskManager.getViewingHistory();
        assertFalse(listOfAddedTasks.isEmpty(), "Task wasn't added");
    }
}