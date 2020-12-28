package com.wipro.palindrome;

import java.util.ArrayList;

/**
 * Java program to find longest possible Palindrome in character set
 **/
public class LongestPalindromeInCharSet {
	public static boolean isPalindrome(String s) {
		StringBuffer sb = new StringBuffer(s);
		if (s.equalsIgnoreCase(sb.reverse().toString()))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {

		String str = "HelloWelcomeemoclewHelloolle";

		if (str.length() > 2) {
			StringBuffer sb = new StringBuffer();
			ArrayList<String> allPalindromeList = new ArrayList<>();

			for (int i = 0; i < str.length(); i++) {
				for (int j = i; j < str.length(); j++) {
					sb.append(str.charAt(j));
					if (isPalindrome(sb.toString())) {
						allPalindromeList.add(sb.toString());
					}
				}
				// clear the stringBuffer
				sb.delete(0, sb.length());
			}

			int maxSubStrLength = -1;
			int indexMaxSubStr = -1;
			int index = -1;

			for (String subStr : allPalindromeList) {
				++index;
				if (maxSubStrLength < subStr.length()) {
					maxSubStrLength = subStr.length();
					indexMaxSubStr = index;
				}
			}
			if (maxSubStrLength > 2)
				System.out.println("Maximum Length Palindrome SubString is : " + allPalindromeList.get(indexMaxSubStr));
			else
				System.out.println("Not able to find a Palindrome who is three character in length!!");

		}
	}

}