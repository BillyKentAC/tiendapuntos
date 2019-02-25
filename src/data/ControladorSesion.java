/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.to.EmployeeData;

/**
 *
 * @author Billy
 */
public class ControladorSesion {

    private static ControladorSesion instance;

    private EmployeeData datosEmpleado;

    private ControladorSesion() {

    }

    public static ControladorSesion getInstance() {
        if (instance == null) {
            instance = new ControladorSesion();
        }
        return instance;
    }

    public void setDatosEmpleado(EmployeeData datosEmpleado) {
        this.datosEmpleado = datosEmpleado;
    }

    public EmployeeData getDatosEmpleado() {
        return datosEmpleado;
    }
}
