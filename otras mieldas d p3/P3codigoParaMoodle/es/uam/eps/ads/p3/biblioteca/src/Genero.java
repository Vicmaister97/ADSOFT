
public class Genero {
	private String nombre;

	public Genero(String nombre) {
		super();
		this.setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public static final Genero DRAMA = new Genero("Drama");
	public static final Genero TERROR = new Genero("Terror");
	public static final Genero COMEDIA = new Genero("Comedia");
	
}
