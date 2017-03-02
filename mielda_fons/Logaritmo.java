/**
* Esta aplicación calcula el logaritmo Neperiano de su primer parámetro. *
* @author Estudiante EPS estudiante.eps@uam.es
*
*/
public class Logaritmo {
  /**
   * Punto de entrada a la aplicación.
   *
* Este método imprime el logaritmo Neperiano del número que se le pasa como entrada *
* @param args Los argumentos de la línea de comando. Se espera un número como primer parámetro */
public static void main(String[] args) {
	if (args.length<1) {
		System.out.println("Se espera un numero como parametro.");
		return;
	}
String arg = args[0]; // una variable String que obtiene el primer parametro
double x = Double.parseDouble(arg); // una variable double, que convierte arg a numerico 
System.out.println("El logaritmo de " + arg + " es: " + Math.log(x));
} }