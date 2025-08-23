package models;

public enum TaskStatus {
    NEW,
    IN_PROGRESS,
    DONE;


    @Override
    public String toString() {
        // Наверное все таки немного не так сделал, как предполагалось😅. Не смог объявить за переделами метода с final,
        // так как идея ругаться начала - "Cannot assign a value to final variable 'label'"
        final String label;
        switch (this) {
            case IN_PROGRESS: label = name().charAt(0) + name().substring(1, 2).toLowerCase() +
                                     " " + name().substring(3).toLowerCase();
            break;
            default: label = name().charAt(0) + name().substring(1).toLowerCase();
        }

        return label;
    }
}
