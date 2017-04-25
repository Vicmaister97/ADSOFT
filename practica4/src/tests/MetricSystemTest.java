package tests;

import clases.ImperialLengthMetricSystem;
import clases.SiLengthMetricSystem;
//import clases.SiTimeMetricSystem;
import interfaces.IMetricSystem;

public class MetricSystemTest {
	public static void main(String[] args) {
		IMetricSystem ms = SiLengthMetricSystem.SYSTEM;
		//new SiLengthMetricSystem(); // compilation error 
		System.out.println(ms.units()); 
		System.out.println("Base = "+ms.base());
		System.out.println(SiLengthMetricSystem.METER.canTransformTo(ImperialLengthMetricSystem.FOOT));
		// No: different metric systems

		}
	
}
