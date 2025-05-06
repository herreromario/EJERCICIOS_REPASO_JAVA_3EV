package ejercicio1;

// ATRIBUTOS DE LA CLASE LIBRO

public class Libro {
	private String titulo;
	private String autor;
	private double precio;

	// CONSTRUCTOR
	public Libro(String titulo, String autor, double precio) {
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
	}
	
	// GETTERS
	public String getTitulo() {
		return titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public double getPrecio() {
		return precio;

	}

	// SETTERS

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		String infoLibro = "\nTitulo: " + titulo + "\n"
				+ "Autor: " + autor + "\n"
				+ "Precio: " + precio;
		return infoLibro;

	}

}