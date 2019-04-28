//package com.kodilla.hibernate.task.dao;
//
//import com.kodilla.hibernate.task.Task;
//import com.kodilla.hibernate.task.TaskFinancialDetails;
//import com.kodilla.hibernate.tasklist.TaskList;
//import org.junit.Assert;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.Optional;
//
//@Ignore
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TaskDaoTestSuite {
//    @Autowired
//    private TaskDao taskDao;
//    private static final String DESCRIPTION = "Test: Learn Hibernate";
//
//    @Ignore
//    @Test
//    public void testTaskDaoSave(){
//        //given
//        Task task = new Task(DESCRIPTION, 7);
//        //when
//        taskDao.save(task);
//
//        //then
//        int id = task.getId();
//        Optional<Task> readTask = taskDao.findById(id);
//        Assert.assertTrue(readTask.isPresent());
//
//        //cleanUp
//        taskDao.deleteById(id);
//    }
//
//    @Ignore
//    @Test
//    public void findByDuration(){
//        //given
//        Task task = new Task(DESCRIPTION, 7);
//        taskDao.save(task);
//        int duration = task.getDuration();
//
//        //when
//        List<Task> readTask = taskDao.findByDuration(duration);
//
//        //then
//        Assert.assertEquals(1, readTask.size());
//
//        //cleanUp
//        int id = readTask.get(0).getId();
//        taskDao.deleteById(id);
//    }
//
//    @Ignore
//    @Test
//    public void testTaskDaoSaveWithFinancialDetails(){
//        //given
//        Task task = new Task(DESCRIPTION, 20);
//        task.setTaskFinancialDetails(new TaskFinancialDetails(new BigDecimal(20), false));
//        //when
//        taskDao.save(task);
//        int id = task.getId();
//        //then
//        Assert.assertEquals(1, id);
//        //cleanUp
////        taskDao.deleteById(id);
//    }
//
//
//}
