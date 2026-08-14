package com.food.test;

import java.sql.Connection;

import com.food.utility.DBConnection;

public class TestConnection {

	public static void main(String[] args) {
		Connection con = DBConnection.getConnection();

        if (con != null) {
            System.out.println("Database Connected Successfully");
        } else {
            System.out.println("Connection Failed");
        }

	}

}
