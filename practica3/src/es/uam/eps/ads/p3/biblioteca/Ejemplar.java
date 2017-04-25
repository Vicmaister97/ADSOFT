package es.uam.eps.ads.p3.biblioteca;

import static es.uam.eps.ads.p3.tester.DatosPruebas.u4;

/**
* En este fichero se encuentra la implementacion de la clase Ejemplar
* @author Estudiante EPS alfonso.carvajal@estudiante.uam.es victor.garciacarrerea@estudiante.uam.es
*
*/

import java.time.Period;
import java.util.ArrayList;

import es.uam.eps.ads.p3.fechasimulada.FechaSimulada;

public class Ejemplar { 
	private Obra obra;
	private static int contador = 0;
	private int id;
	boolean disponible;
	private Prestamo prestamo;

	public Ejemplar(Obra obra) {
		super();
		this.setObra(obra);
		Ejemplar.contador++;
		this.id = Ejemplar.contador;
		this.disponible = true;
	}
	public Obra getObra() {
		return obra;
	}
	public void setObra(Obra obra) {
		this.obra = obra;
	}
	
	public int getId(){
		return this.id;
	}
	public void setPrestamo(Prestamo p){
		this.prestamo = p;
	}
	
	public Prestamo getPrestamo(){
		return this.prestamo;
	}
	
	public boolean getDisponible(){
		return this.disponible;
	}
	
	/**
	* Realiza la accion de prestar, comprobando si se puede
	* en caso de que si, se crea un objeto de clase prestamo
	* y se añade el ejemplar a la lista de prestados de usuario
	* se añade tambien el prestamo a la lista de prestamos pendientes
	* y se vuelve no disponible el ejemplar
	*
	* @param u Usuario, usuario que desea sacar un libro
	*
	* @return Prestamo, prestamo que sea ha realizado
	*/
	public Prestamo prestar(Usuario u){
		if(u.getNumPrestados() >= u.getLimPrestados() || this.disponible == false){
			return null;
		}
		else{
			ArrayList<Ejemplar> temp = u.getPrestamos();
			for(Ejemplar e: temp ){
				if(this.getObra().equals(e.getObra())){
					return null;
				}
			}
			Prestamo pf = new Prestamo(this, u);
			Prestamo.addPendientes(pf);
			u.anyadirPrestamo(pf);
			this.disponible = false;
			u.addPrestamoToList(this);		//añade prestamo a la lista en usuario
			this.setPrestamo(pf);
			return pf;
		}
		
	}
	/**
	* Realiza la accion de devolver, comprobando si se puede
	* en caso de que si, el ejemplar vuelve a estar disponible
	* y se elimina el prestamo de la lista de prestamos pendientes
	* y se elimina el ejemplar de la lista de prestados de usuario
	* y se modifican los datos del usuario correspondiente.
	* Si el retraso es mayor que 0 (hay retraso), se aplica la sancion correspondiente
	*/
	public void devolver(){
		if(this.disponible == false){
			this.disponible = true;
			Usuario utemp = this.prestamo.getUsuario();
			utemp.eliminarPrestamoDeList(this);
			utemp.eliminarPrestamo(this.prestamo); 		
			Prestamo.eliminarPendiente(this.prestamo);
			
			long numDiasRetraso = Period.between(this.prestamo.getFechaFin(), FechaSimulada.getHoy()).getDays();
			if(numDiasRetraso > 0){
				utemp.sancionarPorRetraso((int) numDiasRetraso);
				
			}
				}

	}
	@Override
	public String toString() {
		if(this.prestamo != null){
			return "" + this.prestamo;
		}
		else{
			return "{" + this.id + this.obra + "(disponible)" + "}";
		}
	}
	
	
	
}
