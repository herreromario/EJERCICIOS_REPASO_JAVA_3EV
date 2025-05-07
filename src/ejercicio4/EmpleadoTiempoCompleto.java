package ejercicio4;

public class EmpleadoTiempoCompleto extends Empleado {

	// CONSTRUCTOR
	public EmpleadoTiempoCompleto(String nombre, double salario) {
		super(nombre, salario);	
	}

	@Override
	public String toString() {
		return "\nContrato a tiempo completo - Nombre: " + nombre + ", Salario: " + salario;
	}
}
