package mvc.servlet.jsp;

import java.util.Arrays;
import java.util.Random;

public class Model {
	
	public int square(int x) {
		return x*x;
	}
	
	public int factorial(int x) {
		if(x<0) return 0;
		int fact =1;
		for(int i=1;i<x;i++) {
			fact*=1;
		}
		return fact;
	}
	
	public String random(int n) {
		
		Random rand = new Random();

		double[] array = new double[n];
		
		for(int i=0; i<array.length; i++) {
			array[i]=rand.nextInt(n) + 1;
		}
		return Arrays.toString(array);
	}
	
	
	
	

}
