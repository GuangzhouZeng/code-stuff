public class Solution {
    public boolean search(int[] nums, int target) {
        int l=0,h=nums.length-1;
        while(l<=h){
            int m =(h-l)/2+l;
            if(nums[m]==target) return true;
            if(nums[m]==nums[h]) h--; //so the worst case is O(n) time
            else if(nums[m]<nums[h]){
                if(nums[m]<target&&target<=nums[h]) l=m+1;
                else h=m-1;
            }else{
                if(nums[l]<=target&&target<nums[m]) h=m-1;
                else l=m+1;
            }
        }
        return false;
    }
}