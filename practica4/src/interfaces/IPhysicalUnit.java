package interfaces;
import clases.Quantity;
import misExcepciones.*;

/**
 * Interfaz con los metodos para las unidades de los sistemas metricos
 * @author Alfonso Carvajal, Victor Garcia
 * 
 *
 */
public interface IPhysicalUnit {
	/**
	 * Indica si se puede transformar de una unidad a otra
	 * @param u, el IPhysicalUnit al que queremos transformar
	 * @return true, si se puede convertir al IPhysicalUnit u
	 * false, si no
	 */
	boolean canTransformTo(IPhysicalUnit u);
	/**
	 * Devuelve el valor de una cantidad de una unidad en otra unidad
	 * @param d, valor/cantidad de la unidad que queremos transformar
	 * @param u, Unidad al que queremos transformar
	 * @return valor nuevo de la unidad que hemos transformado
	 * @throws QuantityException
	 */
	double transformTo(double d, IPhysicalUnit u) throws QuantityException;
	/**
	 * Devuelve la Quantity de la unidad
	 * @return la cantidad que esta midiendo esta unidad
	 */
	Quantity getQuantity();
	/**
	 * Devuelve la abreviatura de la unidad
	 * @return la abreviatura de la unidad
	 */
	String abbrev();
	/**
	 * Devuelve el sistema metrico (MetricSystem) de la unidad
	 * @return IMetricSystem de la unidad
	 */
	IMetricSystem getMetricSystem();
}
