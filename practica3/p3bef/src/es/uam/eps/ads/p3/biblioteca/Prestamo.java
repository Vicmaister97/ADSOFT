package es.uam.eps.ads.p3.biblioteca;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import es.uam.eps.ads.p3.fechasimulada.*;

public class Prestamo {
	private Ejemplar ejemplar;
	private Usuario usuario;
	private LocalDate fechaFin;
	private boolean status;	//False = inactivo, true = activo
	private static int realizados = 0;
	private static int devueltos = 0;
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
	public int retraso(){
		if(FechaSimulada.getHoy().isAfter(fechaFin)){
			LocalDate hoy = FechaSimulada.getHoy();
			int anios = hoy.getYear() - fechaFin.getYear();
			int dias = fechaFin.getDayOfYear() - hoy.getDayOfYear() ;
			return anios*365 + dias;
		}
		else{
			return 0;
		}
	}
	public LocalDate getFechaFin(){
		return this.fechaFin;
	}
	public boolean devolver(){
		
		this.ejemplar.devolver();
		this.fechaDevolucion = FechaSimulada.getHoy();
		return true;
	}
	
	public static void modDevueltos() {
		Prestamo.devueltos++;
	}
	
	public static int numPrestamosHistoricos(){
		return Prestamo.realizados;
	}
	
	public static int numPrestamosPendientes(){
		return Prestamo.pendientes.size();
	}
	
	
	
	public static ArrayList<Prestamo> getPendientes() {
		return pendientes;
	}
	public static void addPendientes(Prestamo p) {
		Prestamo.pendientes.add(p);
	}
	
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
			return "{" + this.ejemplar.getId() + this.ejemplar.getObra() + "(prestado)" + "}" + " prestado a " + this.usuario + " hasta " + fechaFin + " devuelto " + fechaDevolucion;
		}
		else if(this.ejemplar.getDisponible() == true){
			return "{" + this.ejemplar.getId() + this.ejemplar.getObra() + "(disponible)" + "}";
		}
		else{
			return "{" + this.ejemplar.getId() + this.ejemplar.getObra() + "(prestado)" + "}" + " prestado a " + this.usuario + " hasta " + fechaFin;
		}
	}

	
}
