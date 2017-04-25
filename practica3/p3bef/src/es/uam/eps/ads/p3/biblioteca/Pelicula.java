package es.uam.eps.ads.p3.biblioteca;

public class Pelicula extends Obra{
	private Genero genero;

	public Pelicula(String titulo, String autor, int anio, Genero genero) {
		super(titulo, autor, anio);
		this.genero = genero;
		this.setPlazo(2);
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	public String toString() {
		return "[P:" + getTitulo() + ", de " + getAutor() + ",(" + getAnio() + ") plazo:"+ plazoPrestamo() + "]";
	}
	
	public void actualizarContador(){
		//this.contador++;
		}

	
}
