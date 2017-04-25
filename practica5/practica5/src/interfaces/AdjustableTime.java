package interfaces;



/**
 * Interfaz que contiene los metodos para una ObservableProperty de tipo Integer que trabaja
 * con AdjustableTime (enteros)
 * @author Alfonso Carvajal, Victor Garcia
 *
 */
public interface AdjustableTime extends ObservableProperty<Integer>{ 
	/**
	 * Metodo que suma un entero inc al valor de una ObservableProperty<Integer>
	 * comprueba si al sumar inc, que puede ser positivo o negativo, el valor
	 * Integer de la ObservableProperty sea mayor o igual que 0. En caso contrario
	 * se establecerá como 0, ya que no deseamos que se registre un valor negativo.
	 * @param inc, entero que se desea sumar
	 */
	void incrementTime(int inc);
}
