package ejercicioRepaso_ClubLectura;
import java.util.*;
import java.io.*;

public class Lector implements Serializable {
	private String nombre;
	private int edad;
	private ArrayList<Libro> listaLibros;
	
	// CONSTRUCTOR
	public Lector(String nombre, int edad, ArrayList<Libro> listaLibros) {
		this.nombre = nombre;
		this.edad = edad;
		this.listaLibros = listaLibros;
	}
	
	// GETTTERS
	public String getNombre() {
		return nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}
	
	// SETTERS
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void setListaLibros(ArrayList<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}
	
	
	@Override
	public String toString() {
		String datosLector = "Nombre: " + nombre + ", Edad: " + edad + ", Libros a su nombre: ";
		String librosDelLector = "";
		Collections.sort(listaLibros);
		for (Libro libro : listaLibros) {
			librosDelLector += libro.toString();
		}
		return datosLector + librosDelLector; 
	}
	
}
