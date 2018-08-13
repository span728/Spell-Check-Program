// Stephanie Pan
// COMS3134 Blaer
// Problem Set 4
// SpellChecker.java
// *spellchecker program - checks words in text file
// against selected dictionary*
// Due Dec 1st, 2017 

import java.io.*; 
import java.util.HashSet; 
import java.util.ArrayList; 
import java.util.Scanner; 


public class SpellChecker {

	// method for finding word suggestions by adding characters
	private static void fixByAdding(String word, HashSet<String> dict) {

		ArrayList<String> potentials = new ArrayList<String>(); 
		String alphabet = "abcdefghijklmnopqrstuvwx'yz"; 

		for (int i = 0; i <= word.length(); i++) {

			// adding char before the word 
			if (i==0) {
				for (int j = 0; j<alphabet.length()-1; j++) {
					String tester = alphabet.charAt(j) + word; 

					if (dict.contains(tester)) {
						potentials.add(tester); 
					}
				}
			}

			// adding char in the middle of the word
			if (i > 0 && i < word.length()) {
				for (int k = 0; k<alphabet.length()-1; k++) {
					String tester = word.substring(0,i) + 
							alphabet.substring(k, k+1)+ word.substring(i);

					if (dict.contains(tester)) {
						potentials.add(tester); 
					}
				}
			}

			// adding char at end of the word 
			if (i == word.length()) {
				for (int n = 0; n<alphabet.length()-1; n++) {
					String tester = word + alphabet.charAt(n); 

					if (dict.contains(tester)) {
						potentials.add(tester); 
					}
				}
			}
		}
		System.out.println(potentials); 
	}

	// method for finding word suggestions by deleting a character
	private static void fixBySubtracting(String word, HashSet<String> dict) {
		
		ArrayList<String> potentials = new ArrayList<String>(); 

		for (int i = 0; i < word.length(); i++) {

			if (i==0) {
				String tester = word.substring(1, word.length()); 

				if (dict.contains(tester)) 
					potentials.add(tester); 
			}

			if (i > 0 && i < word.length()-1) {
				String tester = word.substring(0, i) +
										word.substring(i+1, word.length());										

				if (dict.contains(tester)) 
					potentials.add(tester); 
			}

			if (i == word.length()-1) {
				String tester = word.substring(0, word.length()-1); 

				if (dict.contains(tester)) 
					potentials.add(tester); 			
			}

		}

		System.out.println(potentials); 

	}

	// method for finding word suggestions by swapping adjacent characters
	private static void fixBySwapping(String word, HashSet<String> dict) {

		ArrayList<String> potentials = new ArrayList<String>(); 

		for (int i = 0; i < word.length()-1; i++) {


			if (i==0) {
				String tester = word.substring(1,2) 
									+ word.substring(0,1) + word.substring(2);

				if (dict.contains(tester)) {
					potentials.add(tester); 
				}
			}

			if (i > 0 && i < word.length()-2) {
				String tester = word.substring(0, i) + word.charAt(i+1) 
						+ word.charAt(i) + word.substring(i+2, word.length());  		

				if (dict.contains(tester)) {
					potentials.add(tester); 
				}
			}

			if (i==word.length()-2) {
				String tester = word.substring(0, i) + word.charAt(i+1) 
															+ word.charAt(i);				

				if (dict.contains(tester)) {
					potentials.add(tester); 
				}
			}					
		}

		System.out.println(potentials); 
		
	}

	// main method 
	public static void main(String[] args) {
		try {
		// instance variables 
		HashSet<String> dictionary = new HashSet<String>(); 

		// file making 
		File tempdict = new File(args[0]); 
		Scanner input = new Scanner(tempdict); 
		File wordlist = new File(args[1]); 
		Scanner input1 = new Scanner(wordlist); 

		// putting dictionary items into hashset 
		while (input.hasNext()) {
			String entry = input.next(); 
			entry = entry.toLowerCase(); 
			dictionary.add(entry); 
		}

		// making arraylist of words in text to be checked 
		int lineNumber = 1; // variable to keep track of line number
		while (input1.hasNextLine()) {

			String line = input1.nextLine(); 

			String[] wordList = line.split("\\s+"); 

			// cleaning up the words
			for (int i = 0; i < wordList.length; i++) {
				String word = wordList[i]; 
				word = word.toLowerCase(); 
				word = word.replaceFirst("^[^a-zA-Z]+", ""); 
				word = word.replaceAll("[^a-zA-Z]+$", "");

				// running spellcheck
				if (dictionary.contains(word))
					System.out.println("Word: " + word); 
				else {	
					System.out.println("We don't recognize the word " + word + 
												" on Line " + lineNumber + ". ");
					System.out.println("Here are some suggestions."); 
					fixByAdding(word, dictionary); 
					fixBySubtracting(word, dictionary); 
					fixBySwapping(word, dictionary); 
				}
			}	
			lineNumber++; 
		}		
		System.out.println("Thanks for using Stephanie's Spell Check!"); 
		} // end try 
		catch(FileNotFoundException e) {
			System.out.println("Please input correct file name. "); 
			System.out.println(e); 
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Enter an argument please. "); 
			System.out.println(e); 
		}
	} // end main method
}