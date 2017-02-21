/**
* Esta aplicacion imprime el n + 1 filas del triangulo de tartaglia, donde n es el parametro de entrada   *
* @author Estudiante EPS alfonso.carvajal@estudiante.uam.es victor.garciacarrerea@estudiante.uam.es
*
*/
public class tartaglia {
/**
* Punto de entrada a la aplicación.
*
* Este método imprime n + 1 filas del triangulo de tartaglia, con n el numero que se le pasa como entrada
*
* @param args Los argumentos de la línea de comando. Se espera un número como primer parámetro */
public static void main(String[] args) {
if (args.length < 1) {
System.out.println("Se espera un numero como parametro."); return;
}
String arg = args[0]; // una variable String que obtiene el primer parametro
int x = Integer.parseInt(arg); // una variable int, que convierte arg a int 
if (x < 0) {
System.out.println("Se espera un numero positivo."); return;
}
int i = 0, j = 0;
int[][] numeros = new int[x + 1][x + 1];
for(i = 0; i <= x; i++){
	for(j = 0; j <= i; j++){
		if(j == 0 || j == i) numeros[i][j] = 1;
		
		else numeros[i][j] = numeros[i - 1][j] + numeros[i - 1][j - 1];
	}
	for(j = 0; j <= i; j++) System.out.print(numeros[i][j] + " ");

	System.out.print("\n");
	
	}
}
}

