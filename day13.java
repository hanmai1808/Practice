package homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class day13 {
	public static void main(String[] args) {
		int[] arr = { 7, 1, 3, 4, 1, 7, 7 ,1,3,4};

		int minGap = minGapByMap(arr);
		System.out.println("Min Gap of Array is: " + minGap);
		int numberOfSquares = square(17,24);
		System.out.println(numberOfSquares);
		System.out.print("Odd Times Appear Num is ");
		findOddTimesAppearNum(arr);
		
	}
	private static void findOddTimesAppearNum(int[] arr) {
	Map<Integer, Integer> arrByNumber=new HashMap<Integer, Integer>();
	for (int i = 0; i < arr.length; i++) {
		Integer check=arrByNumber.putIfAbsent(arr[i], 1);
		if (check==null) continue;
		arrByNumber.put(arr[i],arrByNumber.get(arr[i])+1);
		
	}
	Set<Integer> keys=arrByNumber.keySet();
	for (Integer key: keys) {
		if(arrByNumber.get(key)%2==1) {
			System.out.print(key+",");
		}
			
	}
	
	}
	public static int square(int i, int j) {
		int count=0;
		for (int a=i; a<=j;a++) {
			
			int result=(int) Math.sqrt(a);
			if(result*result==a)count++;
		}
		return count;
	}
	public static int minGapByMap(int[] arr) {
		Map<Integer, Integer> mapByArr=new HashMap<Integer, Integer>();// create an array with the key and position;
		int min=-1;
		//return -1 later if nothing exist
		for (int i = 0; i < arr.length; i++) {
			Integer check=mapByArr.putIfAbsent(arr[i], i);
			//input the key value if not exist, using toll to check if it happened or not. Return the value i
			if (check==null) continue;
			//check if value is exist or not, if not exist then continue the loop (ignore all next step for the current loop)
			int newMin= i-mapByArr.get(arr[i]);
			//value already there, take the gap
			if (min==-1) {
				min=newMin;
				//update new min when duplicate value found.
			} else min=Math.min(min, newMin); //take the small value of min
			mapByArr.put(arr[i],i);//update the value with new position
		}
		return min;
	}
	
}

