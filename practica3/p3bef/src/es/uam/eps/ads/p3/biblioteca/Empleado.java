package es.uam.eps.ads.p3.biblioteca;

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
	
	public void anyadirPrestamo(Prestamo p){
		if(this.getNumPrestados() < this.getLimPrestados()){
			this.setNumPrestados(this.getNumPrestados() + 1);
			p.cambiarStatus();
		}
		else System.out.println("Ha superado el numero maximo de prestamos");	
	}
	
	public void sancionarPorRetraso(int dias){
		if(dias > 4){
			this.sancion = this.sancion + 2.5*dias;
		}
	}
	public void eliminarSancion(){
		if(this.sancion <= 0){
			System.out.println("No tiene sancion");
		}
		else this.sancion = 0.0;
	}
	
	public void eliminarPrestamo(Prestamo p){
		if(p.getUsuario().equals(this) && p.getStatus()){
			if(p.retraso() > 0){	//tiene retraso
				this.eliminarSancion();
			}
			this.setNumPrestados(this.getNumPrestados() - 1);
			p.cambiarStatus();
		}
		else System.out.println("No tiene esta obra");
	}
	public String toString() {
		if(this.sancion <= 0){
			return "[E: " + this.getNombre() + "]";
		}
		else return "[E: " + this.getNombre() + " $" + this.sancion + "]";
	}
	
}
