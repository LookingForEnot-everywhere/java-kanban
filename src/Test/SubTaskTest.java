package Test;

import models.SubTask;
import models.Epic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Тут кажется идентично проверке эпика на становление эпиком самому себе
// Из-за особенности реализации передача сабтаска в качестве эпика
// при создании нового сабтаска невозможно, так как, ожидается тип эпика
// Это же не должно вызвать каких-то проблем, верно?

class SubTaskTest {
    private static SubTask subTask;
    private static final Epic epic = new Epic(1, "Some new epic task",
            "Some new description");

    @BeforeEach
    public void beforeEach() {
        subTask = new SubTask(2, "Some new task", "Some new description", epic);
    }

    @Test
    void shouldReturnValidEpicID() {
        assertEquals(1, subTask.getEpicID(), "Not Valid Epic Id Return");
    }

    @Test
    void shouldGetValidToStringValue() {
        String taskToString = "ID: \"2\",\nTask: \"Some new task\",\nDescription: \"Some new description\",\n" +
                "Status: \"New\",\nEpic ID: \"1\".";
        assertEquals(taskToString, subTask.toString(), "Not Equal To String Output");
    }

    @Test
    void shouldBeEqualsIfHaveSameID() {
        SubTask otherTask = new SubTask (2, "Some new other task",
                "Some new other task description", epic);
        assertTrue(subTask.equals(otherTask));
    }
}