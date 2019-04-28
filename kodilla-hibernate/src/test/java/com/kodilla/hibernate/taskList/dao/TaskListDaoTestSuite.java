//package com.kodilla.hibernate.taskList.dao;
//
//import com.kodilla.hibernate.task.Task;
//import com.kodilla.hibernate.task.TaskFinancialDetails;
//import com.kodilla.hibernate.tasklist.TaskList;
//import com.kodilla.hibernate.tasklist.dao.TaskListDao;
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
//
//@Ignore
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TaskListDaoTestSuite {
//    @Autowired
//    private TaskListDao taskListDao;
//    private static final String LISTNAME ="Todo List";
//
//    @Ignore
//    @Test
//    public void testFindByListName(){
//        //given
//        TaskList taskList = new TaskList("LIST_NAME", "desctription");
//        taskListDao.save(taskList);
//        String listName = taskList.getListName();
//        //when
//        List<TaskList> readTaskList = taskListDao.findByListName(listName);
//        //then
//        Assert.assertEquals(1, readTaskList.size());
//        //cleanUp
//        int id = readTaskList.get(0).getId();
//        taskListDao.deleteById(id);
//    }
//
//    @Ignore
//    @Test
//    public void testTaskListDaoSaveWithTasks(){
//        //given
//        Task task1 = new Task("Test: Learn Hibernate", 14);
//        Task task2 = new Task("Test: Write some entities", 3);
//        TaskFinancialDetails taskFinancialDetails1 = new TaskFinancialDetails(new BigDecimal(20), false);
//        TaskFinancialDetails taskFinancialDetails2 = new TaskFinancialDetails(new BigDecimal(10), false);
//        task1.setTaskFinancialDetails(taskFinancialDetails1);
//        task2.setTaskFinancialDetails(taskFinancialDetails2);
//        TaskList taskList = new TaskList(LISTNAME, "Todo task");
//        taskList.getTasks().add(task1);
//        taskList.getTasks().add(task2);
//        task1.setTaskList(taskList);
//        task2.setTaskList(taskList);
//        //when
//        taskListDao.save(taskList);
//        int id = taskList.getId();
//        //then
//        Assert.assertNotEquals(0, id);
//        //cleanUp
//        taskListDao.deleteById(id);
//    }
//}
