import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/*
Process:
read input
compute frequencies
build trie/codeword table
write trie as bitstring to compressed file
write out character count of input
use table to write out the codeword for each input character
*/


class Huf {
    public static void main(String[] args) throws IOException {
        // first step: passed file as input, read it and compute frequencies
        // args[0] will be our filename
        String filename = args[0];        

        StringBuilder input = new StringBuilder();
		Scanner s = new Scanner(new FileInputStream(filename));
		while (s.hasNext()) input.append(s.next());
		s.close(); 

        // we will store frequencies in hashmap<char, int>
        HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            if (!freq.containsKey(curr)) freq.put(curr, 1);
            else freq.put(curr, freq.get(curr) + 1);
        }

        // display frequencies
        //System.out.println(freq.toString());

        // next step is to build a prefix-free codeword table based on these frequencies
        


    }
}