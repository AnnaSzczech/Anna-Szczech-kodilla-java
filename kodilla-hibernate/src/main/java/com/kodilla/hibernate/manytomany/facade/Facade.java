package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Facade {
    private static final Logger LOGGER = LoggerFactory.getLogger(Facade.class);

    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    public List<Company> findCompany(String name) throws ProcessingException{
        LOGGER.info("Looking for Companies name: " + name);
        List<Company> companies = companyDao.retrieveCompanyWhichNameContains("%" + name + "%");
        if (companies.size() == 0) {
            LOGGER.error(ProcessingException.ERR_NO_SUCH_COMPANY);
            throw new ProcessingException(ProcessingException.ERR_NO_SUCH_COMPANY);
        }
        LOGGER.info("Company found: " + companies);
        return companies;
    }

    public List<Employee> findEmployee(String name) throws ProcessingException{
        LOGGER.info("Looking for Employee name: " + name);
        List<Employee> employees = employeeDao.retrieveEmployeeWhichNameContains("%" + name + "%");
        if (employees.size() == 0) {
            LOGGER.error(ProcessingException.ERR_NO_SUCH_EMPLOYEE);
            throw new ProcessingException(ProcessingException.ERR_NO_SUCH_EMPLOYEE);
        }
        LOGGER.info("Employees found: " + employees);
        return employees;
    }

}
