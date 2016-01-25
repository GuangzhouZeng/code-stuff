public class Solution {
    public int countDigitOne(int n) {
        /*if n = xyzdabc,
        *take 'd' into consideration:
        *(1) xyz * 1000                     if d == 0
        *(2) xyz * 1000 + abc + 1           if d == 1
        *(3) xyz * 1000 + 1000              if d > 1
        *Here in this program, m stores the part after 'd', and x store the current digit place
        *the part before 'd' can be get by using (n/10) in every digit.
        */
        
        int res=0;
        int m=0;
        int x=1;
        while(n>0){
            int digit = n%10;
            n/=10;
            res+=n*x; //the part before 'd'
            if(digit==1){
                res+=(m+1);
            }else if(digit>1){
                res+=x;
            }
            m=digit*x+m;
            x*=10;
            
        }
        return res;
    }
}