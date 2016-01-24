class TrieNode {
    // Initialize your data structure here.
    char val;
    TrieNode[] child;
    boolean isWord;
    public TrieNode() {
        child = new TrieNode[26];
        isWord=false;
    }
    public TrieNode(char val) {
        child = new TrieNode[26];
        isWord=false;
        this.val = val;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode temproot = root;
        for(char c: word.toCharArray()){
            if(temproot.child[c-'a']==null){
                TrieNode node = new TrieNode(c);
                temproot.child[c-'a']=node;
            }
            temproot=temproot.child[c-'a'];
        }
        temproot.isWord=true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode temproot = find(word);
        return temproot!=null&&temproot.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return find(prefix)!=null;
    }
    private TrieNode find(String word){
        TrieNode temproot = root;
        for(char c: word.toCharArray()){
            if(temproot.child[c-'a']!=null) temproot=temproot.child[c-'a'];
            else return null;
        }
        return temproot;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");