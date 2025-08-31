package models;

public enum TaskStatus {
    NEW,
    IN_PROGRESS,
    DONE;


    @Override
    public String toString() {
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
