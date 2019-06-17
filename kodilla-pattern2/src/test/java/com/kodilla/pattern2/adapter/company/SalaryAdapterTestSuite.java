package com.kodilla.pattern2.adapter.company;

import com.kodilla.pattern2.adapter.company.oldhrsystem.SolaryCalculator;
import com.kodilla.pattern2.adapter.company.oldhrsystem.Workers;
import org.junit.Assert;
import org.junit.Test;

public class SalaryAdapterTestSuite {
    @Test
    public void testTotalSolary(){
        //given
        Workers workers = new Workers();
        SalaryAdapter salaryAdapter = new SalaryAdapter();
        //when
        double totalSalary = salaryAdapter.totalSolary(workers.getWorkers(), workers.getSolaries());
        //then
        System.out.printf(totalSalary+"");
        Assert.assertEquals(27750, totalSalary, 0);
    }
}
