package clases;

import java.util.ArrayList;
import java.util.Collection;

import interfaces.ObservableProperty;
import interfaces.PropertyObserver;

/**
 * Clase abstracta para un tipo generico de ObservableProperty
 * @author Alfonso Carvajal, Victor Garcia
 *
 * @param <V>, tipo de dato sobre con el que trabajeremos
 */
public abstract class DefaultObservableProperty<V> implements ObservableProperty<V>{
	
	private Collection<PropertyObserver<V>> observers;
	private V value;
	
	/**
	 * metodo para cambiar el valor de la ObservableProperty
	 * si es null, se inicializa directamente
	 * alerta a todos los observers de la ObservableProperty, si no tiene, no alertara a nadie
	 * @param newValue, el valor nuevo de la ObservableProperty
	 */
	protected void setValue(V newValue){	//si ha cambiado notifica a los observers (hacer un set value?)
		if(this.value == null || this.value.equals(newValue) == false){
			V temp = this.value;
			this.value = newValue;
			//this.observers = PropertyObserver<int> o -> { propertyChanged(this, this.value); };
			//filter()
			if(observers != null){
				for(PropertyObserver<V> o: observers){
					o.propertyChanged(this, temp);
				}
			}
		}
	}
	
	public V getValue(){
		return this.value;
	}
	
	public void addObserver(PropertyObserver<V> o){
		if(this.observers == null){
			this.observers = new ArrayList<PropertyObserver<V>>();	
		}
		this.observers.add(o);
	}
	
    public void removeObserver(PropertyObserver<V> o){
    	if(this.observers != null || this.observers.contains(o) == false){
    		this.observers.remove(o);
    	}
    }

	@Override
	public String toString() {
		return /*"[observers=" + observers + */"value: " + value;
	}
    
    
}
