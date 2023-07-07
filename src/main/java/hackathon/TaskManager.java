package hackathon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {
    private final List<Task> list = new ArrayList<>();
    public void addTusk(Task task) {
        list.add(task);
        System.out.println("Задача добавлена\n");
    }
    public void readTask(int index) {
        if (index >= 0 && index < list.size()) {
            System.out.println(list.get(index).getInfo());
        } else {
            System.out.println("Неправельный индекс\n");
        }
    }
    public void readAllTask() {
        if (list.size() > 0) {
            for (Task value : list) {
                System.out.println(value.getInfo());
            }
        } else {
            System.out.println("Неправельный индекс\n");
        }
    }
    public void updateTask(int index, Task updateTask) {
        if (index >= 0 && index < list.size()) {
            list.set(index, updateTask);
            System.out.println("Задача обновлена\n");
        } else {
            System.out.println("Неправельный индекс\n");
        }
    }
    public void deleteTask(int index) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
            System.out.println("Задача удалена\n");
        } else {
            System.out.println("Неправельный индекс\n");
        }
    }
    public void readStatusAndPriorityTask(int index) {
        if (index >= 0 && index < list.size()) {
            System.out.println(list.get(index).getStatusAndPriority());
        } else {
            System.out.println("Неправельный индекс\n");
        }
    }
    public void updateStatusTask(int index, Task updateStatusTask) {
        if (index >= 0 && index < list.size()) {
            list.set(index, updateStatusTask);
            System.out.println("Статус задачи обновлён\n");
        } else {
            System.out.println("Неправельный индекс\n");
        }
    }
    public void readAllStatusTask() {
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ", " + list.get(i).getStatus() + " " + list.get(i).getPriority());
            }
        }
    }
    public void sortByDate() {
        for (int i = 0; i < list.size(); i++) {
            list.stream().sorted(Comparator.comparing(Task::getDate)).collect(Collectors.toList());
            System.out.println(list.get(i).getName() + ", " + list.get(i).getDate() + "\n");
        }
    }
    public void sortByPriority() {
        for (int i = 0; i < list.size(); i++) {
            list.stream().sorted(Comparator.comparing(Task::getPriority)).collect(Collectors.toList());
            System.out.println(list.get(i).getName() + ", " + list.get(i).getPriority() + "\n");
        }
    }
}
