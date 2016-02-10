package Trie;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by guangzhouzeng on 2/9/16.
 */
public class Trie {
    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void addWord(String word){
        TrieNode temp = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(temp.children[index] == null){
                temp.children[index] = new TrieNode(c);
                temp.hasWord = true;
            }
            temp = temp.children[index];
        }
        temp.isWord = true;
    }

    public void deleteWord(String word){

    }

    public boolean searchWord(String word){
        TrieNode temp = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(temp.children[index] == null || !temp.children[index].hasWord) return false;
            temp = temp.children[index];
        }
        return temp.isWord;
    }

    public List<String> searchWordFromPrefix(String prefix){
        TrieNode temp = root;
        List<String> res = new LinkedList<>();
        for(char c: prefix.toCharArray()){
            int index = c - 'a';
            if(temp.children[index] == null || !temp.children[index].hasWord) return res;
            temp = temp.children[index];
        }

        DFSHelper(temp, prefix, res);
        return res;
    }

    private void DFSHelper(TrieNode temp, String cur, List<String> res){
        if(temp.isWord) res.add(cur);

        for(int i = 0; i < 26; i++){
            if(temp.children[i] != null){
                DFSHelper(temp.children[i], cur + temp.children[i].val, res);
            }
        }

    }
}
