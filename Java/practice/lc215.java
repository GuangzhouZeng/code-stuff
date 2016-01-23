public class Solution {
    public int findKthLargest(int[] nums, int k) {
        //method2
        int l=0, r=nums.length-1;
        while(true){
            int pos = partition(nums,l,r);
            if(pos==k-1) return nums[pos];
            else if(pos<k-1) l=pos+1;
            else r=pos-1;
        }
    }
    
    private int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        int l=left+1, r=right;
        while(l<=r){
            if(nums[l]<pivot&&nums[r]>pivot) swap(nums, l++, r--);
            if(nums[l]>=pivot) l++;
            if(nums[r]<=pivot) r--;
        }
        swap(nums, r, left);
        return r;
    }
    
    private void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
        
        //method1 O(k) space and O(nlogk) time
       /*PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num:nums){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }*/
}