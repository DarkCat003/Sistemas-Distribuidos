package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    Connection con = null;
    public Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sURL = "jdbc:mysql://localhost:3306/clientes";
            con = DriverManager.getConnection(sURL, "admin", "miloj");
        }
       catch (Exception e) {
        e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return con;
    }
}

