package April;

class TrieNode{
    boolean isWord;
    TrieNode[] alphabet;
    
    public TrieNode(){
        this.alphabet = new TrieNode[26];
        this.isWord = false;
    }
    
}

public class Trie {
    private TrieNode root;
    
    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word){
        TrieNode current = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(current.alphabet[index] == null){
                current.alphabet[index] = new TrieNode();
            }
            current = current.alphabet[index];
        }
        current.isWord = true;
    }

    public boolean search(String word){
        TrieNode current = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(current.alphabet[index] == null){
                return false;
            }
            current = current.alphabet[index];
        }
        return current.isWord;
    }

    public boolean isPrefix(String prefix){
        TrieNode current = root;
        for(char c: prefix.toCharArray()){
            int index = c - 'a';
            if(current.alphabet[index] == null)
                return false;
            current = current.alphabet[index];
        }
        return true;
    }

    public boolean delete(String word){
        return deleteHelper(root, word, 0);
    }

    private boolean deleteHelper(TrieNode root, String word, int depth) {
        if(depth == word.length()){
            if(!root.isWord)
                return false;
            root.isWord = false;
            return isEmpty(root);
        }
        char c = word.charAt(depth);
        int index = c - 'a';
        TrieNode child = root.alphabet[index];
        if (child == null) {
            // Word does not exist
            return false;
        }
        boolean shouldDeleteChild = deleteHelper(child, word, depth + 1);

        if (shouldDeleteChild) {
            // Remove the reference to the child node
            root.alphabet[index] = null;

            // Return true if the current node can also be deleted
            return !root.isWord && isEmpty(root);
        }
        return false;
    }

    private boolean isEmpty(TrieNode node) {
        for (TrieNode child : node.alphabet) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }

}
