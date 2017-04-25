package interfaces;

import java.util.Collection;

/**
 * Interfaz que contiene los metodos para los sistemas metricos
 * @author Alfonso Carvajal, Victor Garcia
 *
 */
public interface IMetricSystem {
	/**
	 * Devuelve la unidad base del sistema metrico
	 * @return la base
	 */
	IPhysicalUnit base();
	/**
	 * Devuelve las unidades de un sistema metrico
	 * @return las unidades
	 */
	Collection<IPhysicalUnit> units();
	/**
	 * Devuelve el conversor del sistema metrico al otro dado
	 * @param to sistema metrico al que queremos convertir
	 * @return el conversor entre los sistemas
	 */
	IMetricSystemConverter getConverter(IMetricSystem to);
}
