package Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    Connection c;
    Statement s;

    public conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "$nEeH@4285"); // Update with your MySQL credentials

            s = c.createStatement();
            s.executeUpdate("CREATE DATABASE IF NOT EXISTS db"); // Database creation
            s.executeUpdate("USE db");
            s.executeUpdate("CREATE TABLE IF NOT EXISTS users(username VARCHAR(255), email VARCHAR(255), password VARCHAR(255))"); // Adding username column

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
