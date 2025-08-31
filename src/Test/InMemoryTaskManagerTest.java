package Test;

import managers.Managers;
import managers.TaskManager;
import models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryTaskManagerTest {
    private static TaskManager taskManager;
    private static Task task;
    private static Epic epic;
    private static SubTask subTask;

    @BeforeEach
    void BeforeEach() {
        taskManager = Managers.getDefault();
        task = new Task(1, "Some new task", "Some new task description");
        taskManager.addTask(task);
        epic = new Epic(2, "Some new epic", "Some new epic description");
        taskManager.addEpic(epic);
        subTask = new SubTask(3, "Some new subtask",
                "Some new subtask description", epic);
        taskManager.addSubTask(subTask);
    }

    @Test
    void shouldBeCreatedInMemoryTaskManagerAndInMemoryHistoryManager() {
        TaskManager otherTaskManager = Managers.getDefault();
        assertNotNull(otherTaskManager, "Tasks Managers Was Not Created");
    }

    @Test
    void shouldReturnAllTasks() {
        assertNotNull(taskManager.getAllTasks(), "Tasks List Was Not Returned");
    }

    @Test
    void shouldReturnAllEpics() {
        assertNotNull(taskManager.getAllEpics(), "Epics List Was Not Returned");
    }

    @Test
    void shouldReturnAllSubTasks() {
        assertNotNull(taskManager.getAllSubTasks(), "Subtasks List Was Not Returned");
    }

    @Test
    void shouldClearTaskList() {
        taskManager.clearTaskList();
        assertTrue(taskManager.getAllTasks().isEmpty(), "Tasks List Was Not Cleared");
    }

    @Test
    void shouldClearEpicList() {
        taskManager.clearEpicTaskList();
        assertTrue(taskManager.getAllEpics().isEmpty(), "Epic List Was Not Cleared");
        assertTrue(taskManager.getAllSubTasks().isEmpty(), "Subtasks List Was Not Cleared By Clearing Epics");
    }

    @Test
    void shouldClearSubTaskList() {
        taskManager.clearSubTaskList();
        assertTrue(taskManager.getAllSubTasks().isEmpty(), "Subtasks List Was Not Cleared");
    }

    @Test
    void shouldReturnTaskByID() {
        assertNotNull(taskManager.getTaskByID(task.getIdentifier()), "Task Wasn't Returned");
    }

    @Test
    void shouldReturnEpicByID() {
        assertNotNull(taskManager.getEpicTaskByID(epic.getIdentifier()), "Epic Wasn't Returned");
    }

    @Test
    void shouldReturnSubTaskByID() {
        assertNotNull(taskManager.getSubTaskByID(subTask.getIdentifier()), "Subtask Wasn't Returned");
    }

    @Test
    void shouldAddTask() {
        taskManager.clearTaskList();
        taskManager.addTask(task);
        assertFalse(taskManager.getAllTasks().isEmpty(), "Task Wasn't Added");
    }

    @Test
    void shouldAddEpic() {
        taskManager.clearEpicTaskList();
        taskManager.addEpic(epic);
        assertFalse(taskManager.getAllEpics().isEmpty(), "Epic Wasn't Added");
    }

    @Test
    void shouldAddSubTask() {
        taskManager.clearSubTaskList();
        taskManager.addSubTask(subTask);
        assertFalse(taskManager.getAllSubTasks().isEmpty(), "Subtask Wasn't Added");
    }

    @Test
    void shouldUpdateTask() {
        Task otherTask = new Task(1, "Some new other task", "Some new other task description");
        otherTask.setStatus(TaskStatus.IN_PROGRESS);
        taskManager.updateTask(otherTask);
        assertEquals(otherTask.getName(), task.getName(), "Task Name Wasn't Update");
        assertEquals(otherTask.getDescription(), task.getDescription(), "Task Description Wasn't Update");
        assertEquals(otherTask.getStatus(), task.getStatus(), "Task Status Wasn't Update");
    }

    @Test
    void shouldUpdateEpic() {
        Epic otherTask = new Epic(2, "Some new other task", "Some new other task description");
        subTask.setStatus(TaskStatus.IN_PROGRESS);
        epic.setEpicStatus();
        taskManager.updateEpic(otherTask);
        assertEquals(otherTask.getName(), epic.getName(), "Epic Name Wasn't Update");
        assertEquals(otherTask.getDescription(), epic.getDescription(), "Epic Description Wasn't Update");
        assertEquals(otherTask.getStatus(), epic.getStatus(), "Epic Status Wasn't Update");
    }

    @Test
    void shouldUpdateSubTask() {
        SubTask otherTask = new SubTask(3, "Some new other task",
                "Some new other task description", epic);
        otherTask.setStatus(TaskStatus.IN_PROGRESS);
        taskManager.updateSubTask(otherTask);
        assertEquals(otherTask.getName(), subTask.getName(), "Subtask Name Wasn't Update");
        assertEquals(otherTask.getDescription(), subTask.getDescription(), "Subtask Description Wasn't Update");
        assertEquals(otherTask.getStatus(), subTask.getStatus(), "Subtask Status Wasn't Update");
    }

    @Test
    void shouldDeleteTaskByID() {
        taskManager.deleteTaskByID(task.getIdentifier());
        assertNull(taskManager.getTaskByID(task.getIdentifier()), "Task Wasn't Deleted By ID");
    }

    @Test
    void shouldDeleteEpicByID() {
        taskManager.deleteEpicByID(epic.getIdentifier());
        assertNull(taskManager.getEpicTaskByID(epic.getIdentifier()), "Epic Wasn't Deleted By ID");
    }

    @Test
    void shouldDeleteSubTaskByID() {
        taskManager.deleteSubTaskByID(subTask.getIdentifier());
        assertNull(taskManager.getSubTaskByID(subTask.getIdentifier()), "Subtask Wasn't Deleted By ID");
    }

    @Test
    void shouldReturnEpicSubTasks() {
        assertNotNull(taskManager.getEpicSubTasks(epic), "Epic Subtasks Wasn't Returned");
    }

    @Test
    void shouldChangeTaskStatus() {
        taskManager.changeTaskStatus(task, TaskStatus.IN_PROGRESS);
        assertEquals(TaskStatus.IN_PROGRESS, task.getStatus(), "Task Status Wasn't Change At All");
    }

    @Test
    void shouldChangeSubTaskStatus() {
        taskManager.changeSubTaskStatus(subTask, TaskStatus.IN_PROGRESS);
        assertEquals(TaskStatus.IN_PROGRESS, subTask.getStatus(), "Subtask Status Wasn't Change At All");
    }

    @Test
    void shouldReturnViewingHistory() {
        assertNotNull(taskManager.getViewingHistory());
    }
}