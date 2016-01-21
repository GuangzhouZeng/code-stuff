public class Solution {
    public int maxProduct(String[] words) {
        Arrays.sort(words,new Comparator<String>(){ //O(nlogn)
            @Override
            public int compare(String s1, String s2){
                return s2.length()-s1.length();
            }
        });
        
        int[] wordMap = new int[words.length];
        for(int i=0;i<words.length;i++){  //O(m*n)
            for(int j=0;j<words[i].length();j++){
                wordMap[i]|=(1<<(words[i].charAt(j)-'a'));
            }
        }
        
        int res=0;
        for(int i=0;i<words.length;i++){ //O(n^2)
            if(words[i].length()*words[i].length()<res) break;
            for(int j=i+1;j<words.length;j++){
                if((wordMap[i]&wordMap[j])==0){
                    res=Math.max(res, words[i].length()*words[j].length());
                    break;
                }
            }
        }
        
        return res;
    }
}