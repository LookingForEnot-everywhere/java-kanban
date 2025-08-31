package managers;

import models.Task;

import java.util.ArrayList;

public interface HistoryManager {

    void addToViewingHistory(Task task);

    ArrayList<Task> getHistory();
}
