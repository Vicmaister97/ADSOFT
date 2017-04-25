package es.uam.eps.ads.p3.biblioteca;

/**
* En este fichero se encuentra la implementacion de la clase Obra
* @author Estudiante EPS alfonso.carvajal@estudiante.uam.es victor.garciacarrerea@estudiante.uam.es
*
*/


public class Libro extends Obra{
	private String editorial;
	private long nEdicion;
	private int contador;	/*numero de veces que se ha prestado */
	
	public Libro(String titulo, String autor, int anio, String editorial, long nEdicion) {
		super(titulo, autor, anio);
		this.editorial = editorial;
		this.nEdicion = nEdicion;
		this.setPlazo(25);
		this.contador = 0;
	}
	public Libro(String titulo, String autor, int anio) {
		super(titulo, autor, anio);
		this.setPlazo(25);
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public long getnEdicion() {
		return nEdicion;
	}
	public void setnEdicion(long nEdicion) {
		this.nEdicion = nEdicion;
	}
	
	/**
	* Actualiza el contador de veces que se ha prestado un libro
	* cada vez que llegue a 10 se reduce por 1 el plazo de prestamo
	* de ese libro (obra), no llegando a ser este menor que 7 en 
	* ningun momento
	*
	*/
	public void actualizarContador(){
		this.contador++;
		if(this.contador == 10 && super.plazoPrestamo() > 7){	//cuando llegue a 10 se resetea a 0
			super.setPlazo(super.plazoPrestamo() - 1);
			this.contador = 0;
		}
	}
	
	public String toString() {
		return "[L:" + getTitulo() + ", de " + getAutor() + ",(" + getAnio() + ") plazo:"+ plazoPrestamo() + "]";
	}
	
}
