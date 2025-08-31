import managers.InMemoryTaskManager;
import managers.Managers;
import managers.TaskManager;
import models.*;
import static managers.InMemoryTaskManager.taskCount;

public class Main {

    public static void main(String[] args) {

        System.out.println("Поехали!");

//        TaskManager inMemoryTaskManager = Managers.getDefault();
//
//        Task task1 = new Task(taskCount, "models.Task Test 1", "Creating new task first time.");
//        inMemoryTaskManager.addTask(task1);
//        Task task2 = new Task(taskCount, "models.Task Test 2", "Creating new task second time.");
//        inMemoryTaskManager.addTask(task2);
//
//
//        Epic epic1 = new Epic(taskCount, "models.Epic Test 1", "models.Epic creation with 1 subtask.");
//        inMemoryTaskManager.addEpic(epic1);
//        Epic epic2 = new Epic(taskCount, "models.Epic Test 2", "models.Epic creation with 2 subtasks.");
//        inMemoryTaskManager.addEpic(epic2);
//
//        SubTask subTask1 = new SubTask(taskCount, "Subtask Test 1", "Subtask for the first epic.", epic1);
//        inMemoryTaskManager.addSubTask(subTask1);
//        SubTask subTask2 = new SubTask(taskCount, "Subtask Test 2", "Subtask for the second epic.", epic2);
//        inMemoryTaskManager.addSubTask(subTask2);
//        SubTask subTask3 = new SubTask(taskCount, "Subtask Test 3", "Subtask for the second epic.", epic2);
//        inMemoryTaskManager.addSubTask(subTask3);
//
//
//
//
//        inMemoryTaskManager.changeTaskStatus(task1, TaskStatus.IN_PROGRESS);
//        inMemoryTaskManager.changeTaskStatus(task2, TaskStatus.DONE);
//
//        inMemoryTaskManager.changeSubTaskStatus(subTask1, TaskStatus.DONE);
//        inMemoryTaskManager.changeSubTaskStatus(subTask2, TaskStatus.IN_PROGRESS);
//
//        inMemoryTaskManager.clearEpicTaskList();
//        inMemoryTaskManager.clearTaskList();
//        inMemoryTaskManager.clearSubTaskList();
//        System.out.println(inMemoryTaskManager.getTaskByID(task1.getIdentifier()));
//        System.out.println(inMemoryTaskManager.getEpicTaskByID(epic1.getIdentifier()));
//        System.out.println(inMemoryTaskManager.getSubTaskByID(subTask1.getIdentifier()));
//        System.out.println(inMemoryTaskManager.getEpicSubTasks(epic1));
//
//        inMemoryTaskManager.deleteTaskByID(task1.getIdentifier());
//        task1.setName("New models.Task 1");
//        task1.setDescription("New Description 1");
//        inMemoryTaskManager.updateTask(task1);
//        System.out.println(inMemoryTaskManager.getAllTasks());
//
//        inMemoryTaskManager.deleteEpicByID(epic2.getIdentifier());
//        epic1.setName("New models.Epic 1");
//        epic1.setDescription("New models.Epic Description 1");
//        inMemoryTaskManager.updateEpic(epic1);
//        System.out.println(inMemoryTaskManager.getAllEpics());
//
//        inMemoryTaskManager.deleteSubTaskByID(subTask1.getIdentifier());
//        subTask1.setName("New Subtask 1");
//        subTask1.setDescription("New Subtask Description 1");
//        inMemoryTaskManager.updateSubTask(subTask1);
//        System.out.println(inMemoryTaskManager.getAllSubTasks());
    }
}
