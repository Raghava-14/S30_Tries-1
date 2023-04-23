//Time = O(n*m), , where n is the number of words in the sentence and m is the length of the longest word in the dictionary
//Space = O(k*m), where k is the number of words in the dictionary and m is the length of the longest word in the dictionary

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        // Create a new Trie to store the dictionary words
        Trie trie = new Trie();
        
        // Build the Trie from the dictionary words
        for (String word : dictionary) {
            trie.insert(word);
        }
        
        // Replace words in the sentence using the Trie
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split("\\s+"); // Split the sentence into individual words
        for (String word : words) {
            String prefix = trie.findPrefix(word); // Find the shortest prefix of the word in the Trie
            if (prefix != null) { // If a prefix is found, add it to the output
                sb.append(prefix);
            } else { // Otherwise, add the original word to the output
                sb.append(word);
            }
            sb.append(" "); // Add a space after each word
        }
        
        // Remove the trailing space and return the result
        return sb.toString().trim();
    }
}

class Trie {
    private TrieNode root; // The root node of the Trie
    
    // Constructor to initialize the root node
    public Trie() {
        root = new TrieNode();
    }
    
    // Method to insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root; // Start at the root node
        for (char c : word.toCharArray()) { // Traverse the Trie one character at a time
            if (node.children[c - 'a'] == null) { // If the child node doesn't exist, create it
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a']; // Move to the child node
        }
        node.isEndOfWord = true; // Mark the last node as the end of a word
    }
    
    // Method to find the shortest prefix of a word in the Trie
    public String findPrefix(String word) {
        TrieNode node = root; // Start at the root node
        StringBuilder sb = new StringBuilder(); // Create a StringBuilder to store the prefix
        for (char c : word.toCharArray()) { // Traverse the Trie one character at a time
            sb.append(c); // Add the character to the prefix
            if (node.children[c - 'a'] == null) { // If the child node doesn't exist, the prefix doesn't exist
                return null;
            }
            node = node.children[c - 'a']; // Move to the child node
            if (node.isEndOfWord) { // If the current node is the end of a word, return the prefix
                return sb.toString();
            }
        }
        return null; // If no prefix is found, return null
    }
}

class TrieNode {
    TrieNode[] children; // An array of child nodes
    boolean isEndOfWord; // A flag to indicate the end of a word
    
    // Constructor to initialize the child nodes and end-of-word flag
    public TrieNode() {
        children = new TrieNode[26]; // There are 26 possible characters ('a' to 'z')
        isEndOfWord = false;
    }
}
