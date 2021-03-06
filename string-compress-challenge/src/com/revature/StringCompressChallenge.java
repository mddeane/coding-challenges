package com.revature;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class StringCompressChallenge {

	  public static void main(String[] args) {

	    String userInputString = new String();

	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter a string with repeated characters:");
	    userInputString = scanner.nextLine();

	    System.out.println(compressString(userInputString));
	  }

	  public static String compressString(String inputStr) {
	    String result = "";
	    String testResult = "";
	    char[] charArr = inputStr.toCharArray();
	    LinkedHashMap<Character, Integer> charToCount = new LinkedHashMap<Character, Integer>();

	    for(int i=0; i<charArr.length; i++) {
	      if(!charToCount.containsKey(charArr[i])) {
	        charToCount.put(charArr[i], 1);
	      } else {
	        int currentCount = charToCount.get(charArr[i]);
	        currentCount++;
		charToCount.put(charArr[i], currentCount);
	      }
	    }

	    Set<Character> kSet = charToCount.keySet();
	    Iterator<Character> iter = kSet.iterator();

	    while(iter.hasNext()) {
	      char k = iter.next();
	      int v = charToCount.get(k);
	      testResult = testResult + k + v;
	    }

	    if(testResult.length() < inputStr.length()) {
	      result = testResult;
	    } else {
	      result = inputStr;
	    }

	    return result;
	  }
}
