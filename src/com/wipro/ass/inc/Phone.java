package com.wipro.ass.inc;

class Phone {
	PhoneDir phoneDir;

	/** Insert all the Contacts into the Phone Trie Node **/
	public void insertIntoTrie(String contacts[]) {
		phoneDir = new PhoneDir();
		int n = contacts.length;
		for (int i = 0; i < n; i++) {
			insert(contacts[i]);
		}
	}

	// Insert a Contact into the Phone Trie
	public void insert(String s) {
		int len = s.length();

		// 'itr' is used to iterate the Trie Nodes
		PhoneDir itr = phoneDir;
		for (int i = 0; i < len; i++) {
			// Check if the s[i] is already present in Phone Trie

			PhoneDir nextNode = itr.child.get(s.charAt(i));
			if (nextNode == null) {
				// If not found then create a new Phone TrieNode
				nextNode = new PhoneDir();

				// Insert into the HashMap
				itr.child.put(s.charAt(i), nextNode);
			}

			// Move the iterator('itr') ,to point to next Phone Trie Node

			itr = nextNode;

			// If its the last character of the string 's' then mark 'isLast' as true

			if (i == len - 1)
				itr.isLast = true;
		}
	}

	/**
	 * This function simply displays all dictionary words going through current
	 * node. String 'prefix' represents string corresponding to the path from root
	 * to curNode.
	 **/
	public void displayContactsUtil(PhoneDir curNode, String prefix) {

		/**
		 * Check if the string 'prefix' ends at this Node If yes then display the string
		 * found so far
		 **/
		if (curNode.isLast)
			System.out.println(prefix);

		/**
		 * Find all the adjacent Nodes to the current Node and then call the function
		 * recursively This is similar to performing DFS on a graph
		 **/
		for (char i = 'a'; i <= 'z'; i++) {
			PhoneDir nextNode = curNode.child.get(i);
			if (nextNode != null) {
				displayContactsUtil(nextNode, prefix + i);
			}
		}
	}

	/**
	 * Display suggestions after every character enter by the user for a given
	 * string 'str'
	 **/
	void displayContacts(String str) {
		PhoneDir prevNode = phoneDir;

		/**
		 * 'flag' denotes whether the string entered so far is present in the Contact
		 * List
		 **/

		String prefix = "";
		int len = str.length();

		/**
		 * Display the contact List for string formed after entering every character
		 **/
		int i;
		for (i = 0; i < len; i++) {
			// 'str' stores the string entered so far
			prefix += str.charAt(i);

			// Get the last character entered
			char lastChar = prefix.charAt(i);

			/**
			 * Find the Node corresponding to the last character of 'str' which is pointed
			 * by prevNode of the Trie
			 **/
			PhoneDir curNode = prevNode.child.get(lastChar);

			/**
			 * If nothing found, then break the loop as no more prefixes are going to be
			 * present.
			 **/
			if (curNode == null) {
				System.out.println("Number of  Results Found for " + prefix + " ");
				i++;
				break;
			}

			/**
			 * If present in trie then display all the contacts with given prefix.
			 **/
			System.out.println("Number of Suggestions based on " + prefix + " are");
			displayContactsUtil(curNode, prefix);

			// Change prevNode for next prefix
			prevNode = curNode;
		}

		for (; i < len; i++) {
			prefix += str.charAt(i);
			System.out.println(" Results Found for " + prefix + " ");
		}
	}
}
