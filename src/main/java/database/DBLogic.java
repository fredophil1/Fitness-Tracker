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
            System.out.println("Daten Können nicht geschrieben werden");
            e.printStackTrace();
            return 0;
        }
    }

}