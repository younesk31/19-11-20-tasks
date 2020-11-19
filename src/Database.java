import java.sql.*;
import java.util.ArrayList;

public class Database {
    public static void database () throws SQLException, ClassNotFoundException {
        final String DBURL = "jdbc:mysql://localhost:3306/world?serverTimezone=UTC";
        final String DBUSER = "root";
        final String DBPASS = "1234";
        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

        System.out.println("Task: A - Connect to database 'World'");
        Class.forName(JDBC_DRIVER);
        Connection connection;
        connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        System.out.println("Connection to "+ connection +" established...");

        // TASK B
        System.out.println("\nTask: B - Retrieve the count of all cities");
        PreparedStatement pstmt = null;
        String sql = "SELECT count(*) FROM city";

        pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        rs.next();
        System.out.println("There is: " + rs.getInt(1) + " cities in the city table");


        // TASK C
        System.out.println("\nTask: C - Retrieve the count of all cities with a population greater than 5.000.000");
        pstmt = null;
        sql = "SELECT * FROM city WHERE population > 5000000";

        pstmt = connection.prepareStatement(sql);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println("ID:" + rs.getInt("id") +" - CityName: "+ rs.getString("name") + " - Population: " +rs.getInt("population"));
        }
        rs.close();
        pstmt.close();

        // TASK D
        System.out.println("\nTask: D - Create a class called City");

        ArrayList<City> cities = new ArrayList<>();

        pstmt = null;
        sql = "SELECT * FROM city WHERE population > 5000000";

        pstmt = connection.prepareStatement(sql);

        rs = pstmt.executeQuery();

        while (rs.next()) {
            cities.add(new City(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("countrycode"),
                    rs.getInt("population")
            ));
        }

        rs.close();
        pstmt.close();
        System.out.println("City's added to arraylist!");

        // TASK E - print out the city's in the arraylist
        System.out.println("\nTask: E");
        System.out.println("Printing 'City' Arraylist\n"+"-- ID ------------ CITY NAME ------------ COUNTRY CODE ------------ POPULATION ------------");
        for (City city : cities) {
            System.out.println(city.toString());
        }

        // TASK F - Quit
        System.out.println("\nTask: F");
        System.out.println("Connection to "+connection+" Closed.");
    }
}
