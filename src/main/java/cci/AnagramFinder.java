package cci;

import java.io.*;
import java.net.URL;
import java.util.*;

public class AnagramFinder {

	private static final Set<String> dictionary =  new HashSet<>();
	private static final String EXIT_STR = "EXIT";


	public static void main(String[] args) throws Exception{

		System.out.println("\nWelcome to the Anagram Finder\n--------------------------------");

		// Populate the dictionary Set
		readDictionary(args);

		// User input
		List<String> foundAnagrams;
		try (Scanner scanner = new Scanner(System.in)) {
			String input = "";  // Read user input
			while(true){
				System.out.print("\nAnagramFinder> ");
				input = scanner.nextLine();  // Read user input
				if (!input.equalsIgnoreCase(EXIT_STR)){
					long startTime = System.currentTimeMillis();
					foundAnagrams = fetchAnagramsFromDictionary(input);
					displayExecutionTime(foundAnagrams.size()+ " Anagrams found for "+ input, startTime);
					System.out.println(String.join(",",foundAnagrams));
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
	private static void readDictionary(String[] args) throws FileNotFoundException, IOException {
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
				if(st.split(" ").length>1 || st.split(",").length>1){
					System.out.println("Multi-word not supported: ["+ st + "], skipping...");
				} else {
					dictionary.add(st.toLowerCase());
				}
			}
			// dictionary.forEach(System.out::println);
		}
		catch(IOException e){
			throw e;
		}
		displayExecutionTime("Dictionary Loaded", startTime);
	}

	private static List<String> fetchAnagramsFromDictionary(String input){
		List<String> foundAnagrams = new ArrayList<>();

		List<String> allAnagrams = getAllAnagramsForWord(input);

		for (String anagram: allAnagrams){
			if(dictionary.contains(anagram)){
				foundAnagrams.add(anagram);
			}
		}
		return foundAnagrams;
	}

	private static List<String> getAllAnagramsForWord(String input){
		List<String> anagrams = new ArrayList<>();
		anagrams.add(input);
		return anagrams;
	}

	private static void displayExecutionTime(String activity, long startTime) {
		long finishTime = System.currentTimeMillis();
		double elapsedTime = (finishTime - startTime);
		System.out.println(activity +" in " + elapsedTime + " ms");
	}
}