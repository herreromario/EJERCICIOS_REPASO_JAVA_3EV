package ejercicio4;

public class EmpleadoTiempoParcial extends Empleado {

	private double horasTrabajadas;
	
	//CONSTRUCTOR
	public EmpleadoTiempoParcial(String nombre, double salario, int horasTrabajadas) {
		super(nombre, salario);
		this.horasTrabajadas = horasTrabajadas;
	}

	// GETTER
	public double getHorasTrabajadas() {
		return horasTrabajadas;
	}
	
	// SETTER
	public void setHorasTrabajadas(double horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}
	
	@Override
	public String toString() {
		return "\nContrato a tiempo parcial - Nombre: " + nombre + ", Salario: " + salario + ", Horas trabajadas: " + horasTrabajadas;
	}

}
