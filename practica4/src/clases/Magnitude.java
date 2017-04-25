package clases;

import interfaces.IMagnitude;
import interfaces.IMetricSystemConverter;
import interfaces.IPhysicalUnit;
import misExcepciones.QuantityException;
import misExcepciones.UnknownUnitException;

/**
 * Clase para las magnitudes
 * @author Alfonso Carvajal, Victor Garcia
 *
 */
public class Magnitude implements IMagnitude{
	private double value;
	private IPhysicalUnit unit;
	
	
	/**
	 * Constructor
	 * @param v valor de la magnitud
	 * @param u unidad de la magnitud
	 */
	public Magnitude(double v, IPhysicalUnit u){
		this.value = v;
		this.unit = u;
	}
	
	public IPhysicalUnit getUnit(){
		return this.unit;
	}
	
	public IMagnitude add(IMagnitude m) throws QuantityException{
		try{
			IMagnitude temp = m.transformTo(this.unit);
			this.value += temp.getValue();
			return this;
		}catch (QuantityException e){
			throw e;
		}
	}
	
	public IMagnitude subs(IMagnitude m) throws QuantityException{
		try{
			IMagnitude temp = m.transformTo(this.unit);
			this.value -= temp.getValue();
			return this;
			
		}catch (QuantityException e){
			throw e;
		}
	}

	public IMagnitude transformTo(IPhysicalUnit c) throws QuantityException{
		
		IMagnitude temp;

		if(this.getUnit().getQuantity().equals(c.getQuantity()) == false ||
				this.getUnit().getMetricSystem().equals(c.getMetricSystem())){	
			try{
				double val = this.unit.transformTo(this.value, c);
				temp = new Magnitude(val, c);
			}catch(QuantityException e){
				throw e;
			}
		}

		else{
			try{
				IMetricSystemConverter conv = this.getUnit().getMetricSystem().getConverter(c.getMetricSystem());
			if(conv == null){
				throw new UnknownUnitException(this.getUnit().toString(), c.toString());
			}
			temp = conv.transformTo(this, c);
			}catch(UnknownUnitException e){
				throw new QuantityException(e.toString());
			}
		}
		return temp;
	}


	public double getValue(){
		return this.value;
	}

	@Override
	public String toString() {
		return this.value + " " + this.unit.toString() ;
	}
	
	
	
	
}
