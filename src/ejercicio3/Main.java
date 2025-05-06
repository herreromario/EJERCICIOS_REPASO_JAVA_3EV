package ejercicio3;
import java.util.*;

public class Main {

	private final static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Reservable gestor = new GestorReservas(); // Polimorfismo

		GestorReservas.cargarReservas(); // Cargar reservas (no esta en interfaz)

		int opcion;
		do {
			mostrarMenu(); // Mostrar menu al usuario
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				gestor.anyadirReserva(GestorReservas.listaReservas);
				break;
			case 2:
				gestor.cancelarReserva(GestorReservas.listaReservas);
				break;
			case 3:
				gestor.listarReservas(GestorReservas.listaReservas);
				break;
			case 0:
				GestorReservas.guardarReservas();
				System.out.println("\nGracias por usar nuestro sistema gestor de reservas!");
				break;
			default:
				System.out.println("\nOpcion no valida, intentelo de nuevo");
			}
			
		} while (opcion != 0);
	}

	public static void mostrarMenu() {
		System.out.println("\n-- MENU HOTELERO --");
		System.out.println("1. Anyadir Reserva");
		System.out.println("2. Cancelar Reserva");
		System.out.println("3. Listar Reservas");
		System.out.println("0. Salir\n");
		System.out.print("Elija una opcion: ");
	}
}
