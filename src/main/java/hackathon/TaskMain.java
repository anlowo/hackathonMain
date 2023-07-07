package hackathon;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        Task newTask;

        String name = null;
        String description = null;
        LocalDate date = null;
        Priority priority = null;
        Status status = null;

        int index;

        int choice;

        do {
            System.out.println("========== Список задач ==========");
            System.out.println("1. Создать задачу");
            System.out.println("2. Просмотреть задачу");
            System.out.println("3. Просмотреть все задачи");
            System.out.println("4. Обновить задачу");
            System.out.println("5. Удалить задачу");
            System.out.println("6. Обновить статус задачи");
            System.out.println("7. Просмотр задач по статусу и приоритету");
            System.out.println("8. Просмотр статуса всех задач");
            System.out.println("9. Сортировка задач по дате или приоритету");
            System.out.println("10. Выход\n");
            System.out.print("Выберите действие: " + "\n");
            choice = input.nextInt();

            switch (choice) {
                case 1 -> {
                    try {
                        System.out.print("Введите название задачи: ");
                        name = input.next();

                        System.out.print("Введите описание: ");
                        description = input.next();

                        try {
                            System.out.println("Введите дату задачи (год/месяц/день): ");
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            date = LocalDate.of(input.nextInt(), input.nextInt(), +input.nextInt());
                            String localDate = date.format(formatter);
                            System.out.println(localDate + "\n");
                        } catch (InputMismatchException e) {
                            System.out.print("Введедите числа\n");
                            break;
                        }

                        while (true) {
                            try {
                                System.out.println("Выберите приоритет:\n");
                                System.out.print("1. Приоритет High\n");
                                System.out.print("2. Приоритет Medium\n");
                                System.out.print("3. Приоритет Low\n");
                                System.out.print("Выбор: ");
                                int choose = input.nextInt();
                                if (choose == 1) {
                                    System.out.println("Выбран высокий приоритет!\n");
                                    priority = Priority.High;
                                    break;
                                } else if (choose == 2) {
                                    System.out.println("Выбран средний приоритет!\n");
                                    priority = Priority.Medium;
                                    break;
                                } else if (choose == 3) {
                                    System.out.println("Выбран низкий приоритет!\n");
                                    priority = Priority.Low;
                                    break;
                                }
                            } catch (IllegalArgumentException e) {
                                e.printStackTrace();
                                break;
                            }
                            break;
                        }

                        while (true) {
                            try {
                                System.out.println("Выберите статус:\n");
                                System.out.print("1. Статус Выполнено\n");
                                System.out.print("2. Статус В процессе\n");
                                System.out.print("3. Статус Отложено\n");
                                System.out.print("Выбор:\n");
                                int choose = input.nextInt();
                                if (choose == 1) {
                                    System.out.println("Выбран статус выполнено!\n");
                                    status = Status.Complete;
                                    break;
                                } else if (choose == 2) {
                                    System.out.println("Выбран статус в процессе!\n");
                                    status = Status.inProcess;
                                    break;
                                } else if (choose == 3) {
                                    System.out.println("Выбран статус отложено!\n");
                                    status = Status.Deferred;
                                    break;
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                break;
                            }
                            break;
                        }

                        newTask = new Task(name, description, date, priority, status);
                        taskManager.addTusk(newTask);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case 2 -> {
                    try {
                        System.out.print("Введите индекс задачи: ");
                        index = input.nextInt();
                        taskManager.readTask(index);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case 3 -> {
                    try {
                        System.out.println("Все задачи: ");
                        taskManager.readAllTask();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case 4 -> {
                    try {
                        System.out.print("Введите индекс задачи: ");
                        index = input.nextInt();

                        System.out.print("Введите новое название задачи: ");
                        name = input.next();

                        System.out.print("Введите новое описание: ");
                        description = input.next();

                        try {
                            System.out.println("Введите новую дату задачи (год/месяц/день): ");
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            date = LocalDate.of(input.nextInt(), input.nextInt(), +input.nextInt());
                            String localDate = date.format(formatter);
                            System.out.println(localDate + "\n");
                        } catch (InputMismatchException e) {
                            System.out.println("Введедите числа");
                            break;
                        }

                        while (true) {
                            try {
                                System.out.println("Выберите новый приоритет:\n");
                                System.out.print("1. Приоритет High\n");
                                System.out.print("2. Приоритет Medium\n");
                                System.out.print("3. Приоритет Low\n");
                                System.out.print("Выбор: ");
                                int choose = input.nextInt();
                                if (choose == 1) {
                                    System.out.println("Выбран высокий приоритет!\n");
                                    priority = Priority.High;
                                    break;
                                } else if (choose == 2) {
                                    System.out.println("Выбран средний приоритет!\n");
                                    priority = Priority.Medium;
                                    break;
                                } else if (choose == 3) {
                                    System.out.println("Выбран низкий приоритет!\n");
                                    priority = Priority.Low;
                                    break;
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                break;
                            }
                            break;
                        }

                        while (true) {
                            try {
                                System.out.println("Выберите новый статус:\n");
                                System.out.print("1. Статус Выполнено\n");
                                System.out.print("2. Статус В процессе\n");
                                System.out.print("3. Статус Отложено\n");
                                System.out.print("Выбор: ");
                                int choose = input.nextInt();
                                if (choose == 1) {
                                    System.out.println("Выбран статус выполнено!\n");
                                    status = Status.Complete;
                                    break;
                                } else if (choose == 2) {
                                    System.out.println("Выбран статус в процессе!\n");
                                    status = Status.inProcess;
                                    break;
                                } else if (choose == 3) {
                                    System.out.println("Выбран статус отложено!\n");
                                    status = Status.Deferred;
                                    break;
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                break;
                            }
                            break;
                        }

                        Task updateTask = new Task(name, description, date, priority, status);
                        taskManager.updateTask(index, updateTask);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case 5 -> {
                    try {
                        System.out.print("Введите индекс задачи: ");
                        index = input.nextInt();
                        taskManager.deleteTask(index);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case 6 -> {
                    try {
                        System.out.print("Введите индекс задачи для обновления статуса: ");
                        index = input.nextInt();

                        if (status != null) {
                            System.out.println("Статус задачи на данный момент " + status.getStatusEnum());
                        } else {
                            System.out.print("Статус отсутствует");
                        }

                        while (true) {
                            try {
                                System.out.println("Выберите новый статус:\n");
                                System.out.print("1. Статус Выполнено\n");
                                System.out.print("2. Статус В процессе\n");
                                System.out.print("3. Статус Отложено\n");
                                System.out.print("Выбор: ");
                                int choose = input.nextInt();
                                if (choose == 1) {
                                    System.out.println("Выбран статус выполнено!\n");
                                    status = Status.Complete;
                                    break;
                                } else if (choose == 2) {
                                    System.out.println("Выбран статус в процессе!\n");
                                    status = Status.inProcess;
                                    break;
                                } else if (choose == 3) {
                                    System.out.println("Выбран статус отложено!\n");
                                    status = Status.Deferred;
                                    break;
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                break;
                            }
                            break;
                        }

                        Task updateTask = new Task(name, description, date, priority, status);
                        taskManager.updateStatusTask(index, updateTask);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case 7 -> {
                    try {
                        System.out.print("Введите индекс для поиска статуса и приоритета: ");
                        index = input.nextInt();
                        taskManager.readStatusAndPriorityTask(index);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case 8 -> {
                    try {
                        System.out.print("Просмотр статуса и приоритета всех задач: ");
                        taskManager.readAllStatusTask();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case 9 -> {
                    try {
                        do {
                            System.out.print("1. Сортировка задач по дате\n");
                            System.out.print("2. Сортировка задач по приоритету\n ");
                            System.out.print("3. Выход\n");
                            choice = input.nextInt();

                            switch (choice) {
                                case 1 -> {
                                    try {
                                        System.out.print("Сортировка задач по дате:\n");
                                        taskManager.sortByDate();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                case 2 -> {
                                    try {
                                        System.out.print("Сортировка задач по приоритету:\n");
                                        taskManager.sortByPriority();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                case 3 -> {
                                    try {
                                        System.out.println("Выход...");
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                default -> System.out.println("Не верное действие");
                            }
                        } while (choice != 3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case 10 -> {
                    try {
                        System.out.println("Выход с программы...");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                default -> System.out.println("Не верное действие");
            }
        } while (choice != 10);
    }
}
