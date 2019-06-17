package com.kodilla.pattern2.adapter.company.newhrsystem;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee {
    private final String peselID;
    private final String firstname;
    private final String lastname;
    private final BigDecimal baseSalary;

    public Employee(String peselID, String firstname, String lastname, BigDecimal baseSalary) {
        this.peselID = peselID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.baseSalary = baseSalary;
    }

    public String getPeselID() {
        return peselID;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return peselID != null ? peselID.equals(employee.peselID) : employee.peselID == null;
    }

    @Override
    public int hashCode() {
        return peselID != null ? peselID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "peselID='" + peselID + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", baseSalary=" + baseSalary +
                '}';
    }
}
