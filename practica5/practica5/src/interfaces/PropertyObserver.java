package interfaces;

/**
 * Interfaz que contiene los metodos para un PropertyObserver generico
 * @author Alfonso Carvajal, Victor Garcia
 *
 * @param <V>, tipo de dato sobre con el que trabajeremos
 */
public interface PropertyObserver<V> {
	
    /**
     * metodo que alerta a un PropertyObserver de un cambio en  una ObservableProperty
     * y realiza las operaciones necesarias en cada caso
     * @param property, ObservableProperty que ha cambiado
     * @param oldValue, Valor antiguo de la ObservableProperty que ha cambiado
     */
    void propertyChanged(ObservableProperty<V> property, V oldValue);
}
