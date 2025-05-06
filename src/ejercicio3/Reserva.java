package ejercicio3;
import java.io.*;

public class Reserva implements Serializable {

	private int numHabitacion;
	private String nombreCliente;
	private String fechaReserva;
	
	// CONSTRUCTOR
	public Reserva(int numHabitacion, String nombreCliente, String fechaReserva) {
		this.numHabitacion = numHabitacion;
		this.nombreCliente = nombreCliente;
		this.fechaReserva = fechaReserva;
	}
	
	// GETTERS
	public int getNumHabitacion() {
		return numHabitacion;
	}
	
	public String getNombreCliente() {
		return nombreCliente;
	}	
	
	public String getFechaReserva() {
		return fechaReserva;
	}
	
	// SETTERS
	public void setNumHabitacion(int numHabitacion) {
		this.numHabitacion = numHabitacion;
	}
	
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	public void setFechaReserva(String fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
	
	@Override
	public String toString() {
		return "Habitacion: " + numHabitacion + ", a nombre de: " + nombreCliente + ", para el dia: " + fechaReserva;	
	}
}
