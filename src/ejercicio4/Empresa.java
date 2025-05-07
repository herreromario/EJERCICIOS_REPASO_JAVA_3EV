package ejercicio4;

import java.util.*;
import java.io.*;

public class Empresa {

	private final static Scanner sc = new Scanner(System.in);
	private static ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
	private static File file = new File("Empleados2025.txt");
	
	public static void main(String[] args) {
		
		cargarEmpleados();
		
		int opcion;
		do {
			mostrarMenu(); // Mostrar menu al usuario
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				anyadirEmpleadoCompleto(listaEmpleados);
				break;
			case 2:
				anyadirEmpleadoParcial(listaEmpleados);
				break;
			case 3:
				eliminarEmpleado(listaEmpleados);
				break;
			case 4:
				listarEmpleados(listaEmpleados);
				break;
			case 0:
				guardarEmpleados();
				System.out.println("\nGracias por usar nuestro sistema gestor de empleados!");
				break;
			default:
				System.out.println("\nOpcion no valida, intentelo de nuevo");
			}

		} while (opcion != 0);
	}

	public static void mostrarMenu() {
		System.out.println("\n-- MENU EMPRESA --");
		System.out.println("1. Anyadir Empleado a tiempo COMPLETO");
		System.out.println("2. Anyadir Empleado a tiempo PARCIAL");
		System.out.println("3. Eliminar Empleado");
		System.out.println("4. Listar Empleados");
		System.out.println("0. Salir\n");
		System.out.print("Elija una opcion: ");
	}
	
	// FUNCIONES PRINCIPALES
	public static void anyadirEmpleadoCompleto(ArrayList<Empleado> listaEmpleados) {
		System.out.println("\n\n-- ANYADIR EMPLEADO A TIEMPO COMPLETO --");
		System.out.print("\nNombre: ");
		String nombre = sc.nextLine();
		if (!(buscarEmpleado(nombre, listaEmpleados) == null)) {
			System.err.println("\nEl empleado '" + nombre + "' ya existe.\n");
		} else {
			System.out.print("\nSalario: ");
			double salario = sc.nextDouble();
			EmpleadoTiempoCompleto empleadoTiempoCompleto = new EmpleadoTiempoCompleto(nombre, salario);
			listaEmpleados.add(empleadoTiempoCompleto);
			
			System.out.println("\nEMPLEADO A TIEMPO COMPLETO ANYADIDO CORRECTAMENTE");
		}
	}
	
	public static void anyadirEmpleadoParcial(ArrayList<Empleado> listaEmpleados) {
		System.out.println("\n\n-- ANYADIR EMPLEADO A TIEMPO PARCIAL --");
		System.out.print("\nNombre: ");
		String nombre = sc.nextLine();
		if (!(buscarEmpleado(nombre, listaEmpleados) == null)) {
			System.err.println("\nEl empleado '" + nombre + "' ya existe.\n");
		} else {
			System.out.print("\nSalario: ");
			double salario = sc.nextDouble();
			System.out.print("\nHoras trabajadas: ");
			int horasTrabajadas = sc.nextInt();
			EmpleadoTiempoParcial empleadoTiempoParcial = new EmpleadoTiempoParcial(nombre, salario, horasTrabajadas);
			listaEmpleados.add(empleadoTiempoParcial);
			System.out.println("\nEMPLEADO A TIEMPO PARCIAL ANYADIDO CORRECTAMENTE");
		}
	}
	
	public static void eliminarEmpleado(ArrayList<Empleado> listaEmpleados) {
		System.out.println("\n-- ELIMINAR EMPLEADO --");
		// Intenta buscar el empleado a eliminar por el NOMBRE
		try {
			System.out.print("\nIntroduce el NOMBRE del empleado que quieres eliminar: ");
			String nombre = sc.nextLine();
			if (!(buscarEmpleado(nombre, listaEmpleados) == null)) {
				listaEmpleados.remove(buscarEmpleado(nombre, listaEmpleados));
				System.out.println("\nEl empleado '" + nombre + "' ha sido eliminado de la lista.\n");
			} else {
				throw new NoSuchElementException("No se encontro el empleado '" + nombre + "'");
			}
		} catch (NoSuchElementException e) {
			System.err.println("\nError: " + e.getMessage() + "\n");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void listarEmpleados(ArrayList<Empleado> listaEmpleados) {
		try {
			if (!listaEmpleados.isEmpty()) {
				System.out.println("\nEmpleados listados: " + listaEmpleados.size());
				for (Empleado empleado : listaEmpleados) {
					System.out.println(empleado.toString());
				}
			} else {
				throw new IndexOutOfBoundsException("La lista de empleados esta vacia.");
			}
		} catch (IndexOutOfBoundsException e) {
			System.err.println("\nError: " + e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// METODOS AUXILIARES Y GESTION DE ARCHIVOS
	public static Empleado buscarEmpleado(String nombre, ArrayList<Empleado> listaEmpleados) {
		Empleado empleadoSospechoso = null;
		for (Empleado empleadoBuscado : listaEmpleados) {
			if (nombre.equalsIgnoreCase(empleadoBuscado.getNombre())) {
				empleadoSospechoso = empleadoBuscado;
			}
		}
		return empleadoSospechoso;
	}
	
	public static void cargarEmpleados() {
	    try {
	        if (file.exists() && file.length() > 0) {
	            FileInputStream fis = new FileInputStream(file);
	            ObjectInputStream ois = new ObjectInputStream(fis);

	            listaEmpleados = (ArrayList<Empleado>) ois.readObject();

	            ois.close();
	            fis.close();
	        } else {
	            file.createNewFile();
	        }
	    } catch (IOException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void guardarEmpleados() {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(listaEmpleados);

			fos.close();
			oos.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

	
}
