package hackathon;

import java.time.LocalDate;

public class Task {
    private String name;
    private String description;
    private LocalDate date;
    private Priority priority;
    private Status status;
    public Task(String name, String description, LocalDate date, Priority priority, Status status) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.priority = priority;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getStatusAndPriority() {
        return "Status: " + Status.valueOf(String.valueOf(getStatus())) + ", Priority: " + Priority.valueOf(String.valueOf(getPriority()));
    }
    public String getInfo() {
        return "Name: " + name
                + ", Description: " + description
                + ", Date: " + date
                + ", Priority: " + priority
                + ", Status: " + status + "\n";
    }
}
