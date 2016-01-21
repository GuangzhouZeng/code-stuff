public class Solution {
    public int maxProfit(int[] prices) {
        /*
        s0->buy->s1, s1->sell->s2, s2->rest->s0, s0->rest->s0,s1->rest->s1;
        s0[i]=max(s0[i-1],s2[i-1]);
        s1[i]=max(s1[i-1],s0[i-1]-prices[i]);
        s2[i]=s1[i-1]+prices[i];
        */
        int n = prices.length;
        if(n==0) return 0;
        int[] s0 = new int[n];
        int[] s1 = new int[n];
        int[] s2 = new int[n];
        s0[0]=0;
        s1[0]=-prices[0];
        s2[0]=Integer.MIN_VALUE;
        
        for(int i=1;i<n;i++){
            s0[i]=Math.max(s0[i-1],s2[i-1]);
            s1[i]=Math.max(s1[i-1],s0[i-1]-prices[i]);
            s2[i]=s1[i-1]+prices[i];
        }
        return Math.max(s0[n-1],s2[n-1]);
    }
}