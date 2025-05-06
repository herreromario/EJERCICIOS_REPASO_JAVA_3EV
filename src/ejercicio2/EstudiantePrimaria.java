package ejercicio2;

public class EstudiantePrimaria extends Estudiante {

	// CONSTRUCTOR
	public EstudiantePrimaria(String nombre, int edad) {
		super(nombre, edad);
	}
	
	@Override
    public String toString() {
        return "Estudiante de Primaria - Nombre: " + getNombre() + ", Edad: " + getEdad();
    }
}
