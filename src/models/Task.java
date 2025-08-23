package models;

import static manager.TaskManager.taskCount;

public class Task {
    protected final int identifier;
    protected String name;
    protected String description;
    protected TaskStatus status;

    public Task (String name, String description) {
        this.name = name;
        this.description = description;
        this.status = TaskStatus.NEW;
        this.identifier = hashCode();
        // Я тут немного закипел, поэтому мог неправильно все таки понять и сделать. :)
        // По итогу у нас хешкод высчитывается не по полям, а по глобальному счетчику добавленных задач в менеджер
        // Кажется, что это позволяет в целом уникальный ID сделать, до определенного кол-ва добавленных задач)
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object task) {
        if (this == task) return true;
        if (task == null) return false;
        if (this.getClass() != task.getClass()) return false;
        Task newTask = (Task) task;
        return this.identifier == newTask.identifier;
    }

    @Override
    public int hashCode() {
        int hash = 17;

        hash += taskCount;

        hash *= 31;

        return hash;
    }

    @Override
    public String toString() {
        return "ID: \"" + identifier + "\",\nmodels.Task: \"" + name + "\",\nDescription: \"" + description +
                "\",\nStatus: \"" + status.toString() + "\".";
    }
}
