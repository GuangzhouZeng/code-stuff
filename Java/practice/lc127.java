public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        int res = 0;
        if(beginWord!=null) queue.offer(beginWord);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            res++;
            for(int i=0;i<size;i++){
                String temp = queue.poll();
                List<String> neibors = getNeibors(temp, wordList);//time
                for(String neibor: neibors){
                    wordList.remove(neibor);
                    if(neibor.equals(endWord)) return res+1;
                    queue.offer(neibor);
                }
            }
        }
        return 0;
    }
    
    private List<String> getNeibors(String word, Set<String> wordList){
        List<String> res = new ArrayList<String>();
        char[] chars = word.toCharArray();
        
        for(int i=0;i<word.length();i++){
            char oldchar = chars[i];
            for(int j=0;j<26;j++){
                chars[i]=(char)('a'+j);
                String temp = String.valueOf(chars);
                if(wordList.contains(temp)){
                    res.add(temp);
                }
            }
            chars[i]=oldchar;
        }
        return res;
    }
}