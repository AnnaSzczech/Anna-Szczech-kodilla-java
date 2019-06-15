package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacadeTestSuite {
    @Autowired
    private Facade facade;

    @Test
    public void testFindCompany(){
        try {
            facade.findCompany("ware");
        } catch (ProcessingException e) {
            //business exception - shoukd be handled in real application
        }
    }

    @Test
    public void testFindEmployee(){
        try {
            facade.findEmployee("mit");
        } catch (ProcessingException e) {
            //business exception - shoukd be handled in real application
        }
    }
}