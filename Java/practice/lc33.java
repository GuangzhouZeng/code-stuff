public class Solution {
    public int search(int[] nums, int target) {
        int l=0,h=nums.length-1;
        while(l<h){ //here is the difference
            int m = (h-l)/2+l;
            if(nums[m]==target) return m;
            if(nums[m]<nums[h]){ //case1
                if(nums[m]<target&&target<=nums[h]){
                    l=m+1;
                }else{
                    h=m; //difference
                }
            }else{  //case2
                if(nums[l]<=target&&target<nums[m]){
                    h=m; //difference
                }else{
                    l=m+1;
                }
            }
        }
        return (nums[l]==target)?l:-1; // if use this way, we should alwasys consider the last case "l==h"
        
        /*int l=0,h=nums.length-1;
        while(l<=h){
            int m = (h-l)/2+l;
            if(nums[m]==target) return m;
            if(nums[m]<nums[h]){ //case1
                if(nums[m]<target&&target<=nums[h]){
                    l=m+1;
                }else{
                    h=m-1;
                }
            }else{  //case2
                if(nums[l]<=target&&target<nums[m]){
                    h=m-1;
                }else{
                    l=m+1;
                }
            }
        }
        return -1;*/
    }
}

//case1: 780[2]3456
//case2: 456[7]8023
