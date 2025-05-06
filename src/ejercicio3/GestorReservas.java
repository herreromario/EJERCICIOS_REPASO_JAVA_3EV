package ejercicio3;
import java.util.*;
import java.io.*;

public class GestorReservas implements Reservable {

	private final static Scanner sc = new Scanner(System.in);
	public static ArrayList<Reserva> listaReservas = new ArrayList<Reserva>();
	private static File file = new File("Reservas2025.txt");
	
	public void anyadirReserva(ArrayList<Reserva> listaReservas) {
		System.out.println("\n\n-- ANYADIR RESERVA --");
		System.out.print("\nNumero de habitacion: ");
		int numHabitacion = sc.nextInt();
		sc.nextLine();
		if (!(buscarReserva(numHabitacion, listaReservas) == null)) {
			System.err.println("\nLa habitacion '" + numHabitacion + "' ya esta ocupada.\n");
		} else {
			System.out.print("\nNombre del cliente: ");
			String nombre = sc.nextLine();
			System.out.print("\nFecha de reserva: ");
			String fechaReserva = sc.nextLine();
			Reserva reserva = new Reserva(numHabitacion, nombre, fechaReserva);
			listaReservas.add(reserva);
			
			System.out.println("\n¡HABITACION '" + numHabitacion + "' RESERVADA CORRECTAMENTE!\n");
		}
	}

	public void cancelarReserva(ArrayList<Reserva> listaReservas) {
		System.out.println("\n-- CANCELAR RESERVA --");
		// Intenta buscar la reserva a cancelar por el NUMERO DE HABITACION
		try {
			System.out.print("\nIntroduce el NUMERO DE HABITACION de la reseva que quieres cancelar: ");
			int numHabitacion = sc.nextInt();
			if (!(buscarReserva(numHabitacion, listaReservas) == null)) {
				listaReservas.remove(buscarReserva(numHabitacion, listaReservas));
				System.out.println("\nLa reserva de la habitacion '" + numHabitacion + "' ha sido cancelada.\n");
			} else {
				throw new NoSuchElementException("No se encontro ninguna reserva para la habitacion '" + numHabitacion + "'");
			}
		} catch (NoSuchElementException e) {
			System.err.println("\nError: " + e.getMessage() + "\n");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void listarReservas(ArrayList<Reserva> listaReservas) {
		try {
			if (!listaReservas.isEmpty()) {
				System.out.println("\nReservas activas: " + listaReservas.size() + "\n");
				for (Reserva reserva : listaReservas) {
					System.out.println(reserva.toString());
				}
			} else {
				throw new IndexOutOfBoundsException("La lista de reservas esta vacia.");
			}
		} catch (IndexOutOfBoundsException e) {
			System.err.println("\nError: " + e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static Reserva buscarReserva(int numHabitacion, ArrayList<Reserva> listaReservas) {
		Reserva reservaSospechosa = null;
		for (Reserva reservaBuscada : listaReservas) {
			if (numHabitacion == reservaBuscada.getNumHabitacion()) {
				reservaSospechosa = reservaBuscada;
			}
		}
		return reservaSospechosa;
	}
	
	public static void cargarReservas() {
	    try {
	        if (file.exists() && file.length() > 0) {
	            FileInputStream fis = new FileInputStream(file);
	            ObjectInputStream ois = new ObjectInputStream(fis);

	            listaReservas = (ArrayList<Reserva>) ois.readObject();

	            ois.close();
	            fis.close();
	        } else {
	            file.createNewFile();
	        }
	    } catch (IOException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}

	public static void guardarReservas() {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(listaReservas);

			fos.close();
			oos.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}

