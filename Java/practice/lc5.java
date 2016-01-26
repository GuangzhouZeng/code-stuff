public class Solution {
    private int lo=0,hi=-1;
    public String longestPalindrome(String s) {
        int n = s.length();
        for(int i=0;i<n;i++){
            expand(s,i,i);
            expand(s,i,i+1);
        }
        return s.substring(lo,hi+1);
    }
    
    private void expand(String s, int start, int end){
        while(start>=0&&end<=s.length()-1&&s.charAt(start)==s.charAt(end)){
            int len = end+1-start;
            if(len>hi-lo+1){
                lo=start;hi=end;
            }
            start--;end++;
        }
    }
}