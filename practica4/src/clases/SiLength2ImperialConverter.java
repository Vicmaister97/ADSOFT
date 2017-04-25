package clases;

import interfaces.*;
import misExcepciones.*;

/**
 * Clase para el conversor entre los sistemas metricos imperial y internacional de longitud
 * @author Alfonso Carvajal, Victor Garcia
 *
 */
public class SiLength2ImperialConverter implements IMetricSystemConverter{
	private IMetricSystem src; 
	private IMetricSystem trg;
	private double relation;
	
	
	/**
	 * Constructor
	 */
	public SiLength2ImperialConverter(){
		this.src = SiLengthMetricSystem.SYSTEM;
		this.trg = ImperialLengthMetricSystem.SYSTEM;
		this.relation = 3.280839895;
	}
	
	
	/**
	 * Constructor privado
	 * @param src el sistema metrico desde el que se convierte
	 * @param trg el sistema metrico al que se convierte
	 */
	private SiLength2ImperialConverter(IMetricSystem src, IMetricSystem trg){
		this.src = src;
		this.trg = trg;
		this.relation = 1/3.280839895;
	}
	
	
	public IMetricSystem sourceSystem(){
		return this.src;
	}
	
	public IMetricSystem targetSystem(){
		return this.trg;
	}
	
	public IMagnitude transformTo(IMagnitude from, IPhysicalUnit to) throws UnknownUnitException{
		try{
			IMagnitude temp = from.transformTo(from.getUnit().getMetricSystem().base());
			double tempVal = temp.getValue()*this.relation;
			IPhysicalUnit tempU = to.getMetricSystem().base();
			IMagnitude ret = new Magnitude(tempVal, tempU);
			return ret.transformTo(to);

			
		}catch(QuantityException e){
			throw new UnknownUnitException(from.getUnit().toString(), to.toString());
		}
	}
	
	public IMetricSystemConverter reverse(){
		return new SiLength2ImperialConverter(trg, src);
	}
}
