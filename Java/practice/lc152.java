public class Solution {
    public int maxProduct(int[] nums) {
        //O(n) time and O(1) space
        int n=nums.length;
        if(n==0) return 0;
        
        int premax=nums[0];
        int premin=nums[0];
        
        int res=nums[0];
        int curmax, curmin;
        
        for(int i=1;i<nums.length;i++){
            curmax=Math.max(premax*nums[i],Math.max(nums[i],premin*nums[i]));
            curmin=Math.min(premin*nums[i],Math.min(nums[i],premax*nums[i]));
            res=Math.max(res, curmax);
            premax=curmax;
            premin=curmin;
        }
        return res;
        
        //O(n) time and O(n) space
        /*int n=nums.length;
        if(n==0) return 0;
        
        int[] dpmax = new int[n];
        int[] dpmin = new int[n];
        
        dpmax[0]=nums[0];
        dpmin[0]=nums[0];
        
        int res=dpmax[0];
        
        for(int i=1;i<nums.length;i++){
            dpmax[i]=Math.max(dpmax[i-1]*nums[i],Math.max(nums[i],dpmin[i-1]*nums[i]));
            dpmin[i]=Math.min(dpmin[i-1]*nums[i],Math.min(nums[i],dpmax[i-1]*nums[i]));
            res=Math.max(res, dpmax[i]);
        }
        return res;*/
    }
}