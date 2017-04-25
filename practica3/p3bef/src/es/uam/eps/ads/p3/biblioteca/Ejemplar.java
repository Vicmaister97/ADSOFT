package es.uam.eps.ads.p3.biblioteca;

import static es.uam.eps.ads.p3.tester.DatosPruebas.u4;

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
			//this.user = u;				//con esto se puede modificar usuario pero bueno...
			this.setPrestamo(pf);
			return pf;
		}
		
	}
	
	public void devolver(){
		if(this.disponible == false){
			this.disponible = true;
			Usuario utemp = this.prestamo.getUsuario();
			utemp.eliminarPrestamoDeList(this);
			utemp.eliminarPrestamo(this.prestamo); 		//ya se encarga de los nums
			Prestamo.modDevueltos();
			Prestamo.eliminarPendiente(this.prestamo);
			
			long numDiasRetraso = Period.between(this.prestamo.getFechaFin(), FechaSimulada.getHoy()).getDays();
			if(numDiasRetraso > 0){
				utemp.sancionarPorRetraso((int) numDiasRetraso);
				
			}
			  //u4.sancionarPorRetraso(10);
				}

	}
	@Override
	public String toString() {
		return "" + this.prestamo;
	}
	
	
	
}
