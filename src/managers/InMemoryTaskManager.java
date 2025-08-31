package managers;

import java.util.ArrayList;
import java.util.HashMap;

import models.*;
import org.jetbrains.annotations.NotNull;


public class InMemoryTaskManager implements TaskManager{
    public static int taskCount = 0;

    private final HashMap<Integer, Task> taskList = new HashMap<>();
    private final HashMap<Integer, Epic> epicList = new HashMap<>();
    private final HashMap<Integer, SubTask> subTaskList = new HashMap<>();
    private final HistoryManager historyManager = Managers.getDefaultHistory();

    @Override
    public HashMap<Integer, Task> getAllTasks() {
        return taskList;
    }

    @Override
    public HashMap<Integer, Epic> getAllEpics() {
        return epicList;
    }

    @Override
    public HashMap<Integer, SubTask> getAllSubTasks() {
        return subTaskList;
    }

    @Override
    public void clearTaskList() {
        taskList.clear();
    }

    @Override
    public void clearEpicTaskList() {
        epicList.clear();
        subTaskList.clear();
    }

    @Override
    public void clearSubTaskList() {
        subTaskList.clear();
    }

    @Override
    public Task getTaskByID(int identifier) {
        historyManager.addToViewingHistory(taskList.get(identifier));
        return taskList.get(identifier);
    }

    @Override
    public Epic getEpicTaskByID(int identifier) {
        historyManager.addToViewingHistory(epicList.get(identifier));
        return epicList.get(identifier);
    }

    @Override
    public SubTask getSubTaskByID(int identifier) {
        historyManager.addToViewingHistory(subTaskList.get(identifier));
        return subTaskList.get(identifier);
    }

    @Override
    public void addTask(Task task) {
        taskList.put(task.getIdentifier(), task);
        taskCount++;
    }

    @Override
    public void addEpic(Epic epic) {
        epicList.put(epic.getIdentifier(), epic);
        taskCount++;
    }

    @Override
    public void addSubTask(SubTask subTask) {
        subTaskList.put(subTask.getIdentifier(), subTask);
        taskCount++;
    }

    @Override
    public void updateTask(@NotNull Task task) {
        taskList.get(task.getIdentifier()).setName(task.getName());
        taskList.get(task.getIdentifier()).setDescription(task.getDescription());
        taskList.get(task.getIdentifier()).setStatus(task.getStatus());
    }

    @Override
    public void updateEpic(@NotNull Epic epic) {
        epicList.get(epic.getIdentifier()).setName(epic.getName());
        epicList.get(epic.getIdentifier()).setDescription(epic.getDescription());
        epicList.get(epic.getIdentifier()).setStatus(epic.getStatus());
    }

    @Override
    public void updateSubTask(@NotNull SubTask subtask) {
        subTaskList.get(subtask.getIdentifier()).setName(subtask.getName());
        subTaskList.get(subtask.getIdentifier()).setDescription(subtask.getDescription());
        subTaskList.get(subtask.getIdentifier()).setStatus(subtask.getStatus());
    }

    @Override
    public void deleteTaskByID (int identifier) {
        taskList.remove(identifier);
    }

    @Override
    public void deleteEpicByID (int identifier) {
        HashMap<Integer, SubTask> epicsSubTaskList = epicList.get(identifier).getEpicsSubTaskList();

        for (Integer key : epicsSubTaskList.keySet()) {
            subTaskList.remove(key);
        }

        epicList.remove(identifier);
    }

    @Override
    public void deleteSubTaskByID (int identifier) {
        subTaskList.remove(identifier);
    }

    @Override
    public HashMap<Integer, SubTask> getEpicSubTasks (@NotNull Epic epic) {
        return epicList.get(epic.getIdentifier()).getEpicsSubTaskList();
    }

    @Override
    public void changeTaskStatus(@NotNull Task task, TaskStatus taskStatus) {
        taskList.get(task.getIdentifier()).setStatus(taskStatus);
    }

    @Override
    public void changeSubTaskStatus(@NotNull SubTask subTask, TaskStatus taskStatus) {
        subTaskList.get(subTask.getIdentifier()).setStatus(taskStatus);

        int epicId = subTaskList.get(subTask.getIdentifier()).getEpicID();
        epicList.get(epicId).setEpicStatus();
    }

    @Override
    public ArrayList<Task> getViewingHistory() {
        return historyManager.getHistory();
    }
}
