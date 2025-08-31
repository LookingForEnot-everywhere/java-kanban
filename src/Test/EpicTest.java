package Test;

import models.Epic;
import models.SubTask;
import models.TaskStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// В ТЗ есть требование проверить, что эпик нельзя добавить самого в себя,
// кажется, что в моей реализации это и так не удастся сделать, так как,
// добавить в эпик можно только сабтакс при создании самого сабтаска.
// Считать ли вообще такую реализацию ошибочной или наоборот я обезопасил
// свой код от такого добавления?

class EpicTest {
    private static SubTask subTask;
    private static Epic epic;

    @BeforeEach
    public void beforeEach() {
        epic = new Epic(1, "Some new epic task", "Some new description");
        subTask = new SubTask(2, "Some new task", "Some new description", epic);
    }

    @Test
    void shouldAddSubTaskToEpic() {
        int subTaskIdentifier = subTask.getIdentifier();
        epic.addSubTask(subTask);
        SubTask otherSubTask = epic.getEpicsSubTaskList().get(subTaskIdentifier);
        assertFalse(epic.getEpicsSubTaskList().isEmpty(), "Subtasks List Is Empty");
        assertTrue(subTask.equals(otherSubTask));
    }

    @Test
    void shouldReturnEpicsSubTaskList() {
        assertNotNull(epic.getEpicsSubTaskList());
    }

    @Test
    void shouldCorrectlySetEpicStatus() {
        epic.addSubTask(subTask);
        epic.setEpicStatus();
        assertEquals(TaskStatus.NEW, epic.getStatus(), "Incorrect Status After Creating");

        subTask.setStatus(TaskStatus.IN_PROGRESS);
        epic.setEpicStatus();
        assertEquals(TaskStatus.IN_PROGRESS, epic.getStatus(), "Incorrect Status After Change Subtask Status");
    }

    @Test
    void shouldGetValidToStringValue() {
        String taskToString = "ID: \"1\",\nTask: \"Some new epic task\",\nDescription: \"Some new description\",\n" +
                "Status: \"New\",\nSubtask list:{\n";
        for (Integer key : epic.getEpicsSubTaskList().keySet()) {
            taskToString += "\n" +epic.getEpicsSubTaskList().get(key).toString();
        }
        taskToString += "\n};";
        assertEquals(taskToString, epic.toString(), "Not Equal To String Output");
    }

    @Test
    void shouldBeEqualsIfHaveSameID() {
        Epic otherTask = new Epic (1, "Some new other task", "Some new other task description");
        assertTrue(epic.equals(otherTask));
    }
}