package com.revature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {

	public static void main(String[] args) {
	    int[] inputArr = {5,10,15,20,25};

	    int totalCombinations = showCombinations(inputArr); // calculate possible combinations
	    List<List<Integer>> arrayOfbytes = getByteArrays(inputArr);  // create byte arrays to map combinations
	    List<List<Integer>> combinations = mapCombinations(inputArr, arrayOfbytes); // map combinations to the byte string of the index: 1=include, 0=don't include

	    // print input array
	    System.out.println("Input array: "  + Arrays.toString(inputArr));

	    // print number of possible combinations
	    System.out.println("Total combinations: " + totalCombinations);

	    /** For testing
	    for(int i = 0; i<totalCombinations; i++) {
	      System.out.println(arrayOfbytes.get(i));
	    }
	    **/

	    // print all combinations
	    for(int i = 0; i<totalCombinations; i++) {
	      System.out.println(combinations.get(i));
	    }
	  }

		public static int showCombinations(int[] intArr) {
		    int result = 0;
		    int length = intArr.length;
		
		    for(int i=0; i<length; i++) {
		      int n = length;
		      int r = length - i;
		      int combo = getFactorial(n) / (getFactorial(n - r) * getFactorial(r));
		      result = result + combo;
		    } 
		  return result;   
		}

		public static List<List<Integer>> getByteArrays(int[] intArr) {
		
		    List<List<Integer>> byteLists = new ArrayList<List<Integer>>(); // return this list
		    
		    int combos = showCombinations(intArr);
		    int length = intArr.length;
		
		    char[] charArr = new char[length]; // character array the size of the input array length
		    Arrays.fill(charArr, '0'); // fill with zeros
		
		    for(int i=1; i<combos+1; i++) {
		      char[] byteCharArr = Integer.toBinaryString(i).toCharArray(); // character array with binary ones and zeros
		      List<Integer> byteList = new ArrayList<Integer>(); // list that will be part of return list
		
		      for(int j=0; j<byteCharArr.length; j++) {
		        // go backwards and fill with binary ones and zeros
		        // if binary character array is shorter, remaining elements will be zero because we filled with zeros
		        charArr[(charArr.length - 1) - j] = byteCharArr[byteCharArr.length - 1 - j];
		      }
		      for(int j=0; j<charArr.length; j++) {
		        byteList.add(Character.getNumericValue(charArr[j])); // build Integer list
		      }
		      byteLists.add(byteList); 
		    }
		    // reverse sort to start with all elements
		    return byteLists;
		  }

		public static int getFactorial(int n) {
		    int result = -1;
		    if (n < 1) {
		      return 1;
		    } else if (n == 1){
		      return n;
		    }
		    result = n * getFactorial(n-1); 
		    return result;
		  }


		 public static List<List<Integer>> mapCombinations(int[] intArr, List<List<Integer>> byteMaps) {
		    List<List<Integer>> allCombinations = new ArrayList<List<Integer>>();
		    for(int i=0; i<byteMaps.size(); i++) {
		      List<Integer> byteMap = byteMaps.get(i);
		      List<Integer> combination = new ArrayList<Integer>();
		
		      for(int j=0; j<byteMap.size(); j++) {
		        if (byteMap.get(j)==1) {
		          combination.add(intArr[j]);
		        }
		      }
		      allCombinations.add(combination);
		    }
		    return allCombinations;
		  }
}