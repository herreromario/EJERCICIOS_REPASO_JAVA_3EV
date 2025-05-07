package ejercicioRepaso_ClubLectura;
import java.util.*;
import java.io.*;

public class ClubLectura {

	private final static Scanner sc = new Scanner(System.in);
	private static ArrayList<Lector> listaLectores = new ArrayList<Lector>();
	private static ArrayList<Libro> listaLibros = new ArrayList<Libro>();
	
	private static File file = new File("ClubLectura2025.txt");
	
	public static void main(String[] args) {

		cargarLectores();
		
		int opcion;
		do {
			mostrarMenu(); // Mostrar menu al usuario
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				anyadirLector(listaLectores);
				break;
			case 2:
				anyadirLibro(listaLibros);
				break;
			case 3:
				eliminarLector(listaLectores);
				break;
			case 4:
				eliminarLibro(listaLibros);
				break;
			case 5:
				anyadirLibroALector(listaLectores, listaLibros);
				break;
			case 6:
				listarLibrosPorLector(listaLectores);
				break;
			case 0:
				guardarLectores();
				System.out.println("\nGracias por usar nuestro sistema gestor del CLUB DE LECTURA!");
				break;
			default:
				System.out.println("\nOpcion no valida, intentelo de nuevo");
			}

		} while (opcion != 0);
	}

	public static void mostrarMenu() {
		System.out.println("\n-- MENU CLUB DE LECTURA --");
		System.out.println("1. Anyadir Lector");
		System.out.println("2. Anyadir Libro");
		System.out.println("3. Eliminar Lector");
		System.out.println("4. Eliminar Libro");
		System.out.println("5. Asignar Libro a Lector");
		System.out.println("6. Listar Libros por lector");
		System.out.println("0. Salir\n");
		System.out.print("Elija una opcion: ");
	}
	
	public static void anyadirLector(ArrayList<Lector> listaLectores) {
		System.out.println("\n\n-- ANYADIR LECTOR --");
		System.out.print("\nNombre: ");
		String nombre = sc.nextLine();
		if (!(buscarLector(nombre, listaLectores) == null)) {
			System.err.println("\nEl lector '" + nombre + "' ya existe.\n");
		} else {
			System.out.print("\nEdad: ");
			int edad = sc.nextInt();
			sc.nextLine();
			ArrayList<Libro> listaLibrosLeidos = new ArrayList<Libro>();
			
			Lector lector = new Lector(nombre, edad, listaLibrosLeidos);
			listaLectores.add(lector);
			
			System.out.println("\nLector '" + nombre + "' anyadido CORRECTAMENTE\n");
			
		}
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
			System.out.print("\nAnio de publicacion: ");
			int anioPublicacion = sc.nextInt();
			sc.nextLine();
			
			Libro libro = new Libro(titulo, autor, anioPublicacion);
			listaLibros.add(libro);
			
			System.out.println("\nLibro '" + titulo + "' anyadido CORRECTAMENTE\n");
		}
	}
	
	public static void eliminarLector(ArrayList<Lector> listaLectores) {
		System.out.println("\n-- ELIMINAR LECTOR --");
		// Intenta buscar el lector a eliminar por el NOMBRE
		try {
			System.out.print("\nIntroduce el NOMBRE del lector que quieres eliminar: ");
			String nombre = sc.nextLine();
			if (!(buscarLector(nombre, listaLectores) == null)) {
				listaLectores.remove(buscarLector(nombre, listaLectores));
				System.out.println("\nEl lector '" + nombre + "' ha sido eliminado de la lista.\n");
			} else {
				throw new NoSuchElementException("No se encontro el lector '" + nombre + "'");
			}
		} catch (NoSuchElementException e) {
			System.err.println("\nError: " + e.getMessage() + "\n");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void eliminarLibro(ArrayList<Libro> listaLibros) {
		System.out.println("\n-- ELIMINAR LIBRO --");
		// Intenta buscar el libro a eliminar por el TITULO
		try {
			System.out.print("\nIntroduce el NOMBRE del libro que quieres eliminar: ");
			String titulo = sc.nextLine();
			if (!(buscarLibro(titulo, listaLibros) == null)) {
				listaLibros.remove(buscarLibro(titulo, listaLibros));
				System.out.println("\nEl libro '" + titulo + "' ha sido eliminado de la lista.\n");
			} else {
				throw new NoSuchElementException("No se encontro el libro '" + titulo + "'");
			}
		} catch (NoSuchElementException e) {
			System.err.println("\nError: " + e.getMessage() + "\n");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void anyadirLibroALector(ArrayList<Lector> listaLectores, ArrayList<Libro> listaLibros) {
		System.out.println("\n\n-- ANYADIR LIBRO A LECTOR --");
		try {
			System.out.print("\nNombre del lector: ");
			String nombre = sc.nextLine();
			if (!(buscarLector(nombre, listaLectores) == null)) {
				try {
					System.out.print("\nIntroduce el NOMBRE del libro que asignar a " + nombre + ": ");
					String titulo = sc.nextLine();
					if (!(buscarLibro(titulo, listaLibros) == null)) {
						buscarLector(nombre, listaLectores).getListaLibros().add((buscarLibro(titulo, listaLibros)));
						System.out.println("\nEl libro '" + titulo + "' ha sido anyadido a la lista de libros de " + nombre +  ".\n");
					} else {
						throw new NoSuchElementException("No se encontro el libro '" + titulo + "'");
					}
				} catch (NoSuchElementException e) {
					System.err.println("\nError: " + e.getMessage() + "\n");
					// TODO: handle exception
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			} else {
				throw new NoSuchElementException("No se encontro el lector '" + nombre + "'");
			}
		} catch (NoSuchElementException e) {
			System.err.println("\nError: " + e.getMessage() + "\n");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static void listarLibrosPorLector(ArrayList<Lector> listaLectores) {
		try {
			if (!listaLectores.isEmpty()) {
				System.out.println("\nLectores en el club: " + listaLectores.size() + "\n");
				for (Lector lector : listaLectores) {
					System.out.println(lector);
					System.out.println();
				}
			} else {
				throw new IndexOutOfBoundsException("La lista de lectores esta vacia.");
			}
		} catch (IndexOutOfBoundsException e) {
			System.err.println("\nError: " + e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static Lector buscarLector(String nombre, ArrayList<Lector> listaLectores) {
		Lector lectorSospechoso = null;
		for (Lector lectorBuscado : listaLectores) {
			if (nombre.equalsIgnoreCase(lectorBuscado.getNombre())) {
				lectorSospechoso = lectorBuscado;
			}
		}
		return lectorSospechoso;
	}
	
	public static Libro buscarLibro(String titulo, ArrayList<Libro> listaLibros) {
		Libro libroSospechoso = null;
		for (Libro libroBuscado : listaLibros) {
			if (titulo.equalsIgnoreCase(libroBuscado.getTitulo())) {
				libroSospechoso = libroBuscado;
			}
		}
		return libroSospechoso;
	}
	
	public static void cargarLectores() {
	    try {
	        if (file.exists() && file.length() > 0) {
	            FileInputStream fis = new FileInputStream(file);
	            ObjectInputStream ois = new ObjectInputStream(fis);

	            listaLectores = (ArrayList<Lector>) ois.readObject();

	            ois.close();
	            fis.close();
	        } else {
	            file.createNewFile();
	        }
	    } catch (IOException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void guardarLectores() {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(listaLectores);

			fos.close();
			oos.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
