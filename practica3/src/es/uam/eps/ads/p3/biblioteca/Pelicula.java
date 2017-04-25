package es.uam.eps.ads.p3.biblioteca;

/**
* En este fichero se encuentra la implementacion de la clase Pelicula
* @author Estudiante EPS alfonso.carvajal@estudiante.uam.es victor.garciacarrerea@estudiante.uam.es
*
*/

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

	
}
