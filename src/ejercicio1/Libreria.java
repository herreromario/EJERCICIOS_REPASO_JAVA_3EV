package ejercicio1;
import java.util.*;
import java.io.*;

public class Libreria {

	private final static Scanner sc = new Scanner(System.in);
	private static ArrayList<Libro> listaLibros = new ArrayList<Libro>();
	private static File file = new File("Libros2025.txt");

	public static void main(String[] args) {

		cargarLibreria();

		int opcion;
		do {
			mostrarMenu(); // Mostrar menu al usuario
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				anyadirLibro(listaLibros); // Anyadir libro a la biblioteca
				break;
			case 2:
				eliminarLibro(listaLibros); // Eliminar libro de la biblioteca
				break;
			case 3:
				listarLibros(listaLibros); // Listar libros de la biblioteca
				break;
			case 0:
				guardarLibreria();
				System.out.println("\nGracias por usar nuestro sistema gestor de libreria!");
				break;
			default:
				System.out.println("\nOpcion no valida, intentelo de nuevo");
			}

		} while (opcion != 0);
	}

	public static void mostrarMenu() {
		System.out.println("\n-- MENU BIBLIOTECA --");
		System.out.println("1. Anyadir libro");
		System.out.println("2. Eliminar libro");
		System.out.println("3. Listar libros");
		System.out.println("0. Salir\n");
		System.out.print("Elija una opcion: ");
	}

	public static void anyadirLibro(ArrayList<Libro> listaLibros) {
		System.out.println("\n\n-- ANYADIR LIBRO --");
		System.out.print("\nTitulo: ");
		String titulo = sc.nextLine();
		if (!(buscarLibro(titulo, listaLibros) == null)) {
			System.err.println("\nEl libro '" + titulo + "' ya existe.\n");
		} else {
			System.out.print("\nAutor: ");
			String autor = sc.nextLine();
			System.out.print("\nPrecio: ");
			double precio = sc.nextDouble();
			sc.nextLine(); // LIMPIAR BUFFER
			Libro libro = new Libro(titulo, autor, precio);
			listaLibros.add(libro);

			System.out.println("\n¡LIBRO ANYADIDO A LA LIBRERIA!\n");
		}

	}

	public static void eliminarLibro(ArrayList<Libro> listaLibros) {
		System.out.println("\n-- ELIMINAR LIBRO --");
		// Intenta buscar el libro a eliminar por el TITULO
		try {
			System.out.print("\nIntroduce el TITULO del libro que quieres eliminar: ");
			String titulo = sc.nextLine();
			if (!(buscarLibro(titulo, listaLibros) == null)) {
				listaLibros.remove(buscarLibro(titulo, listaLibros));
				System.out.println("\nEl libro '" + titulo + "' ha sido eliminado de la biblioteca.\n");
			} else {
				throw new NoSuchElementException("No se encontro el libro '" + titulo + "'");
			}
		} catch (NoSuchElementException e) {
			System.err.println("\nError: " + e.getMessage() + "\n");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void listarLibros(ArrayList<Libro> listaLibros) {
		try {
			if (!listaLibros.isEmpty()) {
				System.out.println("\nLibros disponibles: " + listaLibros.size());
				for (Libro libro : listaLibros) {
					System.out.println(libro.toString());
				}
			} else {
				throw new IndexOutOfBoundsException("La lista de libros esta vacia.");
			}
		} catch (IndexOutOfBoundsException e) {
			System.err.println("\nError: " + e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static Libro buscarLibro(String tituloLibro, ArrayList<Libro> listaLibros) {
		Libro libroSospechoso = null;
		for (Libro libroBuscado : listaLibros) {
			if (tituloLibro.equalsIgnoreCase(libroBuscado.getTitulo())) {
				libroSospechoso = libroBuscado;
			}
		}
		return libroSospechoso;
	}

	public static void cargarLibreria() {
		try {
			if (file.exists()) {
				// File --> ArrayList [DESERIALIZAR]
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				while (true) {
					try {
						Libro libro = (Libro) ois.readObject();
						listaLibros.add(libro);
					} catch (EOFException e) {
						break; // Fin del archivo alcanzado
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			} else {
				file.createNewFile();
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

	public static void guardarLibreria() {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(listaLibros); // Rellena la lista de libros

			fos.close();
			oos.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
