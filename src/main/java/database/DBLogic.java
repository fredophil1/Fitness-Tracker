package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBLogic {

    private static final String USERNAME = "freddi";
    private static final String PASSWORD = "";
    private static final String CONNECTOR = "jdbc:mysql://localhost/FitnessTrackerDB";

    Connection con = null;

    public void connection() {


        try {
            con = DriverManager.getConnection(CONNECTOR, USERNAME, PASSWORD);
            System.out.println("Connected");

        } catch (
                SQLException e) {
            System.out.println(e);
        }

    }

    public int dbInsert(String firstname, String lastname, int age, int size) {

        try {
            Statement stmt = con.createStatement();
            return stmt.executeUpdate("INSERT INTO client (Vornamedb,Nachnamedb,Alterdb,Groeßedb) VALUES ('" + firstname + "', '" + lastname + "', '" + age + "', '" + size + "')");

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }


    }

}





/*
    Connection con = null;
        try {
        con = DriverManager.getConnection(CONNECTOR, USERNAME, PASSWORD);
        System.out.println("Connected");


    } catch (
    SQLException e) {
        System.out.println(e);
    }finally {if(con != null){
        con.close();
    }
    }
    */

