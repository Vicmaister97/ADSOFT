package interfaces;

import misExcepciones.UnknownUnitException;

/**
 * Interfaz que contiene los metodos para los conversores entre sistemas metricos
 * @author Alfonso Carvajal, Victor Garcia
 *
 */
public interface IMetricSystemConverter { 
	/**
	 * Devuelve el sistema metrico desde el que queremos convertir
	 * @return el sistema metrico desde el que queremos convertir
	 */
	IMetricSystem sourceSystem(); 
	/**
	 * Devuelve el sistema metrico al que queremos convertir
	 * @return el sistema metrico al que queremos convertir
	 */
	IMetricSystem targetSystem();
	/**
	 * Transforma una magnitud en una unidad a otra unidad dada
	 * @param from magnitud que queremos transformar
	 * @param to unidad a la que queremos transformar la magnitud
	 * @return la magnitud convertida
	 * @throws UnknownUnitException
	 */
	IMagnitude transformTo(IMagnitude from, IPhysicalUnit to) throws UnknownUnitException; 
	/**
	 * Devuelve el conversor inverso 
	 * @return el conversor inverso
	 */
	IMetricSystemConverter reverse();
}
