package es.uam.eps.ads.p3.biblioteca;

/**
* En este fichero se encuentra la implementacion de la clase Publico
* @author Estudiante EPS alfonso.carvajal@estudiante.uam.es victor.garciacarrerea@estudiante.uam.es
*
*/

public class Publico extends Usuario{
	private int ppb;
	public Publico(String nombre) {
		super(nombre);
		this.setLimPrestados(2);
		this.ppb = 0;
	}
	
	public void setLim(){
			this.setLimPrestados(2);
	}
	/**
	* Actualiza los prestamos para bonificar
	* Si sobrepasa el limite de prestamos simultaneos del usuario
	* se incrementa este limite y  se inicializa
	* el numero de prestamos para bonificar a 1
	*
	*/
	public void actualizarPpb(){
		this.ppb++;
		if(this.ppb > this.getLimPrestados()){
			this.setLimPrestados(this.getLimPrestados() + 1);
			this.ppb = 1;
		}
	}
	/**
	* Incrementa los el valor de ejemplares que posee el usuario
	*
	* @param p Prestamo que se quiere añadir
	*
	*/
	public void anyadirPrestamo(Prestamo p){
			super.addNumPrestados();
			this.actualizarPpb();
			p.cambiarStatus();
			p.getEjemplar().getObra().actualizarContador();
	}
	/**
	* Reduce en n el numero de prestamos para bonificar y resetea
	* el limite de prestamos simultaneos a 2
	* si es menor que 0, se resetea este numero a 0
	*
	* @param n int, numero que se quiere reducir
	*
	*/
	public void reduceLimPrestados(int n){	   
		this.ppb -= n;
		if(this.ppb < 0){
			this.ppb = 0;
		}
		this.setLimPrestados(2);
	}
	/**
	* Sanciona al usuario mediante la llamada al metodo reduceLimPrestados
	* 
	*
	* @param dias, int numero de dias de retraso
	*
	*/
	public void sancionarPorRetraso(int dias){
		reduceLimPrestados(dias);
	}
	
	public String toString() {
		return "[P: " + super.getNombre() + ",ppb:" + this.ppb + ",ps:" + super.getLimPrestados()
				+ "]";
	}


}
