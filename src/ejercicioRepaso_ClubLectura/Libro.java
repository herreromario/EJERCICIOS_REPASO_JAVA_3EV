package ejercicioRepaso_ClubLectura;

import java.io.*;

public class Libro implements Comparable<Libro>, Serializable {
	private String titulo;
	private String autor;
	private int anioPublicacion;
	
	// CONSTRUCTOR
	public Libro(String titulo, String autor, int anioPublicacion) {
		this.titulo = titulo;
		this.autor = autor;
		this.anioPublicacion = anioPublicacion;
	}
	
	// GETTERS
	public String getTitulo() {
		return titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public int getAnioPublicacion() {
		return anioPublicacion;
	}
	
	// SETTERS
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}

	@Override
	public String toString() {
		return "\n Titulo: " + titulo + ", Autor: " + autor + ", Anio de publicacion: " + anioPublicacion;
	}
	
	// COMPARE TO
	@Override
	public int compareTo(Libro otroLibro) {
		return Integer.compare(this.anioPublicacion, otroLibro.anioPublicacion);
	}
}
