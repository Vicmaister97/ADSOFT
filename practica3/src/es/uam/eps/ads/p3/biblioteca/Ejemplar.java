package es.uam.eps.ads.p3.biblioteca;

public class Ejemplar { //No tengo muy claro como hacer este
	private Obra obra;
	private int plazo;
	public Ejemplar(Obra obra) {
		super();
		this.setObra(obra);
	}
	public Obra getObra() {
		return obra;
	}
	public void setObra(Obra obra) {
		this.obra = obra;
	}
	public int getPlazo() {
		return plazo;
	}
	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}
}
