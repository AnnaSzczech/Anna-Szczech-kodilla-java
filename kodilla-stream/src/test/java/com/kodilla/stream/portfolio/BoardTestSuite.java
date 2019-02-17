package com.kodilla.stream.portfolio;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoardTestSuite {
    // 1. obliczenie średniej ilości dni, jaka upłynęła od zlecenia wykonania zadania do dnia bieżącego w liście zadań, które są aktualnie w trakcie realizacji
    // wersja łatwiejsza
    @Test
    public void testAddTaskListAverageWorkingOnTask(){
        //given
        Board project = prepareTestData();

        //when
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        long sumOfDays = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(t -> t.getTasks().stream())
                .map(Task::getCreated)
                .map(d -> d.until(LocalDate.now(), ChronoUnit.DAYS))
                .reduce(0L, (sum, current) -> sum + current);
        long numberOfTasks = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(t -> t.getTasks().stream())
                .count();
        double average = (double) sumOfDays/numberOfTasks;

        //then
        Assert.assertEquals(10.0, average, 0.01);
    }

    // 2. obliczenie średniej ilości dni, jaka upłynęła od zlecenia wykonania zadania do dnia bieżącego w liście zadań, które są aktualnie w trakcie realizacji
    // WERSCJA Z GWIAZDKĄ
    @Test
    public void testAddTaskListAverageWorkingOnTask2(){
        //given
        Board project = prepareTestData();

        //when
        TaskList inProgressTasks = new TaskList("In progress");
        int indexOfTaskInProgress = project.getTaskLists().indexOf(inProgressTasks);
        int inProgressTasksQuantity = project.getTaskLists().get(indexOfTaskInProgress).getTasks().size();

        double average = IntStream.range(0, inProgressTasksQuantity)
                .mapToLong(n -> project.getTaskLists().get(indexOfTaskInProgress).getTasks().get(n).getCreated().until(LocalDate.now(), ChronoUnit.DAYS))
                .average()
                .getAsDouble();

        //then
        Assert.assertEquals(10.0, average, 0.01);
    }


    public Board prepareTestData(){
        //users
        User user1 = new User("developer1", "John Smith");
        User user2 = new User("projectmanager1", "Nina White");
        User user3 = new User("developer2", "Emilia Stephanson");
        User user4 = new User("developer3", "Konrad Bridge");


        //tasks
        Task task1 = new Task("Microservice for taking temperature", "Write and test the microservice taking\\n\" +\n" +
                     "\"the temperaure from external service", user1, user2, LocalDate.now().minusDays(20), LocalDate.now().plusDays(30));
        Task task2 = new Task("HQLs for analysis", "Prepare some HQL queries for analysis", user1, user2,
                     LocalDate.now().minusDays(20), LocalDate.now().minusDays(5));
        Task task3 = new Task("Temperatures entity", "Prepare entity for temperatures", user3, user2,
                LocalDate.now().minusDays(20), LocalDate.now().plusDays(15));
        Task task4 = new Task("Own logger", "Refactor company logger to meet our needs", user3, user2,
                LocalDate.now().minusDays(10), LocalDate.now().plusDays(25));
        Task task5 = new Task("Optimize searching", "Archive data searching has to be optimized", user4, user2,
                LocalDate.now(), LocalDate.now().plusDays(5));
        Task task6 = new Task("Use Streams", "use Streams rather than for-loops in predictions", user4, user2,
                LocalDate.now().minusDays(15), LocalDate.now().minusDays(2));

        //taskLists
        TaskList taskListToDo  = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);

        //board
        Board project = new Board("Project Weather Prediction");
        project.addTasList(taskListToDo);
        project.addTasList(taskListInProgress);
        project.addTasList(taskListDone);
        return project;
    }

    @Test
    public void testAddTaskList(){
        //given
        Board project = prepareTestData();

        //when

        //then
        Assert.assertEquals(3, project.getTaskLists().size());
    }

    @Test
    public void testAddTaskListFindUsersTasks(){
        //given
        Board project = prepareTestData();

        //when
        User user = new User("developer1", "John Smith");
        List<Task> tasks = project.getTaskLists().stream()
                .flatMap(l -> l.getTasks().stream())
                .filter(task -> task.getAssignedUser().equals(user))
                .collect(Collectors.toList());

        //then
        Assert.assertEquals(2, tasks.size());
        Assert.assertEquals(user, tasks.get(0).getAssignedUser());
        Assert.assertEquals(user, tasks.get(1).getAssignedUser());
    }

    @Test
    public void testAddTaskListFindOutdatedTasks(){
        //given
        Board project = prepareTestData();

        //when
        List<TaskList> undoneTasks = new ArrayList<>();
        undoneTasks.add(new TaskList("To do"));
        undoneTasks.add(new TaskList("In progress"));
        List<Task> tasks = project.getTaskLists().stream()
                .filter(undoneTasks::contains)
                .flatMap(t1 -> t1.getTasks().stream())
                .filter(t -> t.getDeadline().isBefore(LocalDate.now()))
                .collect(Collectors.toList());
        //then
        Assert.assertEquals(1, tasks.size());
        Assert.assertEquals("HQLs for analysis", tasks.get(0).getTitle());
    }

    @Test
    public void testAddTaskListFindLongTasks(){
        //given
        Board project = prepareTestData();

        //when
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        long longTask = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(t1 -> t1.getTasks().stream())
                .map(t -> t.getCreated())
                .filter(d -> d.compareTo(LocalDate.now().minusDays(10)) <= 0)
                .count();

        //then
        Assert.assertEquals(2, longTask);
    }
}
