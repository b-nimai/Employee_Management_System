package Employee;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = (Connection) DriverManager.getConnection("jdbc:mysql:///employeemanagmentsystem", "root", "NimaiMySql@2000");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
