package es.uam.eps.ads.p3.biblioteca;

/**
* En este fichero se encuentra la implementacion de la clase Obra
* @author Estudiante EPS alfonso.carvajal@estudiante.uam.es victor.garciacarrerea@estudiante.uam.es
*
*/

public class Obra {
	private String titulo;
	private String autor;
	private int anio;
	private int plazo;
	
	public Obra(String titulo, String autor, int anio) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.anio = anio;
		this.plazo = 0;
	}
	public String getTitulo() {
		return titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public int getAnio() {
		return anio;
	}
	
	public int plazoPrestamo() {
		return plazo;
	}
	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}
	
	public void actualizarContador(){
	}
	
	/**
	* Comprueba si una obra es igual a otra pasada por parametro 
	* (aunque sean distintos ejemplares)
	*
	* @param o Objeto que se desea comprobar
	*
	* @return Booleano True si es igual o False si no es igual
	*/
	public boolean equals(Object o){
		if(o != null && o instanceof Obra){
			Obra temp = (Obra)o;
			return (this.titulo == temp.getTitulo() && this.autor == temp.getAutor());
		}
		else{
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Obra [titulo=" + titulo + ", autor=" + autor + ", anio=" + anio + "]";
	}
	
}
