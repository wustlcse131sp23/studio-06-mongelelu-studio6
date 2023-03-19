package studio6;

import java.lang.reflect.Array;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		
			// FIXME compute the geometric sum for the first n terms recursively
			if(n == 0) { 
				return 0; 
			}
			else {
				return Math.pow(0.5, n) + geometricSum(n-1); //return statement will be the same
			}
	}
	//public static void main(String[] args){
		//geomtericSum(4); ... use step over in debugger to see how this code works

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		
			// FIXME compute the gcd of p and q using recursion
			if((p % q) == 0) {
				return q;	
			}
			else {
				int temp = q;
				q = p % q;
				p = temp;
				return gcd(p, q);
			}
	}
			/* professor example
			 *  if(q == 0){			look at what the variables become at
			 *  	return p ;		the end to see what to put in return
			 *  }
			 *  else {
			 *  	return gcd(q, p % q)
			 */
	

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
		
			// FIXME create a helper method that can recursively reverse the given array
		int[] reversed = new int[array.length];
		return helper(reversed, 0, array);
	}
	public static int[] helper(int[] reversed, int index, int[] array) {
		if(index > (reversed.length / 2)) {
			return reversed;
		}
		else if(array.length == 0) {
			return new int[0];
		}
		else {
			int lastIndex = reversed.length - 1;
			int mirrorIndex = lastIndex - index;
			reversed[index] = array[mirrorIndex];
			reversed[mirrorIndex] = array[index];
			return helper(reversed, index + 1, array);
		}
	}
	/* professor example
	 * public static int[] toReversed(int[] array) {
	 * 	int[] result = new int[array.length];
	 * 	if(array.length == 0) {
	 * 	return result;
	 * }
	 * else {
	 * 	return helper(array, 0);
	 * }
	 * }
	 * 
	 *  public static int[] helper(int[] array, int index, int[] result){
	 *  if(index > array.length / 2) {
	 *   return result;
	 *   }
	 *   else {
	 *   result[index] = array[array.length = index - 1];
	 *   result[array.length - index - 1] = array[index];
	 *   return helper(array, result, index + 1);
	 *   }
	 *  }
	 */
	
	
	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius,
			double radiusMinimumDrawingThreshold) {
		
		if( radius > radiusMinimumDrawingThreshold) {
			StdDraw.circle(xCenter, yCenter, radius);
			circlesUponCircles(xCenter + radius, yCenter, radius / 3.0, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter - radius, yCenter, radius / 3.0, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter, yCenter + radius, radius / 3.0, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter, yCenter - radius, radius / 3.0, radiusMinimumDrawingThreshold);
		}
		
	}

}
