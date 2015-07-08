/*
 * Copyright (C) 2015 ChristianM
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Modelo;

/**
 *
 * @author ChristianM
 */
public class Empleado {
    private int IdEmpleado;
    private int IdTipoEmpleado;
    private double sueldo;

    public Empleado() {
    }

    public Empleado(int IdEmpleado, int IdTipoEmpleado, double sueldo) {
        this.IdEmpleado = IdEmpleado;
        this.IdTipoEmpleado = IdTipoEmpleado;
        this.sueldo = sueldo;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public int getIdTipoEmpleado() {
        return IdTipoEmpleado;
    }

    public void setIdTipoEmpleado(int IdTipoEmpleado) {
        this.IdTipoEmpleado = IdTipoEmpleado;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    
}
