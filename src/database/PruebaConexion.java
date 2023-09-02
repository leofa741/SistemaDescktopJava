package database;

public class PruebaConexion {

    public static void main(String[] args) {
        
        Conexion conexion = Conexion.getInstancia();
        conexion.conectar();

        System.out.println("Conexion exitosa");

        conexion.desconectar();
        
          System.out.println("DesConexion exitosa");
          
      
    }

    
}