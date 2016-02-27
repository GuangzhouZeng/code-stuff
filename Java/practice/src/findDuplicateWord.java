import PrintOut.PrintArray;

/**
 * Created by guangzhouzeng on 2/26/16.
 */
/*
input: abc def ghi jkl ghi abc
output: abc
 */
import java.util.HashSet;
import java.util.HashMap;
public class findDuplicateWord {
    //output the duplicate one, use set
    public static String find(String str){
        String[] words = str.split(" ");
        HashSet<String> set = new HashSet<String>();
        for(String word: words){
            if(set.contains(word)) return word + "!";
            set.add(word);
        }
        return "";
    }

    //find first duplicate, use hashmap
    public static String findFirst(String str){
        HashMap<String, Integer> map = new HashMap<>(); //word, index
        String[] words = str.split(" ");
        int leftMost = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i ++){
            String word = words[i];
            if(map.containsKey(word)){
                leftMost = Math.min(leftMost, map.get(word));
            }else{
                map.put(word, i);
            }
        }
        return leftMost == Integer.MAX_VALUE ? "" : words[leftMost] + "!";
    }

    public static void main(String[] args){
        String str = "abc def ghi jkl ghi abc";
        System.out.println(find(str));
        System.out.println(findFirst(str));
    }
}
/*
in real life String, find all duplicate word, ex: find from a book, what should be considered about?
1. split String by using regex. Split ",", " ", ".", etc.
2. ignore some unimportant words: such as: I, you, she, do, does, did
3. Consider capital word. Convert all upper case into lower cases
4. use trie to save memory.
5. If memory cannot hold, we can put all words into disk first. Then only read the necessary in. But the
I/O will affect the speed.
6. Can use multi-thread, can use multiple machine to process simultaneously.
 */
