import manager.TaskManager;
import models.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Поехали!");

        Task task1 = new Task("models.Task Test 1", "Creating new task first time.");
        Task task2 = new Task("models.Task Test 2", "Creating new task second time.");

        Epic epic1 = new Epic("models.Epic Test 1", "models.Epic creation with 1 subtask.");
        Epic epic2 = new Epic("models.Epic Test 2", "models.Epic creation with 2 subtasks.");

        SubTask subTask1 = new SubTask("Subtask Test 1", "Subtask for the first epic.", epic1);
        SubTask subTask2 = new SubTask("Subtask Test 2", "Subtask for the second epic.", epic2);
        SubTask subTask3 = new SubTask("Subtask Test 3", "Subtask for the second epic.", epic2);

        TaskManager taskManager = new TaskManager();

        taskManager.addTask(task1);
        taskManager.addTask(task2);

        taskManager.addEpic(epic1);
        taskManager.addEpic(epic2);

        taskManager.addSubTask(subTask1);
        taskManager.addSubTask(subTask2);
        taskManager.addSubTask(subTask3);

        taskManager.changeTaskStatus(task1, TaskStatus.IN_PROGRESS);
        taskManager.changeTaskStatus(task2, TaskStatus.DONE);

        taskManager.changeSubTaskStatus(subTask1, TaskStatus.DONE);
        taskManager.changeSubTaskStatus(subTask2, TaskStatus.IN_PROGRESS);

        taskManager.clearEpicTaskList();
        taskManager.clearTaskList();
        taskManager.clearSubTaskList();
        System.out.println(taskManager.getTaskByID(task1.getIdentifier()));
        System.out.println(taskManager.getEpicTaskByID(epic1.getIdentifier()));
        System.out.println(taskManager.getSubTaskByID(subTask1.getIdentifier()));
        System.out.println(taskManager.getEpicSubTasks(epic1));

        taskManager.deleteTaskByID(task1.getIdentifier());
        task1.setName("New models.Task 1");
        task1.setDescription("New Description 1");
        taskManager.updateTask(task1);
        System.out.println(taskManager.getAllTasks());

        taskManager.deleteEpicByID(epic2.getIdentifier());
        epic1.setName("New models.Epic 1");
        epic1.setDescription("New models.Epic Description 1");
        taskManager.updateEpic(epic1);
        System.out.println(taskManager.getAllEpics());

        taskManager.deleteSubTaskByID(subTask1.getIdentifier());
        subTask1.setName("New Subtask 1");
        subTask1.setDescription("New Subtask Description 1");
        taskManager.updateSubTask(subTask1);
        System.out.println(taskManager.getAllSubTasks());
    }
}
