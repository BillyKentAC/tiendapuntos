/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.to;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;
import oracle.sql.Datum;
import oracle.sql.ORAData;

/**
 *
 * @author Billy
 */
public class EmployeeData {

    public Integer emp_id;
    public String emp_first_name;
    public String emp_last_name;

    @Override
    public String toString() {
        return emp_first_name + " " + emp_last_name;
    }

}
