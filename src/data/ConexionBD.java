/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleDriver;

/**
 *
 * @author Billy
 */
public class ConexionBD {

    public static Connection getConexion() {
        Connection con = null;
        try {
            DriverManager.registerDriver(new OracleDriver());
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:ORCL", "tiendauser", "tienda"
            );
        } catch (SQLException e) {
            System.out.println("Error al registrar el driver "
                    + e.getMessage());
        }
        return con;
    }
}
