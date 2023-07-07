package hackathon;

public enum Status {
    Complete("Выполнено"), inProcess("В процессе"),Deferred("Отложено");
    public final String status;
    Status(String status) {
        this.status = status;
    }
    public String getStatusEnum() {
        return status;
    }
}
