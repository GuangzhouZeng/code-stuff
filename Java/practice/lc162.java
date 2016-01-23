public class Solution {
    public int findPeakElement(int[] nums) {
	//use two mid: mid1 and mid2
        int l=0,h=nums.length-1;
        while(l<h){
            int m1 =(h-l)/2+l;
            int m2 = m1+1;
            if(nums[m1]>nums[m2]) h=m1;
            else l=m2;
        }
        return l;
    }
}