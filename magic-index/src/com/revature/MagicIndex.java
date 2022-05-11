package com.revature;

import java.util.Arrays;

public class MagicIndex {

	public static void main(String[] args) {
		int[] sortedIntArray = { -60, -58, -57, -52, -45, -41, -40, -35, -28, -15, -11, -8, -1, 3, 7, 12, 16, 43, 57, 62 };
		System.out.println("Sorted array; " + Arrays.toString(sortedIntArray));
		System.out.println("Magical index: " + findMagicIndex(sortedIntArray));
	}

	public static int findMagicIndex(int[] arr) {
		int index = -999;
		int length = arr.length;
		int left = 0;
		int right = arr.length - 1;
		int mid = arr.length - (arr.length / 2);

		int counter = 0;

		while (mid != arr[mid] && counter < arr.length) {
			if (arr[mid] > mid) {
				right = mid - 1;
				mid = right - ((right-left) / 2);
			} else {
				left = mid + 1;
				mid = right - ((right - left) / 2);
			}
			counter++;
		}

		if (mid != arr[mid]) {
			index = -999;
		} else {
			index = mid;
		}

		return index;
	}

}
