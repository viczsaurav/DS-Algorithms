package cci;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AnagramFinderV3{

	private static final Map<HashMap<Integer, Integer>,List<String>> dictionary = new ConcurrentHashMap<>();

	public static void main(String []args){
		System.out.println("Hello World");

		List<String> dictList = Arrays.asList("cat","rat","mat","cinema","iceman","act","anemic","aaaaaa");

		dictList.stream().forEach(word -> dictionary.compute(getIdentifierKey(word),
						(k,v) -> (v==null)? new ArrayList<>():v)
						.add(word));
		dictionary.entrySet().forEach(e-> System.out.println(e.getKey()+"->"+e.getValue()));

		HashMap<Integer, Integer> keyMap = getIdentifierKey("cat");
		System.out.println("------------------------------------");
		keyMap.entrySet().forEach(e-> System.out.println(e.getKey()+"->"+e.getValue()));

		dictionary.get(keyMap).stream().forEach(System.out::println);

	}

	private static HashMap<Integer, Integer> getIdentifierKey(String word){
		HashMap<Integer, Integer> keyMap = new HashMap<>();
		for(int ch: word.toCharArray()){
			keyMap.compute(ch, (k,v)-> v==null?1:v+1);
		}
		return keyMap;
	}
}
