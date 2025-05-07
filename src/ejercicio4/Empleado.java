package ejercicio4;

import java.io.Serializable;

public abstract class Empleado implements Serializable {
	protected String nombre;
	protected double salario;
	
	// CONSTRUCTOR
	public Empleado(String nombre, double salario) {
		this.nombre = nombre;
		this.salario = salario;
	}
	
	// GETTERS
	public String getNombre() {
		return nombre;
	}
	
	public double getSalario() {
		return salario;
	}
	
	// SETTERS
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	@Override
	public abstract String toString();
}
