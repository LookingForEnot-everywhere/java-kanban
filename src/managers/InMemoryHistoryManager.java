package managers;

import models.Task;

import java.util.ArrayList;
import java.util.List;
// Привет, Евгений) 👋
// Я посмотрел-погуглил немного, кажется, что тут можно все таки обойтись только List,
// а метод removeFirst как будто можно заменить на remove(0), то я и сделал, иначе же у нас раскрывается реализация,
// как с HashMap, или я не правильно понял задумку?😅
// Заменил все на List и Map, тесты прошли, кажется никаких проблем в этом случае реализации нет)

public class InMemoryHistoryManager implements HistoryManager{
    private static final int MAX_HISTORY_SIZE = 10;

    private final List<Task> viewingHistory = new ArrayList<>();

    @Override
    public List<Task> getHistory() {
        return viewingHistory;
    }

    @Override
    public void addToViewingHistory(Task task) {
        if (viewingHistory.size() == MAX_HISTORY_SIZE) {
            viewingHistory.remove(0);
            return;
        }
        viewingHistory.add(task);
    }
}
