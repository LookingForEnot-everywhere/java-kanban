package manager;

import java.util.HashMap;

import models.*;
import org.jetbrains.annotations.NotNull; /* IDEA предложила добавить аннотацию, что методы с апдейтом всегда работают
                                             с NotNull объектом, почитал про эту аннотацию, она повышает читаемость кода
                                             и показывает IDEA, что если кто-то передает туда null объект, то это
                                             неправильно. Подумал, что это уместно здесь */


public class TaskManager {
    public static int taskCount = 0;

    private final HashMap<Integer, Task> taskList = new HashMap<>();
    private final HashMap<Integer, Epic> epicList = new HashMap<>();
    private final HashMap<Integer, SubTask> subTaskList = new HashMap<>();


    public HashMap<Integer, Task> getAllTasks() {
        return taskList;
    }

    public HashMap<Integer, Epic> getAllEpics() {
        return epicList;
    }

    public HashMap<Integer, SubTask> getAllSubTasks() {
        return subTaskList;
    }

    public void clearTaskList() {
        taskList.clear();
    }

    public void clearEpicTaskList() {
        epicList.clear();
        subTaskList.clear();
    }

    public void clearSubTaskList() {
        subTaskList.clear();
    }

    public Task getTaskByID(int identifier) {
        return taskList.get(identifier);
    }

    public Epic getEpicTaskByID(int identifier) {
        return epicList.get(identifier);
    }

    public SubTask getSubTaskByID(int identifier) {
        return subTaskList.get(identifier);
    }

    public void addTask(Task task) {
        taskList.put(task.getIdentifier(), task);
    }

    public void addEpic(Epic epic) {
        epicList.put(epic.getIdentifier(), epic);
    }

    public void addSubTask(SubTask subTask) {
        subTaskList.put(subTask.getIdentifier(), subTask);
    }

    public void updateTask(@NotNull Task task) {
        taskList.get(task.getIdentifier()).setName(task.getName());
        taskList.get(task.getIdentifier()).setDescription(task.getDescription());
        taskList.get(task.getIdentifier()).setStatus(task.getStatus());
    }

    public void updateEpic(@NotNull Epic epic) {
        // Не обновляю поле с сабтасками, так как добавление сабтаска туда проводится при создании нового сабтаска
        epicList.get(epic.getIdentifier()).setName(epic.getName());
        epicList.get(epic.getIdentifier()).setDescription(epic.getDescription());
        epicList.get(epic.getIdentifier()).setStatus(epic.getStatus());
    }

    public void updateSubTask(@NotNull SubTask subtask) {
        // Не обновляю поле epicID, так как в ТЗ не было пункта про возможность изменения эпика у сабтакса, посчитал,
        // что лишнее
        subTaskList.get(subtask.getIdentifier()).setName(subtask.getName());
        subTaskList.get(subtask.getIdentifier()).setDescription(subtask.getDescription());
        subTaskList.get(subtask.getIdentifier()).setStatus(subtask.getStatus());
    }

    public void deleteTaskByID (int identifier) {
        taskList.remove(identifier);
    }

    public void deleteEpicByID (int identifier) {
        HashMap<Integer, SubTask> epicsSubTaskList = epicList.get(identifier).getEpicsSubTaskList();

        for (Integer key : epicsSubTaskList.keySet()) {
            subTaskList.remove(key);
        }

        epicList.remove(identifier);
    }

    public void deleteSubTaskByID (int identifier) {
        subTaskList.remove(identifier);
    }

    public HashMap<Integer, SubTask> getEpicSubTasks (@NotNull Epic epic) {
        return epicList.get(epic.getIdentifier()).getEpicsSubTaskList();
    }

    public void changeTaskStatus(@NotNull Task task, TaskStatus taskStatus) {
        taskList.get(task.getIdentifier()).setStatus(taskStatus);
    }

    public void changeSubTaskStatus(@NotNull SubTask subTask, TaskStatus taskStatus) {
        subTaskList.get(subTask.getIdentifier()).setStatus(taskStatus);

        int epicId = subTaskList.get(subTask.getIdentifier()).getEpicID();
        epicList.get(epicId).setEpicStatus();
    }
}
