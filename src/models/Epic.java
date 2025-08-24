package models;

import java.util.HashMap;
import java.util.ArrayList;

public class Epic extends Task{
    private final HashMap<Integer, SubTask> epicsSubTaskList = new HashMap<>();

    public Epic (Integer identifier, String taskName, String taskDescription) {
        super(identifier, taskName, taskDescription);
    }

    public void addSubTask(SubTask subTask) {
        epicsSubTaskList.put(subTask.getIdentifier(), subTask);
    }

    public HashMap<Integer, SubTask> getEpicsSubTaskList() {
        return epicsSubTaskList;
    }

    public void setEpicStatus() {
        // Спасибо за идею, тоже не нравилось, как я реализовал, но никак не мог придумать ничего лучше. :)
        ArrayList<TaskStatus> taskStatuses = new ArrayList<>();

        for(Integer key : epicsSubTaskList.keySet()) {
            TaskStatus taskStatus1 = epicsSubTaskList.get(key).getStatus();
            if (taskStatus1 == TaskStatus.IN_PROGRESS) {
                setStatus(TaskStatus.IN_PROGRESS);
                return;
            } else if (taskStatus1 == TaskStatus.DONE && !taskStatuses.contains(taskStatus1)) {
                taskStatuses.add(taskStatus1);
            } else if (taskStatus1 == TaskStatus.NEW && !taskStatuses.contains(taskStatus1)){
                // Тут сравнение по NEW в первой части можно не писать, но я подумал, что для читаемости будет лучше
                taskStatuses.add(taskStatus1);
            }
        }

        if (taskStatuses.size() == 2){
            setStatus(TaskStatus.IN_PROGRESS);
        } else {
            setStatus(taskStatuses.getFirst());
        }
    }

    @Override
    public String toString() {
        String result = "ID: \"" + identifier + "\",\nmodels.Task: \"" + name + "\",\nDescription: \"" + description +
                "\",\nStatus: \"" + status.toString() + "\",\nSubtask list:{\n";

        for (Integer key : epicsSubTaskList.keySet()) {
            result += "\n" +epicsSubTaskList.get(key).toString();
        }
        result += "\n};";

        return result;
    }
}