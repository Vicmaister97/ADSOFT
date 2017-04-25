package clases;
import java.util.ArrayList;
import java.util.Collection;

import interfaces.IMetricSystem;
import interfaces.IMetricSystemConverter;
import interfaces.IPhysicalUnit;


/**
 * Clase para el sistema metrico internacional de tiempo
 * @author Alfonso Carvajal, Victor Garcia
 *
 */
public class SiTimeMetricSystem implements IMetricSystem{
	public static final SiTimeMetricSystem SYSTEM = new SiTimeMetricSystem();
	private static final Quantity q = Quantity.t;
	
	/**
	 * 1 millisecond = 0.001 seconds
	 */
	public static final IPhysicalUnit MILLISECOND = new PhysicalUnit("ms", 0.001, q, SYSTEM);
	/**
	 * 1 second = 1 second
	 */
	public static final IPhysicalUnit SECOND = new PhysicalUnit("s", 1, q, SYSTEM);
	/**
	 * 1 hour = 3600 seconds
	 */
	public static final IPhysicalUnit HOUR = new PhysicalUnit("h", 3600, q, SYSTEM);
	
	private static IMetricSystemConverter normal = null;
	
	/**
	 * Constructor privado
	 */
	private SiTimeMetricSystem(){}
	
	public IPhysicalUnit base(){
		return SECOND;
	}
	
	public Collection<IPhysicalUnit> units(){
		Collection<IPhysicalUnit> units;
		units = new ArrayList<IPhysicalUnit>();	
		units.add(MILLISECOND);
		units.add(SECOND);
		units.add(HOUR);
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