package managers;

import models.Epic;
import models.SubTask;
import models.Task;
import models.TaskStatus;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public interface TaskManager {
    List<Task> getAllTasks();

    List<Epic> getAllEpics();

    List<SubTask> getAllSubTasks();

    void clearTaskList();

    void clearEpicTaskList();

    void clearSubTaskList();

    Task getTaskByID(int identifier);

    Epic getEpicTaskByID(int identifier);

    SubTask getSubTaskByID(int identifier);

    void addTask(Task task);

    void addEpic(Epic epic);

    void addSubTask(SubTask subTask);

    void updateTask(@NotNull Task task);

    void updateEpic(@NotNull Epic epic);

    void updateSubTask(@NotNull SubTask subtask);

    void deleteTaskByID (int identifier);

    void deleteEpicByID (int identifier);

    void deleteSubTaskByID (int identifier);

    Map<Integer, SubTask> getEpicSubTasks (@NotNull Epic epic);

    void changeTaskStatus(@NotNull Task task, TaskStatus taskStatus);

    void changeSubTaskStatus(@NotNull SubTask subTask, TaskStatus taskStatus);

    List<Task> getViewingHistory();
}
