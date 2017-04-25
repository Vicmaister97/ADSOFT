package tests;


//import clases.DefaultObservableProperty;
import clases.ObservablePropertyInteger;
import interfaces.ObservableProperty;

public class Apartado1 {
	public static void main(String[] args){
		int ini = 10;
		ObservableProperty<Integer> prop1 = new ObservablePropertyInteger(ini);
		ObservableProperty<Integer> prop2 = new ObservablePropertyInteger(ini);
		ObservableProperty<Integer> prop3 = new ObservablePropertyInteger(ini);
		ObservableProperty<Integer> prop4 = new ObservablePropertyInteger(ini);
		/**todas a 10 */
		System.out.println("Deberia ser: Todas a 10");

		System.out.println("Prop1: " + prop1 + "\nProp2: " + prop2 + "\nProp3: " + prop3 + "\nProp4: " + prop4);
		
		/*ADD observadores*/
		((ObservablePropertyInteger) prop1).addObservableProperty(prop2);
		/*prop1 = 20, resto 10 */
		System.out.println("\nDeberia ser: prop1 = 20, resto 10");
		System.out.println("Prop1: " + prop1 + "\nProp2: " + prop2 + "\nProp3: " + prop3 + "\nProp4: " + prop4);

		
		((ObservablePropertyInteger) prop1).addObservableProperty(prop3);
		/*prop1 = 30, resto 10*/
		System.out.println("\nDeberia ser: prop1 = 30, resto 10");
		System.out.println("Prop1: " + prop1 + "\nProp2: " + prop2 + "\nProp3: " + prop3 + "\nProp4: " + prop4);

		
		((ObservablePropertyInteger) prop2).addObservableProperty(prop4);
		/*prop1 = 40, prop2 = 20 resto 10*/
		System.out.println("\nDeberia ser: prop1 = 40, prop2 = 20 resto 10");
		System.out.println("Prop1: " + prop1 + "\nProp2: " + prop2 + "\nProp3: " + prop3 + "\nProp4: " + prop4);


		((ObservablePropertyInteger) prop4).incrementTime(2);
		/*prop1 = 42, prop2 = 22, prop3 = 10, prop4 = 12*/
		System.out.println("\nDeberia ser: prop1 = 42, prop2 = 22, prop3 = 10, prop4 = 12");
		System.out.println("Prop1: " + prop1 + "\nProp2: " + prop2 + "\nProp3: " + prop3 + "\nProp4: " + prop4);

		
		((ObservablePropertyInteger) prop4).incrementTime(-2);
		/*prop1 = 40, prop2 = 20 resto 10*/
		System.out.println("\nDeberia ser: prop1 = 40, prop2 = 20 resto 10");
		System.out.println("Prop1: " + prop1 + "\nProp2: " + prop2 + "\nProp3: " + prop3 + "\nProp4: " + prop4);

		
		((ObservablePropertyInteger) prop4).incrementTime(-30);
		/*prop1 = 30, prop2 = 10 prop3 = 10 prop4 = 0*/
		System.out.println("\nDeberia ser: prop1 = 30, prop2 = 10 prop3 = 10 prop4 = 0");
		System.out.println("Prop1: " + prop1 + "\nProp2: " + prop2 + "\nProp3: " + prop3 + "\nProp4: " + prop4);

		
		((ObservablePropertyInteger) prop1).removeObservableProperty(prop2);
		/*prop1 = 20, prop2 = 10 prop3 = 10 prop4 = 0*/
		System.out.println("\nDeberia ser: prop1 = 20, prop2 = 10 prop3 = 10 prop4 = 0");
		System.out.println("Prop1: " + prop1 + "\nProp2: " + prop2 + "\nProp3: " + prop3 + "\nProp4: " + prop4);

		
		((ObservablePropertyInteger) prop4).incrementTime(3);
		/*prop1 = 20, prop2 = 13, prop3 = 10, prop4 = 3*/
		System.out.println("\nDeberia ser: prop1 = 20, prop2 = 13, prop3 = 10, prop4 = 3");
		System.out.println("Prop1: " + prop1 + "\nProp2: " + prop2 + "\nProp3: " + prop3 + "\nProp4: " + prop4);

		
		
		
		
	}
}
