package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/";


    private final String DB = "dbsistemas?useSSL=false&useTimezone=true&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASS = "123456";


    public Connection cadena_conexion;
    
    public static Conexion instancia;

    private Conexion() {
        this.cadena_conexion = null;
    }

    public Connection conectar() {
        try {
            Class.forName(DRIVER);
            this.cadena_conexion = DriverManager.getConnection(URL + DB, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
           JOptionPane.showMessageDialog(null, "Error al conectar: " + e.getMessage());
           System.exit(0);
        }
        return this.cadena_conexion;
    }
    
    

    public void desconectar() {
        try {
            this.cadena_conexion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al desconectar: " + e.getMessage());
        }
    }


    public synchronized static Conexion getInstancia() {//synchronized para que no se pueda acceder a la misma vez a la misma instancia

        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;    
     }


    
    
}