
public class Pelicula extends Obra{
	private Genero genero;

	public Pelicula(String titulo, String autor, int anio, Genero genero) {
		super(titulo, autor, anio);
		this.genero = genero;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
}
