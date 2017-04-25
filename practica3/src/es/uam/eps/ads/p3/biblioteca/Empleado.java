package es.uam.eps.ads.p3.biblioteca;

/**
* En este fichero se encuentra la implementacion de la clase Empleado
* @author Estudiante EPS alfonso.carvajal@estudiante.uam.es victor.garciacarrerea@estudiante.uam.es
*
*/

public class Empleado extends Usuario{
	private double sancion;
	public Empleado(String nombre) {
		super(nombre);
		this.setLimPrestados(20);
		this.setSancion(0.0);
	}

	public double getSancion() {
		return sancion;
	}
	public void setSancion(double sancion) {
		this.sancion = sancion;
	}
	
	/**
	* Incrementa el valor de ejemplares que posee el usuario
	*
	* @param p Prestamo que se quiere añadir
	*
	*/
	public void anyadirPrestamo(Prestamo p){
		if(this.getNumPrestados() < this.getLimPrestados()){
			this.setNumPrestados(this.getNumPrestados() + 1);
			p.cambiarStatus();
		}
		else System.out.println("Ha superado el numero maximo de prestamos");	
	}
	
	
	/**
	* Sanciona a un usuario empleado por retraso en devolucion
	* siendo este no valido si es menor que 4 el numero de dias 
	* que han pasado
	* si la sancion se aplica, se multiplica 2.5 por dia de retraso
	*
	* @param dias, int numero de dias de retraso
	*

	*/
	public void sancionarPorRetraso(int dias){
		if(dias > 4){
			this.sancion = this.sancion + 2.5*dias;
		}
	}
	
	/**
	* Resetea la sancion de un usuario a 0
	*
	*/
	public void eliminarSancion(){
		if(this.sancion <= 0){
			System.out.println("No tiene sancion");
		}
		else this.sancion = 0.0;
	}
	
	public String toString() {
		if(this.sancion <= 0){
			return "[E: " + this.getNombre() + "]";
		}
		else return "[E: " + this.getNombre() + " $" + this.sancion + "]";
	}
	
}
