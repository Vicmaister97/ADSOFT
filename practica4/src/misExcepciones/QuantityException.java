package misExcepciones;

/**
 * Clase para la excepcion por cantidad
 * @author Alfonso Carvajal, Victor Garcia
 *
 */
public class QuantityException extends Exception{
	private static final long serialVersionUID = 1L;
	private String msg;
	
	/**
	 * Constructor
	 * @param message mensaje de la excepcion
	 */
	public QuantityException (String message) {
		msg = message;
	}
	@Override
	public String toString() {
		return msg;
	}
	
	
}
