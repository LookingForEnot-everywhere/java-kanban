import java.util.HashMap;

public class Epic extends Task{
    private final HashMap<Integer, SubTask> epicsSubTaskList = new HashMap<>();

    public Epic (String taskName, String taskDescription) {
        super(taskName, taskDescription);
    }

    public void addSubTask(SubTask subTask) {
        epicsSubTaskList.put(subTask.getIdentifier(), subTask);
    }

    public HashMap<Integer, SubTask> getEpicsSubTaskList() {
        return epicsSubTaskList;
    }

    public void setEpicStatus() {
        boolean haveNew = false;
        boolean haveDone = false;

        for(Integer key : epicsSubTaskList.keySet()) {
            TaskStatus taskStatus1 = epicsSubTaskList.get(key).getStatus();
            if (taskStatus1 == TaskStatus.IN_PROGRESS) {
                setStatus(TaskStatus.IN_PROGRESS);
                return;
            } else if (taskStatus1 == TaskStatus.DONE) {
                haveDone = true;
            } else {
                haveNew = true;
            }
        }

        if (haveNew && !haveDone){
            return;
        } else if (!haveNew && haveDone) {
            setStatus(TaskStatus.DONE);
        } else {
            setStatus(TaskStatus.IN_PROGRESS);
        }
    }

    @Override
    public String toString() {
        String result = "ID: \"" + identifier + "\",\nTask: \"" + name + "\",\nDescription: \"" + description +
                "\",\nStatus: \"" + status.toString() + "\",\nSubtask list:{\n";

        for (Integer key : epicsSubTaskList.keySet()) {
            result += "\n" +epicsSubTaskList.get(key).toString();
        }
        result += "\n};";

        return result;
    }
}