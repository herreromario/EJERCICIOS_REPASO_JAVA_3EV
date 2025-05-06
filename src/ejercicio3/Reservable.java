package ejercicio3;

import java.util.ArrayList;

public interface Reservable {

	public void anyadirReserva(ArrayList<Reserva> listaReservas);
	
	public void cancelarReserva(ArrayList<Reserva> listaReservas);
	
	public void listarReservas(ArrayList<Reserva> listaReservas);
}
