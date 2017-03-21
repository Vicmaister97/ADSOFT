
public class Empleado extends Usuario{
	private int prestamos_simultaneos;
	private double sancion;
	public Empleado(String nombre) {
		super(nombre);
		this.setPrestamos_simultaneos(20);
	}
	public int getPrestamos_simultaneos() {
		return prestamos_simultaneos;
	}
	public void setPrestamos_simultaneos(int prestamos_simultaneos) {
		this.prestamos_simultaneos = prestamos_simultaneos;
	}
	public double getSancion() {
		return sancion;
	}
	public void setSancion(double sancion) {
		this.sancion = sancion;
	}
	
}
