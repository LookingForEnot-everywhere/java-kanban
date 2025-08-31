package models;

public class SubTask extends Task{
    private final int epicID;

    public SubTask (Integer identifier, String taskName, String taskDescription, Epic epic) {
        super(identifier, taskName, taskDescription);
        this.epicID = epic.getIdentifier();
        epic.addSubTask(this);
    }

    public int getEpicID() {
        return epicID;
    }

    @Override
    public String toString() {
        return "ID: \"" + identifier + "\",\nTask: \"" + name + "\",\nDescription: \"" + description +
                "\",\nStatus: \"" + status.toString() + "\",\nEpic ID: \"" + epicID + "\".";
    }
}
