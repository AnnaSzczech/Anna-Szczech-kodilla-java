package com.kodilla.pattern2.adapter.company;

import com.kodilla.pattern2.adapter.company.newhrsystem.Employee;
import com.kodilla.pattern2.adapter.company.oldhrsystem.SolaryCalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SalaryAdapter extends SalaryAdaptee implements SolaryCalculator {

    @Override
    public double totalSolary(String[][] workers, double[] salaries) {
        List<Employee> employeesList = new ArrayList<>();
        for (int i = 0; i < salaries.length; i++) {
            employeesList.add(new Employee(workers[i][0], workers[i][1], workers[i][2], new BigDecimal(salaries[i])));
        }
         return calculateSalaries(employeesList).doubleValue();
    }
}
