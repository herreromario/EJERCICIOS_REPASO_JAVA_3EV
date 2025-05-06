package ejercicio2;

public class EstudianteSecundaria extends Estudiante {
	
	private String curso;

	// CONSTRUCTOR
	public EstudianteSecundaria(String nombre, int edad, String curso) {
		super(nombre, edad);
		this.curso = curso;
	}
	
	// GETTERS
	public String getCurso() {
		return curso;
	}
	
	// SETTERS
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	@Override
    public String toString() {
        return "Estudiante de Secundaria - Nombre: " + getNombre() + ", Edad: " + getEdad() + ", Curso: " + curso;
    }
}
