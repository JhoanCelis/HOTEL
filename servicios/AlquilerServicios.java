/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Alquiler;

/**
 *
 * @author Hp
 */
public class AlquilerServicios {
    public void guardar(Connection conexion, Alquiler alquiler) throws SQLException{
      try{
          
         PreparedStatement consulta;
         consulta = conexion.prepareStatement("INSERT INTO alquiler (idusuario, idhabitacion, cantidad, fecha) "
                 + "VALUES(?, ?, ?, ?)");        
         consulta.setString(1, alquiler.getUsuario().getId());
         consulta.setInt(2, alquiler.getHabitacion().getId());
         consulta.setInt(3, alquiler.getCantidad());
         consulta.setDate(4, alquiler.getFecha());
         consulta.executeUpdate();
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
   }
}
