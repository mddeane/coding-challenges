package com.revature;

import java.util.ArrayList;
import java.util.Arrays;

public class MagicIndex2 {

	public static void main(String[] args) {
		int[] sortedIntArray = { -60, -58, -57, -52, -45, -41, -40, -35, -28, -15, -11, -8, -1, 3, 14, 15, 16, 43, 57, 62 };
		System.out.println("Sorted array; " + Arrays.toString(sortedIntArray));
		System.out.println("Magical index: " + findMagicIndex2(sortedIntArray));
	}

	public static ArrayList<Integer> findMagicIndex2(int[] arr) {
		int index = 0;
		int length = arr.length;
		ArrayList<Integer> result = new ArrayList<Integer>();

		while (arr[index] <= index && index < arr.length) {
			if(index == arr[index]) {
				result.add(index);
			}
			index++;
		}


		return result;
	}

}
