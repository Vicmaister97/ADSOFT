package clases;
import interfaces.*;
import misExcepciones.QuantityException;

/**
 * Clase para las unidades fisicas el sistema metrico
 * @author Alfonso Carvajal, Victor Garcia
 *
 */
public class PhysicalUnit implements IPhysicalUnit{
	private String abbr;
	private double relation;
	private Quantity quantity;
	private IMetricSystem ms;

	/**
	 * Constructor
	 * @param abbr abreviatura de la unidad
	 * @param relation relacion de la unidad con la unidad base
	 * @param q Quantity
	 * @param system el sistema metrico de la unidad
	 */
	public PhysicalUnit(String abbr, double relation, Quantity q, IMetricSystem system) {
		this.abbr = abbr;
		this.relation = relation;
		this.quantity = q;
		this.ms = system;
	}

	
	public double getRel(){
		return this.relation;
	}
	
	public boolean canTransformTo(IPhysicalUnit u){
		return this.quantity.equals(u.getQuantity()) && this.ms.equals(u.getMetricSystem());
	}
	
	
	public Quantity getQuantity(){			
		return this.quantity;
	}
	
	public String abbrev(){					
		return this.abbr;
	}
	
	public double transformTo(double d, IPhysicalUnit u) throws QuantityException{
		if(this.canTransformTo(u) == true){
			return (d * this.relation)/((PhysicalUnit) u).getRel();
		}
		else{
			throw new QuantityException("Quantities " + u.getQuantity().toString() + " and " + this.getQuantity().toString() + " are not compatible");
		}
	}

	public IMetricSystem getMetricSystem(){
		return this.ms;
	}
	
	@Override
	public String toString() {
		return abbrev() + " " + quantity;
	}
	
	
}


