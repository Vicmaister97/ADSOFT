package interfaces;

import misExcepciones.*;

/**
 * Interfaz que maneja los metodos para trabajar con magnitudes
 * @author Alfonso Carvajal, Victor Garcia
 *
 */
public interface IMagnitude {
	/**
	 * Suma una magnitud a otra
	 * @param m magnitud que queremos sumar a esta
	 * @return IMagnitude con el resultado de la suma
	 * @throws QuantityException
	 */
	IMagnitude add (IMagnitude m) throws QuantityException;
	/**
	 * Resta una magnitud a otra
	 * @param m magnitud que queremos restar a esta
	 * @return IMagnitude con el resultado de la resta
	 * @throws QuantityException
	 */	
	IMagnitude subs(IMagnitude m) throws QuantityException;
	/**
	 * Transforma la unidad de una magnitud devolviendo la conversion
	 * @param c la unidad a la que queremos convertir
	 * @return la IMagnitude convertida
	 * @throws QuantityException
	 */
	IMagnitude transformTo(IPhysicalUnit c) throws QuantityException;
	/**
	 * Devuelve la unidad de la magnitud
	 * @return la unidad de la magnitud
	 */
	IPhysicalUnit getUnit();
	/**
	 * Devuelve el valor de la magnitud
	 * @return el valor de la magnitud
	 */
	double getValue();
}
