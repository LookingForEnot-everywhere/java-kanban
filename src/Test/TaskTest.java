package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.*;

import static managers.InMemoryTaskManager.taskCount;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    private static Task task;

    @BeforeEach
    public void beforeEach() {
        task = new Task (1, "Some new task", "Some new description");
    }

    @Test
    void shouldHaveValidIdAfterCreated() {
        assertEquals(1,task.getIdentifier(), "Not Valid ID");
    }

    @Test
    void shouldHaveValidNameAfterCreated() {
        assertEquals("Some new task",task.getName(), "Not Valid Name");
    }

    @Test
    void shouldSetName() {
        task.setName("New name");
        assertEquals("New name",task.getName(), "Not Valid New Name");
    }

    @Test
    void shouldHaveValidDescription() {
        assertEquals("Some new description",task.getDescription(), "Not Valid Description");
    }

    @Test
    void setDescription() {
        task.setDescription("New description");
        assertEquals("New description",task.getDescription(), "Not Valid New Description");
    }

    @Test
    void shouldHaveValidStatus() {
        assertEquals(TaskStatus.NEW,task.getStatus(), "Not Valid Status");
    }

    @Test
    void shouldSetStatus() {
        task.setStatus(TaskStatus.IN_PROGRESS);
        assertEquals(TaskStatus.IN_PROGRESS,task.getStatus(), "Not Valid New Status");
    }

    @Test
    void shouldBeEqual() {
        Task task1 = new Task(1, "Some new task", "Some new description");
        assertTrue(task.equals(task1), "Fail To Equals");
    }

    @Test
    void shouldCalculateValidHashCode() {
        taskCount = 1;
        int hashCode = (17 + taskCount) * 31;
        assertEquals(hashCode, task.hashCode(), "Not Equal Hash Code");
        taskCount = 0;
    }

    @Test
    void shouldGetValidToStringValue() {
        String taskToString = "ID: \"1\",\nTask: \"Some new task\",\nDescription: \"Some new description\",\n" +
                "Status: \"New\".";
        assertEquals(taskToString, task.toString(), "Not Equal To String Output");
    }

    @Test
    void shouldBeEqualsIfHaveSameID() {
        Task otherTask = new Task (1, "Some new other task", "Some new other task description");
        assertTrue(task.equals(otherTask));
    }
}