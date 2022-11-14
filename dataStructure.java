package homework;

import java.util.HashMap;
import java.util.Map;

public class dataStructure {
	public static void main(String[] args) {
		int chocBar = theFeast(10, 2, 2);
		System.out.println("Total Choc Bar is: " + chocBar);
		int[] arr = { 7, 1, 3, 4, 1, 7, 7 };

		int b = minimumGap(arr);
		int c = minGap(arr);
		System.out.println("Min Gap of Array is: " + c);

	}
	
		
	}
	int min= 0;
	
	return min;
	
	
	}

	public static int theFeast(int n, int c, int m) {
		int chocBar = n / c;
		int num = chocBar;
		while (num >= m) {
			chocBar = chocBar + num / m;
			num = num / m + num % m;
		}

		return chocBar;

	}

	public static int minimumGap(int[] arr) {
		int min = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (arr[i] == arr[j] && (j - i) <= min && j > i) {
					min = j - i;
				}

			}
		}
		return min;
	}

	public static int minGap(int[] arr) {

		int[] arrSortByNumber = new int[maxValue(arr) + 1];// tao mot array moi tu 0 toi gia tri cao nhat cua day
		int[] minGapByNumber = new int[maxValue(arr) + 1];// tao mot array chua bien khoang cach

		for (int i = 0; i < minGapByNumber.length; i++) { // cho gia tri cua day la max gap (array.length-1)
			minGapByNumber[i] = arr.length - 1;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arrSortByNumber[arr[i]] != 0) {
				minGapByNumber[arr[i]] = Math.min(minGapByNumber[arr[i]], i + 1 - arrSortByNumber[arr[i]]);
			}
			arrSortByNumber[arr[i]] = i + 1;// bat dau chay tu 1 den het day
		}
		return minValueExcept0(minGapByNumber);

	}

	public static int maxValue(int[] array) {
		int max = array[0];

		for (int i : array) {
			if (max < i) {
				max = i;
			}
		}
		return max;

	}

	public static int minValueExcept0(int[] array) {
		int min = maxValue(array);

		for (int i : array) {
			if (i > 0 && min > i) {
				min = i;
			}
		}
		return min;

	}

}
