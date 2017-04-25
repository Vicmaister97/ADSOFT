package clases;

import java.util.ArrayList;
import java.util.Collection;

import interfaces.IMetricSystem;
import interfaces.IMetricSystemConverter;
import interfaces.IPhysicalUnit;


/**
 * Clase para el sistema metrico imperial de longitud
 * @author Alfonso Carvajal, Victor Garcia
 *
 */
public class ImperialLengthMetricSystem implements IMetricSystem{
	public static final ImperialLengthMetricSystem SYSTEM = new ImperialLengthMetricSystem();
	private static final Quantity q = Quantity.L;
	
	/**
	 * 1 foot = 1 foot
	 */
	public static final IPhysicalUnit FOOT = new PhysicalUnit("ft", 1, q, SYSTEM);
	/**
	 * 1 yard = 3 feet
	 */
	public static final IPhysicalUnit YARD = new PhysicalUnit("yd", 3, q, SYSTEM);
	/**
	 * 1 mile = 1 5280 feet
	 */
	public static final IPhysicalUnit MILE = new PhysicalUnit("mi", 5280, q, SYSTEM);
	
	private static IMetricSystemConverter normal = null;
	
	/**
	 * Constructor privado
	 */
	private ImperialLengthMetricSystem(){}
	
	
	public IPhysicalUnit base(){
		return FOOT;
	}
	
	public Collection<IPhysicalUnit> units(){
		Collection<IPhysicalUnit> units;
		units = new ArrayList<IPhysicalUnit>();
		units.add(FOOT);
		units.add(YARD);
		units.add(MILE);
		return units;
	}
	
	public IMetricSystemConverter getConverter(IMetricSystem to){
		
		return normal;
	}
	
	/**
	 * Registra un conversor en el sistema metrico
	 * @param conv el conversor que queremos registrar
	 */
	public static void registerConverter(IMetricSystemConverter conv){
		normal = conv;
		
	}
	
}