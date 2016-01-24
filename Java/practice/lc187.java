public class Solution {
    public static int[] chars=new int[26];
    static{
        chars['A'-'A']=0;
        chars['C'-'A']=1;
        chars['G'-'A']=2;
        chars['T'-'A']=3;
    }
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        for(int i=0;i<s.length()-9;i++){
            String str = s.substring(i,i+10);
            int key = toInt(str);
            if(set.contains(key)){
                res.add(str);
            }else{
                set.add(key);
            }
        }
        return new ArrayList(res);
    }
    private int toInt(String s){
        int res=0;
        for(char c: s.toCharArray()){
            res<<=2;
            res+=(chars[c-'A']);
        }
        return res;
    }
    
}