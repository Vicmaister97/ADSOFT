package es.uam.eps.ads.p3.biblioteca;

public class Libro extends Obra{
	private String editorial;
	private long n_edicion;
	private int contador;	/*numero de veces que se ha prestado */
	
	public Libro(String titulo, String autor, int anio, String editorial, long n_edicion) {
		super(titulo, autor, anio);
		this.editorial = editorial;
		this.n_edicion = n_edicion;
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
	public long getN_edicion() {
		return n_edicion;
	}
	public void setN_edicion(long n_edicion) {
		this.n_edicion = n_edicion;
	}
	
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
