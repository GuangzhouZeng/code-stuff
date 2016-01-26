public class Solution {
    public List<String> restoreIpAddresses(String s) {
        //recursive
        List<String> res = new ArrayList<>();
        restore(s,0,0,"",res);
        return res;
    }
    private void restore(String s, int idx, int count, String cur, List<String> res){
        if(count>4) return;
        if(count==4&&idx==s.length()){
            res.add(cur.substring(0,cur.length()-1));
            return;
        }
        for(int i=idx+1;i<=s.length()&&i<idx+4;i++){
            String sub=s.substring(idx,i);
            int val = Integer.parseInt(sub);
            if(val>255||(sub.length()>1&&sub.charAt(0)=='0')) break;
            restore(s,i,count+1,cur+sub+".",res);
        }
    }
    
        
        
        /*//iterative solution
        int n=s.length();
        List<String> res = new ArrayList<>();
        for(int i=1;i<n&&i<4;i++){
            String s1 = s.substring(0,i);
            if(s1.length()>1&&s1.charAt(0)=='0') continue;
            if(Integer.valueOf(s1)>255) break;
            for(int j=i+1;j<n&&j<i+4;j++){
                String s2 = s.substring(i,j);
                if(s2.length()>1&&s2.charAt(0)=='0') continue;
                if(Integer.valueOf(s2)>255) break;
                for(int k=j+1;k<n&&k<j+4;k++){
                    String s3 = s.substring(j,k);
                    String s4 = s.substring(k);
                    
                    if(Integer.valueOf(s3)>255) break;
                    if((s3.length()>1&&s3.charAt(0)=='0')||(s4.length()>1&&s4.charAt(0)=='0')) continue;
                    
                    if(s4.length()<4&&Integer.valueOf(s4)<=255){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }*/
}