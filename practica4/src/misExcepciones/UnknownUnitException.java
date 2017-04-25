package misExcepciones;

/**
 * Clase para la excepcion por unidad desconocida
 * @author Alfonso Carvajal, Victor Garcia
 *
 */
public class UnknownUnitException extends Exception {

	private static final long serialVersionUID = 1L;

	private String part1;
	private String part2;
	
	/**
	 * Constructor 
	 * @param p1 abreviatura y cantidad de la primera unidad
	 * @param p2 abreviatura y cantidad de la segunda unidad
	 */
	public UnknownUnitException (String p1, String p2) {
		this.part1 = p1;
		this.part2 = p2;
	}
	@Override
	public String toString() {
		return "Cannot transform " + part1 + " to " + part2;
	}
}
