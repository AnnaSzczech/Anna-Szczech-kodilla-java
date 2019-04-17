package com.kodilla.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbManager {
    private static DbManager dbManagerInstance;
    private Connection conn;

    private DbManager() throws SQLException {
        Properties connectionProps  = new Properties();
        connectionProps.put("user", "kodilla_user");
        connectionProps.put("password", "kodilla_password");
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kodilla_course?serverTimezone=Europe/Warsaw" +
                        "&useSSL=False",
                connectionProps);
    }

    public static DbManager getInstance() throws SQLException{
        if (dbManagerInstance == null) {
            dbManagerInstance = new DbManager();
        }
        return dbManagerInstance;
    }

    public Connection getConnection(){
        return conn;
    }

//    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kodilla_course?serverTimezone=Europe/Warsaw" + "&useSSL=False", connectionProps);

//    Poszczególne jego części oznaczają:
//    <> stały tekst "jdbc:mysql://" mówiący o tym, że korzystamy ze sterownika jdbc właściwego dla bazy danych MySQL.
//    <> następnie wskazujemy serwer i port: "localhost:3306/"
//    <> kolejny fragment wskazuje, o którą bazę danych na tym serwerze nam chodzi: "kodilla_course"
//    <> i wreszcie musimy wskazać strefę czasową, w jakiej działa serwer: "?serverTimezone=Europe/Warsaw"
//    <> na końcu dodajemy jeszcze parametr "&useSSL=False", który wyłącza używanie protokołu SSL (w przeciwnym razie potrzebowalibyśmy certyfikatów do nawiązania połączenia).
}
