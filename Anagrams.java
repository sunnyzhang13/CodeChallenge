import java.io.*;
import java.util.*;

class Anagrams {
	/** Map to store sorted strings to all anagrams seen. */
	public static HashMap<String, List<String>> dict = new HashMap<String, List<String>>();

	public static void main(String[] args) {
		String fileName = args[0];
		processDict(fileName);
		readInput();
	}

	/** Reads in words from the file, puts them in the mapping
	from sorted version to anagrams. Processes list of anagrams,
	sorting them and then putting them into a string for easy 
	print out. */
	public static void processDict(String fileName) {
        String line = null;

        try {
            FileReader fileReader = 
                new FileReader(fileName);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            char[] charArray = null;

            while((line = bufferedReader.readLine()) != null) {
                String word = line.toLowerCase();
				charArray = word.toCharArray();
				Arrays.sort(charArray);
				String sortedWord = new String(charArray);
				if (dict.containsKey(sortedWord)) {
					List<String> inner = dict.get(sortedWord);
					inner.add(line);
					dict.put(sortedWord, inner);
				} else {
					List<String> inner = new ArrayList<String>();
					inner.add(line);
					dict.put(sortedWord, inner);
				}
            }  

            for (String key : dict.keySet()) {
            	List<String> sorted = dict.get(key);
            	Collections.sort(sorted);
            	String result = "";
            	for (String ana : sorted) {
            		result = result + ana + " ";
            	}
            	result = result.trim();
            	sorted.clear();
            	sorted.add(result);
            	dict.put(key, sorted);
            }

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("Cannot find file");                
        }
        catch(IOException ex) {
            System.out.println("Error occurred while reading file");         
        }
	}

	/** Reads in words from stdin and prints if sorted 
	version exists in map. */
	public static void readInput() {
		 BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            char[] charArray = null;

            while (true) {
                String word = br.readLine().toLowerCase();

                if ("".equals(word)) {
                    System.exit(0);
                }

                charArray = word.toCharArray();
				Arrays.sort(charArray);
				String sortedWord = new String(charArray);

				if (dict.containsKey(sortedWord)) {
					System.out.println(dict.get(sortedWord).get(0));
				} else {
					System.out.println("-");
				}
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}