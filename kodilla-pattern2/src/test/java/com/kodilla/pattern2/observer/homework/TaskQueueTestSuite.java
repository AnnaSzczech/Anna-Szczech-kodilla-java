package com.kodilla.pattern2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaskQueueTestSuite {
    @Test
    public void testUpdate(){
        //given
        TaskQueue taskQueue1 = new TaskQueue("Moduł 24");
        TaskQueue taskQueue2 = new TaskQueue("Moduł 24");
        TaskQueue taskQueue3 = new TaskQueue("Moduł 23");
        Mentor mentor1 = new Mentor("John Smith");
        Mentor mentor2 = new Mentor("Anna Szczech");
        taskQueue1.registerObserver(mentor1);
        taskQueue2.registerObserver(mentor1);
        taskQueue3.registerObserver(mentor2);
        //when
        taskQueue1.addTask("Task: Kolejki z zadaniami do sprawdzenia");
        taskQueue2.addTask("Task: Dodajemy logowanie żądań do fasady");
        taskQueue3.addTask("Task: Dekorujemy pizzę");
        //then
        assertEquals(2, mentor1.getUpdateCount());
        assertEquals(1, mentor2.getUpdateCount());


    }

}