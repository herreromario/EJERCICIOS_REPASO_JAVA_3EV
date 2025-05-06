package ejercicio2;
import java.io.*;

public abstract class Estudiante implements Serializable{
	
	private String nombre;
	private int edad;
	
	// CONSTRUCTOR
	public Estudiante(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	// GETTERS
	public String getNombre() {
		return nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	// SETTERS
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public abstract String toString();
}
