public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(s, 0, new ArrayList<String>(), res);
        return res;
    }
    private void helper(String s, int idx, List<String> cur, List<List<String>> res){
        if(idx==s.length()){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i=idx;i<s.length();i++){
            String sub = s.substring(idx,i+1);
            if(isPalindorme(sub)){
                cur.add(sub);
                helper(s,i+1,cur,res);
                cur.remove(cur.size()-1);
            }
        }
    }
    private boolean isPalindorme(String s){
        int l=0,r=s.length()-1;
        while(l<r){
            if(s.charAt(l++)!=s.charAt(r--)) return false;
        }
        return true;
    }
}