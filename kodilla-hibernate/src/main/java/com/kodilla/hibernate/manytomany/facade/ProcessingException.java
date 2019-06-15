package com.kodilla.hibernate.manytomany.facade;

public class ProcessingException extends Error {
    public static String ERR_NO_SUCH_COMPANY = "Company name not found";
    public static String ERR_NO_SUCH_EMPLOYEE = "Employee name not found";

    public ProcessingException(String message){
        super(message);
    }
}
