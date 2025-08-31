package managers;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class Managers {
    private Managers() {}

    @Contract(" -> new")
    public static @NotNull TaskManager getDefault () {
        return new InMemoryTaskManager();
    }

    @Contract(" -> new")
    public static @NotNull HistoryManager getDefaultHistory () {
        return new InMemoryHistoryManager();
    }
}
