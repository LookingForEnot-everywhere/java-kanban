import java.util.Objects;

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
        return this.identifier == newTask.identifier &&
                Objects.equals(this.name, newTask.name) &&
                Objects.equals(this.description, newTask.description) &&
                Objects.equals(status.name(), newTask.status.name());
    }

    @Override
    public int hashCode() {
        int hash = 17;

        if(name != null) hash += name.hashCode();

        hash *= 31;

        if(description != null) hash += description.hashCode();

        return hash;
    }

    @Override
    public String toString() {
        return "ID: \"" + identifier + "\",\nTask: \"" + name + "\",\nDescription: \"" + description +
                "\",\nStatus: \"" + status.toString() + "\".";
    }
}
