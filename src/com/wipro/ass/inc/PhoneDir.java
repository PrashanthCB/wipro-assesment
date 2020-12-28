package com.wipro.ass.inc;

/** Java Program to Implement a Phone 
  *  Directory Using Trie Data Structure 
 **/
import java.util.HashMap;

class PhoneDir {
	/**
	 * Each Phone Dir contains a Map 'child' where each alphabet points to a Phone
	 * trie Node
	 **/

	HashMap<Character, PhoneDir> child;

	// 'isLast' is true if the node represents end of a contact

	boolean isLast;

	public PhoneDir() {
		child = new HashMap<Character, PhoneDir>();

		// Initialize all the Phone Dir nodes with NULL
		for (char i = 'a'; i <= 'z'; i++)
			child.put(i, null);

		isLast = false;
	}
}