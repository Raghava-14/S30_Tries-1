//Time = 
//Space = 

// Define a Trie node with an array of children nodes and a boolean value to indicate if it's the end of a word
class TrieNode {
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
}

class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        // Create an empty root node when a new Trie is initialized
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        // Start at the root node
        TrieNode node = root;
        // Iterate over each character in the word
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // Check if the current character's child node exists
            if (node.children[c - 'a'] == null) {
                // If it doesn't exist, create a new node for it
                node.children[c - 'a'] = new TrieNode();
            }
            // Move on to the next node
            node = node.children[c - 'a'];
        }
        // Mark the end of the word by setting the node's isWord value to true
        node.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        // Start at the root node
        TrieNode node = root;
        // Iterate over each character in the word
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // Check if the current character's child node exists
            if (node.children[c - 'a'] == null) {
                // If it doesn't exist, the word is not in the trie
                return false;
            }
            // Move on to the next node
            node = node.children[c - 'a'];
        }
        // If the final node's isWord value is true, the word is in the trie
        return node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        // Start at the root node
        TrieNode node = root;
        // Iterate over each character in the prefix
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            // Check if the current character's child node exists
            if (node.children[c - 'a'] == null) {
                // If it doesn't exist, no words in the trie start with the prefix
                return false;
            }
            // Move on to the next node
            node = node.children[c - 'a'];
        }
        // At this point, all characters in the prefix exist in the trie, so there must be some words that start with the prefix
        return true;
    }
}
