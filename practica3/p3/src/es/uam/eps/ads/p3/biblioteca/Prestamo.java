package es.uam.eps.ads.p3.biblioteca;

public class Prestamo {
	private Ejemplar ejemplar;
	private Usuario usuario;
	public Prestamo(Ejemplar ejemplar, Usuario usuario) {
		super();
		this.setEjemplar(ejemplar);
		this.setUsuario(usuario);
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
	
}
