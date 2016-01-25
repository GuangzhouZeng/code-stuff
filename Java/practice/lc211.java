public class WordDictionary {
    public class TrieNode{
        TrieNode[] children;
        char val;
        boolean isWord;
        
        public TrieNode(){
            this.children = new TrieNode[26];
            this.isWord = false;
        }
        
        public TrieNode(char val){
            this.val = val;
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }
    
    public TrieNode root;
    
    public WordDictionary(){
        root = new TrieNode();
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode temp = root;
        for(char c: word.toCharArray()){
            if(temp.children[c-'a']==null){
                TrieNode node = new TrieNode(c);
                temp.children[c-'a'] = node;
            }
            temp = temp.children[c-'a'];
        }
        temp.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, root);
    }
    public boolean search(String word, TrieNode root){
        if(word.equals("")) return root.isWord;
        char c = word.charAt(0);
        if(c=='.'){
            for(char i=0;i<26;i++){
                if(root.children[i]==null) continue;
                boolean res = search(word.substring(1),root.children[i]);
                if(res) return true;
            }
            return false;
        }else{
            if(root.children[c-'a']==null) return false;
            return search(word.substring(1),root.children[c-'a']);
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");