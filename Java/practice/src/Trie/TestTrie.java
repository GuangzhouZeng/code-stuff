package Trie;


import java.util.Arrays;
import java.util.List;
import PrintOut.PrintList;
/**
 * Created by guangzhouzeng on 2/9/16.
 */
public class TestTrie {
    public static void main(String[] args){
        List<String> wordList = Arrays.asList("leetcode", "carrot","superman", "car", "carplay","carpool");
        List<String> prefixSet = Arrays.asList("leet", "car", "sp", "ca");

        //create trie tree
        Trie trie = new Trie();
        for(String word: wordList) {
            trie.addWord(word);
        }

        //check is every word insert successfully
        for(String word: wordList){
            System.out.print("insert \"" + word + "\" successfully: ");
            System.out.println(trie.searchWord(word));
        }

        //output all words has the prefix in prefix set
        for(String prefix: prefixSet){
            System.out.print(prefix + ": ");
            PrintList.printListString(trie.searchWordFromPrefix(prefix));
        }
    }
}
