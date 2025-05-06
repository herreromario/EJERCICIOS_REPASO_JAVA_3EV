package ejercicio2;

import java.util.*;
import java.io.*;

public class Escuela {

	private final static Scanner sc = new Scanner(System.in);
	private static ArrayList<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();
	private static File file = new File("Estudiantes2025.txt");
	
	public static void main(String[] args) {
		
		cargarEstudiantes();
		
		int opcion;
		do {
			mostrarMenu(); // Mostrar menu al usuario
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				anyadirEstudiantePrimaria(listaEstudiantes);
				break;
			case 2:
				anyadirEstudianteSecundaria(listaEstudiantes);
				break;
			case 3:
				eliminarEstudiante(listaEstudiantes);
				break;
			case 4:
				listarEstudiantes(listaEstudiantes);
			case 0:
				guardarEstudiantes();
				System.out.println("\nGracias por usar nuestro sistema gestor de estudiantes!");
				break;
			default:
				System.out.println("\nOpcion no valida, intentelo de nuevo");
			}

		} while (opcion != 0);
	}

	public static void mostrarMenu() {
		System.out.println("\n-- MENU ESTUDIANTIL --");
		System.out.println("1. Anyadir Estudiante de Primaria");
		System.out.println("2. Anyadir Estudiante de Secundaria");
		System.out.println("3. Eliminar Estudiante");
		System.out.println("4. Listar Estudiantes");
		System.out.println("0. Salir\n");
		System.out.print("Elija una opcion: ");
	}
	
	public static void anyadirEstudiantePrimaria(ArrayList<Estudiante> listaEstudiantes) {
		System.out.println("\n\n-- ANYADIR ESTUDIANTE DE PRIMARIA --");
		System.out.print("\nNombre: ");
		String nombre = sc.nextLine();
		if (!(buscarEstudiante(nombre, listaEstudiantes) == null)) {
			System.err.println("\nEl estudiante '" + nombre + "' ya existe.\n");
		} else {
			System.out.print("\nEdad: ");
			int edad = sc.nextInt();
			EstudiantePrimaria estudiantePrimaria = new EstudiantePrimaria(nombre, edad);
			listaEstudiantes.add(estudiantePrimaria);
			
			System.out.println("\n¡ESTUDIANTE DE PRIMARIA ANYADIDO CORRECTAMENTE!\n");
		}
	}
	
	public static void anyadirEstudianteSecundaria(ArrayList<Estudiante> listaEstudiantes) {
		System.out.println("\n\n-- ANYADIR ESTUDIANTE DE SECUNDARIA --");
		System.out.print("\nNombre: ");
		String nombre = sc.nextLine();
		if (!(buscarEstudiante(nombre, listaEstudiantes) == null)) {
			System.err.println("\nEl estudiante '" + nombre + "' ya existe.\n");
		} else {
			System.out.print("\nEdad: ");
			int edad = sc.nextInt();
			sc.nextLine();
			System.out.print("\nCurso: ");
			String curso = sc.nextLine();
			EstudianteSecundaria estudianteSecundaria = new EstudianteSecundaria(nombre, edad, curso);
			listaEstudiantes.add(estudianteSecundaria);
			
			System.out.println("\n¡ESTUDIANTE DE SECUNDARIA ANYADIDO CORRECTAMENTE!\n");
		}
	}
	
	public static void eliminarEstudiante(ArrayList<Estudiante> listaEstudiantes) {
		System.out.println("\n-- ELIMINAR ESTUDIANTE --");
		// Intenta buscar el estudiante a eliminar por el NOMBRE
		try {
			System.out.print("\nIntroduce el NOMBRE del estudiante que quieres eliminar: ");
			String nombre = sc.nextLine();
			if (!(buscarEstudiante(nombre, listaEstudiantes) == null)) {
				listaEstudiantes.remove(buscarEstudiante(nombre, listaEstudiantes));
				System.out.println("\nEl estudiante '" + nombre + "' ha sido eliminado de la lista.\n");
			} else {
				throw new NoSuchElementException("No se encontro el estudiante '" + nombre + "'");
			}
		} catch (NoSuchElementException e) {
			System.err.println("\nError: " + e.getMessage() + "\n");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void listarEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
		try {
			if (!listaEstudiantes.isEmpty()) {
				System.out.println("\nEstudiantes listados: " + listaEstudiantes.size() + "\n");
				for (Estudiante estudiante : listaEstudiantes) {
					System.out.println(estudiante.toString());
				}
			} else {
				throw new IndexOutOfBoundsException("La lista de estudiantes esta vacia.");
			}
		} catch (IndexOutOfBoundsException e) {
			System.err.println("\nError: " + e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static Estudiante buscarEstudiante(String nombre, ArrayList<Estudiante> listaEstudiantes) {
		Estudiante estudianteSospechoso = null;
		for (Estudiante estudianteBuscado : listaEstudiantes) {
			if (nombre.equalsIgnoreCase(estudianteBuscado.getNombre())) {
				estudianteSospechoso = estudianteBuscado;
			}
		}
		return estudianteSospechoso;
	}
	
	public static void cargarEstudiantes() {
	    try {
	        if (file.exists() && file.length() > 0) {
	            FileInputStream fis = new FileInputStream(file);
	            ObjectInputStream ois = new ObjectInputStream(fis);

	            listaEstudiantes = (ArrayList<Estudiante>) ois.readObject();

	            ois.close();
	            fis.close();
	        } else {
	            file.createNewFile();
	        }
	    } catch (IOException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}


	public static void guardarEstudiantes() {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(listaEstudiantes);

			fos.close();
			oos.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
