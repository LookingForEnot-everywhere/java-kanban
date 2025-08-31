package managers;

import models.Task;

import java.util.ArrayList;

public class InMemoryHistoryManager implements HistoryManager{
    private static final int MAX_HISTORY_SIZE = 10;

    private final ArrayList<Task> viewingHistory = new ArrayList<>();

    @Override
    public ArrayList<Task> getHistory() {
        return viewingHistory;
    }

    @Override
    public void addToViewingHistory(Task task) {
        if (viewingHistory.size() == MAX_HISTORY_SIZE) {
            viewingHistory.removeFirst();
            viewingHistory.add(task);
            return;
        }
        viewingHistory.add(task);
    }
}
