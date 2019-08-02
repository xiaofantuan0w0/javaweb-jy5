package com.itdr.testdemo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DemoTest1 {

    @Test
    public void test1() throws SQLException {
        ComboPooledDataSource co = new ComboPooledDataSource();
        Connection con = co.getConnection();
        String sql = "select * from users";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString(2));
        }

    }
}
