package bd;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
public class Bd {
    public Connection conexion; 
     Statement sentencia;
     
    public static void main(String[] args) {
        form1 f = new form1();
        f.setVisible(true);
        
        
    }
    
    public void PrepararBaseDatos() {  
        try{ 
            String controlador="com.mysql.jdbc.Driver"; 
            Class.forName (controlador).newInstance(); 
            String DSN="jdbc:mysql://localhost/bd"; 
            String user="root"; 
            String password=""; 
            conexion=DriverManager.getConnection(DSN,user,password); 
        } 
        catch (Exception e) { 
            JOptionPane.showMessageDialog(null,"Error al realizar la conexion"); 
        }        
       
     } 
    
    public  void insertar(int id,int dni, String nombre, String apellido) throws SQLException{
        PrepararBaseDatos();
 
        
        
      // the mysql insert statement
      String query = " insert into persona (id, dni, apellido,nombre)"
        + " values (?, ?, ?, ?)";

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = this.conexion.prepareStatement(query);
      preparedStmt.setInt (1, id);
      preparedStmt.setInt (2, dni);
      preparedStmt.setString (3, nombre);
      preparedStmt.setString (4, apellido);

      // execute the preparedstatement
      preparedStmt.execute();
      
      this.conexion.close();
    }
         
public void validar (int id,int dni, String nombre, String apellido){



}


}



    

   
    

