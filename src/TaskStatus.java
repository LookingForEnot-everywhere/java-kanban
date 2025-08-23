public enum TaskStatus {
    NEW,
    IN_PROGRESS,
    DONE;

    @Override
    public String toString() {
        switch (this) {
            case IN_PROGRESS: return name().charAt(0) + name().substring(1, 2).toLowerCase() +
                                     " " + name().substring(3).toLowerCase();
            default: return name().charAt(0) + name().substring(1).toLowerCase();
        }
    }
}
