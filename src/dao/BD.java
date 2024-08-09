package dao;
import org.h2.tools.RunScript;

import java.io.FileReader;
import java.sql.*;
import java.sql.DriverManager;

public class BD {
    public static void ejecutarScript() {
        Connection connection = null;
        try {
            connection = getConnection();

            RunScript.execute(connection, new FileReader("src/Script.sql"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:mem:runnerz", "sa", "");
    }
}
