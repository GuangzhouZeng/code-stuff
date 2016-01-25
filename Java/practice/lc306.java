public class Solution {
    public boolean isAdditiveNumber(String num) {
        int n=num.length();
        for(int i=1;i<=(n-1)/2;i++){
            if(num.charAt(0)=='0'&&i>=2) break;
            for(int j=i+1;n-j>=j-i&&n-j>=i;j++){
                if(num.charAt(i)=='0'&&j-i>=2) break;
                String s1=num.substring(0,i);
                String s2=num.substring(i,j);
                Long i1 = Long.parseLong(s1);
                Long i2 = Long.parseLong(s2);
                String sub = num.substring(j);
                if(isAdditive(sub,i1,i2)) return true;
            }
        }
        return false;
    }
    private boolean isAdditive(String num, Long i1 , Long i2){
        if(num.equals("")) return true;
        Long i3 = i1+i2;
        String s3 = String.valueOf(i3);
        if(!num.startsWith(s3)) return false;
        return isAdditive(num.substring(s3.length()),i2,i3);
    }
}