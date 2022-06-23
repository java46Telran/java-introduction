package telran.numbers;

import java.util.Arrays;

public class ArrayInt {
/**
 * 
 * @param ar
 * @param number
 * @return new array with added number
 */
	public static int[] addNumber(int ar[], int number) {
	int res[] = Arrays.copyOf(ar, ar.length + 1);
	res[ar.length] = number;
	return res;
	
}
	/**
	 * 
	 * @param ar
	 * @param index
	 * @param number
	 * @return new array containing number value at the given index
	 */
	public static int[] insertNumber(int ar[], int index, int number) {
		int res[] = new int[ar.length + 1];
		System.arraycopy(ar, 0, res, 0, index);
		res[index] = number;
		System.arraycopy(ar, index, res, index + 1, ar.length - index);
		return res;
	}
	/**
	 * 
	 * @param ar
	 * @param index
	 * @return new array with removed number at the given index
	 */
	public static int[] removeNumber(int ar[], int index) {
		int res[] = new int[ar.length - 1];
		System.arraycopy(ar, 0, res, 0, index);
		System.arraycopy(ar, index + 1, res, index, res.length - index);
		return res;
		
	}
	/**
	 * 
	 * @param ar
	 * @param number
	 * @return if the given number exists in the given array then returns the index of first occurrence,
	 *  otherwise returns -1
	 */
	public static int indexOf(int ar[], int number) {
		int res = -1;
		for(int i = 0; i < ar.length; i++) {
			if (ar[i] == number) {
				res = i;
				break;
			}
		}
		return res;
	}
}
