import manager.TaskManager;
import models.*;
import static manager.TaskManager.taskCount;

public class Main {

    public static void main(String[] args) {

        System.out.println("Поехали!");

        TaskManager taskManager = new TaskManager();

        Task task1 = new Task(taskCount, "models.Task Test 1", "Creating new task first time.");
        taskManager.addTask(task1);
        Task task2 = new Task(taskCount, "models.Task Test 2", "Creating new task second time.");
        taskManager.addTask(task2);


        Epic epic1 = new Epic(taskCount, "models.Epic Test 1", "models.Epic creation with 1 subtask.");
        taskManager.addEpic(epic1);
        Epic epic2 = new Epic(taskCount, "models.Epic Test 2", "models.Epic creation with 2 subtasks.");
        taskManager.addEpic(epic2);

        SubTask subTask1 = new SubTask(taskCount, "Subtask Test 1", "Subtask for the first epic.", epic1);
        taskManager.addSubTask(subTask1);
        SubTask subTask2 = new SubTask(taskCount, "Subtask Test 2", "Subtask for the second epic.", epic2);
        taskManager.addSubTask(subTask2);
        SubTask subTask3 = new SubTask(taskCount, "Subtask Test 3", "Subtask for the second epic.", epic2);
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
