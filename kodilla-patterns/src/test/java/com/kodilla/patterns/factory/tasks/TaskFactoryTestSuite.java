package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testFactoryDrivingTask(){
        //given
        TaskFactory factory = new TaskFactory();
        //when
        Task drivingTask = factory.makeTask(TaskFactory.DRIVING_TASK);
        //then
        Assert.assertEquals("Driving task", drivingTask.getTaskName());
        Assert.assertEquals(false, drivingTask.isTaskExecuted());
    }

    @Test
    public void testFactoryPaintingTask(){
        //given
        TaskFactory factory = new TaskFactory();
        //when
        Task paintingTask = factory.makeTask(TaskFactory.PAINTING_TASK);
        paintingTask.executeTask();
        //then
        Assert.assertEquals("Painting task", paintingTask.getTaskName());
        Assert.assertEquals(true, paintingTask.isTaskExecuted());
    }

    @Test
    public void testFactoryShoppingTask(){
        //given
        TaskFactory factory = new TaskFactory();
        //when
        Task shoppingTask = factory.makeTask(TaskFactory.SHOPPING_TASK);
        shoppingTask.executeTask();
        //then
        Assert.assertEquals("Shopping task", shoppingTask.getTaskName());
        Assert.assertEquals(true, shoppingTask.isTaskExecuted());
    }
}
