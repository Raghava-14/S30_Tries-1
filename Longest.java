//Time = 
//Space = O(n) 

class Solution {
    public String longestWord(String[] words) {
        // Create a set of words from the input array
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        
        // Initialize the longestWord variable to an empty string
        String longestWord = "";
        
        // Iterate through each word in the dictionary
        for (String word : words) {
            // Check if all prefixes of the word are in the set
            boolean isValid = true;
            for (int i = 1; i < word.length(); i++) {
                // Get the prefix of the word up to index i
                String prefix = word.substring(0, i);
                
                // If the prefix is not in the set, the word is not valid and we break out of the loop
                if (!wordSet.contains(prefix)) {
                    isValid = false;
                    break;
                }
            }
            
            // If all prefixes are in the set and the word is longer than the current longest word, update longestWord
            if (isValid && word.length() > longestWord.length()) {
                longestWord = word;
            }
            // If the word is the same length as the current longest word but comes before it lexicographically, update longestWord
            else if (isValid && word.length() == longestWord.length() && word.compareTo(longestWord) < 0) {
                longestWord = word;
            }
        }
        
        // Return the longest valid word
        return longestWord;
    }
}
