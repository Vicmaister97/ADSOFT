package clases;

import java.util.ArrayList;
import java.util.Collection;

import interfaces.IMetricSystem;
import interfaces.IMetricSystemConverter;
import interfaces.IPhysicalUnit;

/**
 * Clase para el sistema metrico internacional de longitud
 * @author Alfonso Carvajal, Victor Garcia
 *
 */
public class SiLengthMetricSystem implements IMetricSystem{
	public static final SiLengthMetricSystem SYSTEM = new SiLengthMetricSystem();
	private static final Quantity q = Quantity.L;
	
	/**
	 * 1 millimeter = 0.001 meters
	 */
	public static final IPhysicalUnit MILLIMETER = new PhysicalUnit("mm", 0.001, q, SYSTEM);
	/**
	 * 1 meter = 1 meters
	 */
	public static final IPhysicalUnit METER = new PhysicalUnit("m", 1, q, SYSTEM);
	/**
	 * 1 kilometer = 1000 meters
	 */
	public static final IPhysicalUnit KILOMETER = new PhysicalUnit("km", 1000, q, SYSTEM);

	private static IMetricSystemConverter normal = null;
	
	
	
	/**
	 * Constructor privado
	 */
	private SiLengthMetricSystem(){}
	
	public IPhysicalUnit base(){
		return METER;
	}
	
	public Collection<IPhysicalUnit> units(){
		Collection<IPhysicalUnit> units;
		units = new ArrayList<IPhysicalUnit>();
		units.add(MILLIMETER);
		units.add(METER);
		units.add(KILOMETER);
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
		ImperialLengthMetricSystem.registerConverter(conv.reverse());
		
		
		
	}
}