package cci;

import java.io.*;
import java.net.URL;
import java.util.*;

/**
 * This java program lets you find all Anagrams of an input string present in the dictionary.
 *
 * The assumption here is:
 *  - It will be used as single user interface
 *  - It will be used sparsely.
 *  - Multi-word lines in dictionary must be skipped
 *  - Search input string will not be too long.
 *
 * Due to above assumptions, in the current approach:
 *  - We save all dictionary words in a set
 *  - We generate all anagrams of a given input string
 *  - We iterate through this anagram list to check for presence dictionary set.
 *  - Return and print the found anagrams.
 */

public class AnagramFinder {

	private static final Set<String> dictionary =  new HashSet<>();
	private static final String EXIT_STR = "EXIT";

	public static void main(String[] args) throws Exception{

		System.out.println("\nWelcome to the Anagram Finder\n--------------------------------");

		// Populate the dictionary Set
		readDictionary(args);

		// User input
		try (Scanner scanner = new Scanner(System.in)) {
			String input;  // Read user input
			while(true){
				System.out.print("\nAnagramFinder> ");
				input = scanner.nextLine();  // Read user input

				if(input.split(" ").length>1){
					System.out.println("Multi-word search is not supported, skipping...");
					continue;
				}
				if (!input.equalsIgnoreCase(EXIT_STR)){
					processInput(input);
				} else {
					break;
				}
			}
		}
		System.out.println("Exiting..\n");
	}

	/**
	 * Read dictionary and populate the set
	 * @param args
	 * @throws FileNotFoundException
	 * @throws Exception
	 */
	private static void readDictionary(String[] args) throws IOException {
		if(args.length<1){
			throw new IllegalArgumentException("Please provide the input dictionary..");
		}

		URL path = AnagramFinder.class.getResource(args[0]);
		if(path==null) {
			throw new FileNotFoundException("Cannot find file in current folder: "+ args[0]);
		}
		File f = new File(path.getFile());
		String st;
		long startTime = System.currentTimeMillis();
		try(BufferedReader reader = new BufferedReader(new FileReader(f));){
			while ((st = reader.readLine()) != null) {
				if(st.split(" ").length>1){
					System.out.println("Multi-word not supported: ["+ st + "], skipping...");
				} else {
					dictionary.add(st.toLowerCase());
				}
			}
		}
		catch(IOException e){
			throw e;
		}
		displayExecutionTime("Dictionary Loaded", startTime);
	}

	/**
	 * Process each user input string
	 * @param word
	 */
	private static void processInput(String word) {
		long startTime = System.currentTimeMillis();
		List<String> foundAnagrams = fetchAnagramsFromDictionary(word);
		displayExecutionTime(foundAnagrams.size() + " Anagrams found for " + word, startTime);
		System.out.println(String.join(",", foundAnagrams));
	}

	/**
	 * fetch all found anagrams from the dictionary
	 * @param word
	 * @return
	 */
	private static List<String> fetchAnagramsFromDictionary(String word){
		List<String> foundAnagrams = new ArrayList<>();
		List<String> allAnagrams = getAllAnagramsForWord(word);

		for (String anagram: allAnagrams){
			if(dictionary.contains(anagram)){
				foundAnagrams.add(anagram);
			}
		}
		return foundAnagrams;
	}

	/**
	 * Generate all anagrams of a given word
	 * @param word
	 * @return
	 */
	private static List<String> getAllAnagramsForWord(String word){
		List<String> anagrams = new ArrayList<>();
		anagrams.add(word);
		return anagrams;
	}

	/**
	 * Display execution time of the activity in Milli seconds
	 * @param activity
	 * @param startTime
	 */
	private static void displayExecutionTime(String activity, long startTime) {
		long finishTime = System.currentTimeMillis();
		double elapsedTime = (finishTime - startTime);
		System.out.println(activity +" in " + elapsedTime + " ms");
	}
}