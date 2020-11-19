/* todo Exercises
a. Create a connection to your local instance world database.
- The URL should look like this: "jdbc:mysql://localhost/world"
- Create the connection like this:
Connection connection = null;
connection = DriverManager.getConnection(URL, username, password);
- NOTE: the second line in the above step, must be in a try/catch. - ALSO NOTE: You have to define String username and String password with your MySQL login (root/<password>)
- THIRD NOTE: If you're having trouble finding the correct driver for the JDBC, try the following and use the one, that doesn't have "bin" in the name:
https://efif.sharepoint.com/:u:/s/cph/Lyngby/Ea3K8LZeFStJjX-XHiTc-RgBK2qD7pe4z5ND8MilZ0lVsw

b. Create a prepared statement, that retrieves the count of all cities in the city table. Write the result to console.

c. Create a prepared statement, that retrieves all cities with a population greater than 5.000.000 and prints each result to console.

d. Create a class called City with relevant data fields, and populate an arraylist<City> with the results retrieved from the above task (c).

e. Override toString for the City class and print the arrayList to console.

f. Close connection
 */
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Database.database();
    }
}