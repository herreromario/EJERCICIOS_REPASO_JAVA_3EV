package Ejercicio1;
import java.util.*;

public class Libreria {

	private final static Scanner sc = new Scanner(System.in);
	private static ArrayList<Libro> listaLibros = new ArrayList<Libro>();
	
	public static void main(String[] args) {
		int opcion;
        do {
            mostrarMenu(); // Mostrar menu al usuario
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                	anyadirLibro(listaLibros); // Añadir profesor
                    break;
                case 2:
                	eliminarLibro(listaLibros); // Añadir profesor interino
                    break;
                case 3:
                	listarLibros(listaLibros); // Probar métodos de las clases
                    break;
                case 0:
                    System.out.println("\nGracias por usar nuestro sistema gestor de libreria!");
                    break;
                default:
                    System.out.println("\nOpcion no valida, inténtelo de nuevo");
            }

        } while (opcion != 0);
    }

    public static void mostrarMenu() {
        System.out.println("\n-- MENU BIBLIOTECA --");
        System.out.println("1. Anyadir libro");
        System.out.println("2. Eliminar libro");
        System.out.println("3. Listar libros");
        System.out.println("0. Salir\n");
        System.out.print("Elija una opción: ");
    }
	
	public static void anyadirLibro(ArrayList<Libro> listaLibros) {
		System.out.println("\n\n-- ANYADIR LIBRO --");
		System.out.print("\nTitulo: ");
		String titulo = sc.nextLine();
		System.out.print("\nAutor: ");
		String autor = sc.nextLine();
		System.out.print("\nPrecio: ");
		double precio = sc.nextDouble();
		sc.nextLine(); // LIMPIAR BUFFER
		Libro libro = new Libro(titulo, autor, precio);
		listaLibros.add(libro);
		
		System.out.println("\n¡LIBRO ANYADIDO A LA LIBRERIA!\n");
	}
	
	public static void eliminarLibro(ArrayList<Libro> listaLibros) {
		System.out.println("\n-- ELIMINAR LIBRO --");
		// Intenta buscar el libro a eliminar por el TITULO
		try {
			System.out.print("\nIntroduce el TITULO del libro que quieres eliminar: ");
			String titulo = sc.nextLine();
			Libro libroEliminar = null;
			for (Libro libroBuscado : listaLibros) {
				if(titulo.equalsIgnoreCase(libroBuscado.getTitulo())) {
					libroEliminar = libroBuscado;
					listaLibros.remove(libroEliminar);
					System.out.println("\nEl libro " + libroEliminar.getTitulo() + " ha sido eliminado de la biblioteca.\n");
					// Si no lo encuentra lanza una EXCEPCION
				} else {
					throw new NoSuchElementException("No se encontro el libro '" + titulo + "'");
				}
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
	
}
