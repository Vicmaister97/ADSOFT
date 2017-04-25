package clases;


import interfaces.AdjustableTime;
import interfaces.ObservableProperty;
import interfaces.PropertyObserver;

/**
 * Subclase de DefaultObservableProperty<Integer> que implementa 
 * AdjustableTime para facilitar el trabajo con Integers y,
 * PropertyObserver<Integer> porque una ObservableProperty puede ser
 * a su vez un PropertyObserver.
 * @author Alfonso Carvajal, Victor Garcia
 *
 */
public class ObservablePropertyInteger extends DefaultObservableProperty<Integer> implements AdjustableTime, PropertyObserver<Integer> {

	/**
	 * Constructor
	 * @param value, valor entero con el que inicializaremos esa propiedad
	 */
	public ObservablePropertyInteger(int value){
		this.setValue(value);
		
	}
	public void incrementTime(int inc){
		int temp = this.getValue();
		if(temp + inc > 0){
			super.setValue(temp + inc);			//sumamos valor actual con temp si no da < 0 en caso de reajuste negativo
		}
		else{
			super.setValue(0);					//si no, es 0
		}
	}
	
	/**
	 * Metodo mediante el cual un observador indica que quiere observar a una
	 * ObservableProperty<Integer>.
	 * Se suma el valor valor entero de la ObservableProperty al observador
	 * y se suma el observador a la lista de observadores que contiene la ObservableProperty
	 * @param observable, la propiedad que se quiere observar
	 */
	public void addObservableProperty(ObservableProperty<Integer> observable){
		int temp = observable.getValue();
		this.incrementTime(temp);
		observable.addObserver(this);
	}
	
	/**
	 * Metodo mediante el cual un observador indica que quiere dejar de observar a una
	 * ObservableProperty<Integer>.
	 * Se resta el valor valor entero de la ObservableProperty al observador
	 * y se elimina al observador de la lista de observadores que contiene la ObservableProperty
	 * @param observable, la propiedad que se quiere dejar de observar
	 */
	public void removeObservableProperty(ObservableProperty<Integer> observable){
		int temp = observable.getValue();
		this.incrementTime(-1 * temp);
		observable.removeObserver(this);
	}
	
	public void propertyChanged(ObservableProperty<Integer> property, Integer oldValue){
		int temp = property.getValue() - oldValue;
		this.incrementTime(temp);
	}
	@Override
	public String toString() {
		return super.toString();
	}

	
	
}