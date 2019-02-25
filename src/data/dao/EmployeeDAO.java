/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.ConexionBD;
import data.to.EmployeeData;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Struct;
import java.sql.Types;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleTypes;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

/**
 *
 * @author Billy
 */
public class EmployeeDAO {

    public EmployeeData doLogin(String username, String password) {
        EmployeeData retorno = null;
        Connection conn = ConexionBD.getConexion();
        if (conn != null) {
            try {
                OracleCallableStatement cst = (OracleCallableStatement) conn.prepareCall("{CALL ? := login(?,?)}");

                cst.registerOutParameter(1, OracleTypes.STRUCT, "EMPLOYEE_DATA");
                cst.setString(2, username);
                cst.setString(3, password);

                cst.executeQuery();

                STRUCT st = (STRUCT) cst.getObject(1);

                if (st != null) {
                    Object[] x = st.getAttributes();

                    retorno = new EmployeeData();
                    retorno.emp_id = ((BigDecimal) x[0]).intValue();
                    retorno.emp_first_name = (String) x[1];
                    retorno.emp_last_name = (String) x[2];
                    System.out.println("Identificado : " + retorno);
                } else {
                    System.out.println("Usuario o contrasenia no validos");
                }

                cst.close();
                cst = null;
                conn.close();
                conn = null;

            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } else {
            System.out.println("Error al conectar a la base de datos.");
        }
        return retorno;

    }

    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        dao.doLogin("luis", "luisalberto");
    }

}
