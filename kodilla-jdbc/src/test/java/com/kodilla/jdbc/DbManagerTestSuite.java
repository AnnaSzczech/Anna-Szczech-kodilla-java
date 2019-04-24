package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
@Ignore
public class DbManagerTestSuite {
    @Test
    public void testGetConnection() throws SQLException {
        //given
        //when
        DbManager dbManager = DbManager.getInstance();
        //then
        Assert.assertNotNull(dbManager.getConnection());
    }

    @Test
    public void testSelectUsers()throws SQLException{
        //given
        DbManager dbManager = DbManager.getInstance();
        //when
        String sqlQuery  = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //then
        int counter = 0;
        while (rs.next()){
            System.out.println(rs.getInt("ID") + ". " + rs.getString("FIRSTNAME") + ", " + rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(5, counter);
    }

    @Test
    public void testSelectUsersAndPosts() throws SQLException{
        //given
        DbManager dbManager = DbManager.getInstance();
        //when
        String sqlQuery  = "SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POST_QUANTITY\n" +
                            "FROM USERS U\n" +
                            "JOIN POSTS P ON U.ID = P.USER_ID\n" +
                            "GROUP BY U.FIRSTNAME, U.LASTNAME\n" +
                            "HAVING POST_QUANTITY >= 2;";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //then
        int counter = 0;
        while (rs.next()){
            System.out.println(rs.getString("FIRSTNAME") + " " + rs.getString("LASTNAME") + ", post quantity: " + rs.getInt("POST_QUANTITY"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(1, counter);
    }
}
