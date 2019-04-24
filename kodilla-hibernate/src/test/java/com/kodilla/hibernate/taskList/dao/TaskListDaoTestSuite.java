package com.kodilla.hibernate.taskList.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import com.kodilla.hibernate.tasklist.dao.TaskListDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void testFindByListName(){
        //given
        TaskList taskList = new TaskList("LIST_NAME", "desctription");
        taskListDao.save(taskList);
        String listName = taskList.getListName();
        //when
        List<TaskList> readTaskList = taskListDao.findByListName(listName);
        //then
        Assert.assertEquals(1, readTaskList.size());
        //cleanUp
        int id = readTaskList.get(0).getId();
        taskListDao.deleteById(id);
    }
}
