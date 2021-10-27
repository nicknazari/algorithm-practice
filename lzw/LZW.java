import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.xml.namespace.QName;

// Nick Nazari
// practice implementation of LZW compression
// CS1501 univ of pitt, fall 2021

class LZW {
	public static void main(String[] args) throws IOException  {
		// in args we will be passed two arguments:
		// arg 1 compress or expand
		// arg 2 filename
		String operation = args[0];
		String filename = args[1];
		String output = null;
		
		// parsing our input file to a string so that is can be broken in to bits
		StringBuilder input = new StringBuilder();
		ArrayList<Integer> inputList = new ArrayList<Integer>();
		Scanner s = new Scanner(new FileInputStream(filename));
		while (s.hasNext()) {
			char[] line = s.next().toCharArray();
			for (char c: line) {
				input.append((int) c + " ") ;
			}
		}
		s.close(); 

		HashMap<Character, Integer> codebook = new HashMap<Character, Integer>();
		// put all possible ascii codes in codebook
		for (int i = 0; i < 256; i++) {
			codebook.put((char) i, i);
		}

		for (Character c : codebook.keySet()) {
			System.out.println(c);
		}
		
		output = compress(input.toString());

		System.out.println("Input: " + input);
		System.out.println("Operation: " + operation);
		System.out.println("Output: " + output);
	}

	public static String matchLongestPrefix(ArrayList<String> in) {
		StringBuilder longest = new StringBuilder();
		int pos = 0;

		StringBuilder prefix = new StringBuilder();
		for (String s : in) {
			
		}

		longest.append(prefix + in.get(pos + 1));
		return longest.toString();
	}

	public static String compress(String ascii) {
		String out = null;
		return out;

	}

	public static String expand(String ascii) {
		String out = null;
		return out;
	}

}