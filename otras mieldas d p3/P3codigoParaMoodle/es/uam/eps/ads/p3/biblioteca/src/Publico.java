
public class Publico extends Usuario{
	public Publico(String nombre) {
		super(nombre);
	}
	private int lim_simultaneos;
	private int contador_prestados;
	public int getLim_simultaneos() {
		return lim_simultaneos;
	}
	public void setLim_simultaneos(int lim_simultaneos) {
		this.lim_simultaneos = lim_simultaneos;
	}
	public int getContador_prestados() {
		return contador_prestados;
	}
	public void setContador_prestados(int contador_prestados) {
		this.contador_prestados = contador_prestados;
	}
}
