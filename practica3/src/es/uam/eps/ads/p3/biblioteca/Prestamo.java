package es.uam.eps.ads.p3.biblioteca;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import es.uam.eps.ads.p3.fechasimulada.*;

/**
* En este fichero se encuentra la implementacion de la clase Prestamo
* @author Estudiante EPS alfonso.carvajal@estudiante.uam.es victor.garciacarrerea@estudiante.uam.es
*
*/


public class Prestamo {
	private Ejemplar ejemplar;
	private Usuario usuario;
	private LocalDate fechaFin;
	private boolean status;	//False = inactivo, true = activo
	private static int realizados = 0;
	private static ArrayList<Prestamo> pendientes = new ArrayList<Prestamo>();
	private LocalDate fechaDevolucion;
	
	public Prestamo(Ejemplar ejemplar, Usuario usuario) {
		super();
		this.setEjemplar(ejemplar);
		this.setUsuario(usuario);
		this.fechaFin = FechaSimulada.getHoy().plusDays(this.ejemplar.getObra().plazoPrestamo());
		this.status = false;
		Prestamo.realizados++;
		this.fechaDevolucion = null;
	}
	public Ejemplar getEjemplar() {
		return ejemplar;
	}
	public void setEjemplar(Ejemplar ejemplar) {
		this.ejemplar = ejemplar;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public boolean getStatus(){
		return this.status;
	}
	public void cambiarStatus(){
		this.status = !this.status;
	}
	public LocalDate getFechaFin(){
		return this.fechaFin;
	}
	
	/**
	* Devuelve un prestamo y guarda su fecha de devolucion
	*
	* @return boolean true 
	*/
	public boolean devolver(){
		this.ejemplar.devolver();
		this.fechaDevolucion = FechaSimulada.getHoy();
		return true;
	}
	
	/**
	* Devuelve el numero de prestamos realizados en total
	*
	* @return int, Numero de prestamos realizados
	*/
	public static int numPrestamosHistoricos(){
		return Prestamo.realizados;
	}
	
	/**
	* Devuelve el numero de prestamos pendientes por devolver
	*
	* @return int, Numero de prestamos pendientes
	*/
	public static int numPrestamosPendientes(){
		return Prestamo.pendientes.size();
	}
	
	/**
	* Devuelve el la lista de prestamos pendientes
	*
	* @return ArrayList<Prestamo> pendientes
	*/
	public static ArrayList<Prestamo> getPendientes() {
		return pendientes;
	}
	
	/**
	* Añade un prestamo a la lista de pendientes por devolver
	*
	* @param p Prestamo que se desea añadir
	*
	*/
	public static void addPendientes(Prestamo p) {
		Prestamo.pendientes.add(p);
	}
	
	/**
	* Elimina un prestamo de la lista de pendientes por devolver
	*
	* @param p Prestamo que se desea eliminar
	*
	*/
	public static void eliminarPendiente(Prestamo elim){
		int indice = 0;
		for(Prestamo p: Prestamo.pendientes){
			if(p.equals(elim)){
				break;
			}
			indice++;
		}
		Prestamo.pendientes.remove(indice);
	}
	
	/**
	* Comprueba todos los prestamos que vencen hoy y los devuelve en una lista
	*
	*
	* @return ArrayList<Prestamo> Prestamos pendientes que caducan hoy
	*/
	public static ArrayList<Prestamo> conVencimientoHoy(){
		ArrayList<Prestamo> hoy = new ArrayList<Prestamo>();
		for(Prestamo p: Prestamo.pendientes){
			long dias = Period.between(p.getFechaFin(), FechaSimulada.getHoy()).getDays();
			if(dias == 0){
				hoy.add(p);
			}
		}
		return hoy;
	}
	
	/**
	* Comprueba todos los prestamos que han vencido y los devuelve en una lista
	*
	*
	* @return ArrayList<Prestamo> Prestamos que han vencido
	*/
	public static ArrayList<Prestamo> pasadosDeVencimiento(){
		ArrayList<Prestamo> pasados = new ArrayList<Prestamo>();
		for(Prestamo p: Prestamo.pendientes){
			long dias = Period.between(p.getFechaFin(), FechaSimulada.getHoy()).getDays();
			if(dias > 0){
				pasados.add(p);
			}
		}
		return pasados;
	}
	
	@Override
	public String toString() {
		if(this.fechaDevolucion != null){
			return "{" + this.ejemplar.getId() + this.ejemplar.getObra() + "(disponible)" + "}" + " prestado a " + this.usuario + " hasta " + fechaFin + " devuelto " + fechaDevolucion;
		}
		else if(this.ejemplar.getDisponible() == true){
			return "{" + this.ejemplar.getId() + this.ejemplar.getObra() + "(disponible)" + "}";
		}
		else{
			return "{" + this.ejemplar.getId() + this.ejemplar.getObra() + "(prestado)" + "}" + " prestado a " + this.usuario + " hasta " + fechaFin;
		}
	}

	
}
