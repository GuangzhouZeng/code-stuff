package Trie;

/**
 * Created by guangzhouzeng on 2/9/16.
 */
public class TrieNode {
    char val;
    boolean hasWord; /* this is meaningless. I think use an Integer to store how many words in this path is more useful, so that
    we can also use it to delete a word and also check if there is a word in this path.*/

    boolean isWord;
    TrieNode[] children;

    public TrieNode(char val){
        children = new TrieNode[26];
        hasWord = false;
        isWord = false;
        this.val = val;
    }

    public TrieNode(){
        children = new TrieNode[26];
    }
}
