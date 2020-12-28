package com.wipro.phone.dir;

class Main {
	public static void main(String args[]) {
		Phone phone = new Phone();

		String contacts[] = { "prashanth", "pchandrappa", "pcbarangi" };

		phone.insertIntoTrie(contacts);

		String query = "pcbs";

		/**
		 * Note that the user will enter 'p' then 'c' so first display all the strings
		 * with prefix as 'p' and then all the strings with prefix as 'pc'
		 **/
		phone.displayContacts(query);
	}
}