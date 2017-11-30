1. The offline part of the program runs in O(D * M log M), with D being the number of words in the 
dictionary and M being the average length of each word. The online part of the program runs in 
O(W * M log M), W being the number of words typed into stdin and M being the average length of each word.

2. The program consumes O(D) memory, with D being the number of words in the dictionary, due to the
storing of a hashmap with all the words in it.

3. If I didn't have enough memory to preprocess all the results, I would 


Overview of algorithm: We start with a map that stores a mapping from sorted words to a list of anagrams 
for that word. The algorithm goes through all the words in the dictionary and sorts each individual word. 
If the sorted version of that word exists in the map, we append it to the end of the list in the mapping. 
If not, we create a new list and add it into the map. I chose to add the original word from the dictionary into
the map so that when it prints out, we'll see all the original words. Next, I go through all the mappings
in the map, and sort the lists lexicographically. Then I append each anagram in the list to a string,
and put that back in the map with the sorted version of the word. All that's left to do is read from stdin,
sort the word, and, if it's non empty, check if it exists in the map. If it does, all I need to do is 
print out the string stored in the mapping. Else, I print out a dash.