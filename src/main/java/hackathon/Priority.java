package hackathon;

public enum Priority {
    High("Высокий"),Medium("Средний"),Low("Низкий");
    public final String priority;
    Priority(String priority) {
        this.priority = priority;
    }
    public String getPriorityEnum() {
        return priority;
    }
}
