package es.uam.eps.ads.p3.biblioteca;

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
	
	public void actualizarPpb(){
		this.ppb++;
		if(this.ppb > this.getLimPrestados()){
			this.setLimPrestados(this.getLimPrestados() + 1);
			this.ppb = 1;
		}
	}
	public void anyadirPrestamo(Prestamo p){
			super.addNumPrestados();
			this.actualizarPpb();
			p.cambiarStatus();
			p.getEjemplar().getObra().actualizarContador();
	}
	
	public void reduceLimPrestados(int n){	   
		this.ppb -= n;
		if(this.ppb < 0){
			this.ppb = 0;
		}
		this.setLimPrestados(2);
	}
	
	public void eliminarPrestamo(Prestamo p){
		//if(p.getUsuario().equals(this) && p.getStatus()){
			this.setNumPrestados(this.getNumPrestados() - 1);
			p.cambiarStatus();
		//}
		//else System.out.println("No tiene esta obra");
	} 
	
	public void sancionarPorRetraso(int dias){
		reduceLimPrestados(dias);
	}
	
	public String toString() {
		return "[P: " + super.getNombre() + ",ppb:" + this.ppb + ",ps:" + super.getLimPrestados()
				+ "]";
	}


}
