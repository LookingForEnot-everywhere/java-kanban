package managers;

import models.Task;

import java.util.List;

public interface HistoryManager {

    void addToViewingHistory(Task task);

    List<Task> getHistory();
}
