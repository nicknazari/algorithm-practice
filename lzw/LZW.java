import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

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
		Scanner s = new Scanner(new FileInputStream(filename));
		while (s.hasNext()) {
			char[] line = s.next().toCharArray();
			for (char c: line) {
				input.append((int) c);
			}
		}
		s.close(); 

		System.out.println("Input: " + input);
		System.out.println("Operation: " + operation);
		System.out.println("Output: " + output);
	}

	private String compress(String ascii) {
		String out = null;
		return out;

	}

	private String expand(String ascii) {
		String out = null;
		return out;
	}

}


