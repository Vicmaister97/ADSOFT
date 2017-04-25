package interfaces;


/**
 * Interfaz que contiene los metodos para una ObservableProperty generico
 * @author Alfonso Carvajal, Victor Garcia
 *
 * @param <V>, tipo de dato sobre con el que trabajeremos
 */
public interface ObservableProperty<V> {
    /**
     * Devuelve el valor del ObservableProperty
     * @return valor del ObservableProperty
     */
    V getValue();
    /**
     * Suma un observador a la ObservableProperty
     * @param o, el PropertyObserver que se quiere sumar como observador
     */
    void addObserver(PropertyObserver<V> o);
    /**
     * Elimina un observador de la ObservableProperty
     * @param o, el PropertyObserver que se quiere eliminar
     */
    void removeObserver(PropertyObserver<V> o);
}
