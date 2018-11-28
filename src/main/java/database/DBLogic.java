package database;

import sample.Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.text.html.HTML.Tag.SELECT;

public class DBLogic {

    private static final String USERNAME = "root";
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

    public void connectionClose() {

        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int dbInsertClient(String firstname, String lastname, int age, int size, Double weight, String activity, Double palvalue, boolean sportActivity) {

        try {
            Statement stmt = con.createStatement();
            return stmt.executeUpdate("INSERT INTO client (Vornamedb,Nachnamedb,Alterdb,Groeßedb,Gewichtdb,Taetigkeitdb,Palvaluedb,Trainingdb) VALUES ('" + firstname + "', '" + lastname + "', '" + age + "', '" + size + "','" + weight + "','" + activity + "','" + palvalue + "','" + sportActivity + "')");

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }

    public int dbInsertMeals(String meal, double mealCarbs, double mealFat, double mealProtein, double mealCalories) {

        try {
            Statement stmt = con.createStatement();
            return stmt.executeUpdate("INSERT INTO meals (Mahlzeitdb,Kohlenhydratedb,Fettdb,Proteindb,Kaloriendb) VALUES ('" + meal + "', '" + mealCarbs + "', '" + mealFat + "', '" + mealProtein + "','" + mealCalories + "')");

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }

    public int dbInsertTraining(String lifting, String cardio, int trainingDuration) {

        try {
            Statement stmt = con.createStatement();
            return stmt.executeUpdate("INSERT INTO training (Kraftrainingdb,Cardiodb,Trainingsdauer) VALUES ('" + lifting + "', '" + cardio + "', '" + trainingDuration + "')");

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }


    public int dbInsertNutrition(double bmi, double carbs, double fat, double protein, double calories){

        try {
            Statement stmt = con.createStatement();
            return stmt.executeUpdate("INSERT INTO nutrition (bmi,carbsdbtgl,fettdbtgl,proteindbtgl,caloriesdbtgl) VALUES ('" + bmi + "', '" + carbs + "', '" + fat + "', '" + protein + "', '" + calories + "')");

        } catch (SQLException e) {
            System.out.println("Daten Können nicht geschrieben werden");
            e.printStackTrace();
            return 0;
        }

    }

    public int dbUpdateNutrition(double bmi, double carbs, double fat, double protein, double calories) {

        try {
            Statement stmt = con.createStatement();
            return  stmt.executeUpdate("UPDATE `nutrition` SET `fettdbtgl`= + '" +fat+"',`proteindbtgl`= + '"+protein+"',`carbsdbtgl`= + '"+carbs+"',`caloriesdbtgl`= + '"+calories+"',`bmi`= + '"+bmi+"' WHERE clientnutid = 1");
        } catch (SQLException e) {

            e.printStackTrace();
            return 0;
        }
    }

    public int dbSelectNutrition(){

        ArrayList <String> list = new ArrayList<>();
        list.clear();


        try {
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM `nutrition` WHERE clientnutid=1");


            while (rs.next()) {


                list.add(String.valueOf(rs.getDouble("fettdbtgl")));
                list.add(String.valueOf(rs.getDouble("carbsdbtgl")));
                list.add(String.valueOf(rs.getDouble("proteindbtgl")));
                list.add(String.valueOf(rs.getDouble("caloriesdbtgl")));

                Controller controller = new Controller();

                controller.testmethod(list.get(1));

                System.out.println(list);


            }



            rs.close();


            return 0;
        } catch (SQLException e) {

            e.printStackTrace();
            return 0;
        }
    }

}