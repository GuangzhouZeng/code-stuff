/**
 * Created by guangzhouzeng on 2/13/16.
 */
import java.util.*;
public class FindALocalMinimum {
    private static int getLocalMinimum(int[] arr){ //arr has no duplicates
        int l = 0, r = arr.length - 1;
        while(l < r){
            int m1 = (r - l) / 2 + l;
            int m2 = m1 + 1;
            if(arr[m1] < arr[m2]){
                r = m1;
            }else{
                l = m2;
            }
        }
        return arr[l];
        //7,6,5,4,3,2,1
    }

    private static int getMinWithDup(int[] arr){
        int index = getMinWithDupHelper(arr, 0, arr.length - 1);
        return arr[index];

    }

    static int index = 0;
    private static int getMinWithDupHelper(int[] arr, int begin, int end){
        int l = begin, r = end;
        while(l < r){
            int m1 = (r - l) / 2 + l;
            int m2 = m1 + 1;
            if(arr[m1] < arr[m2]){
                r = m1;
            }else if(arr[m1] > arr[m2]){
                l = m2;
            }else{
                int lIdx = getMinWithDupHelper(arr, begin, m1);
                int rIdx = getMinWithDupHelper(arr, m2, end);
                if(isMinimal(lIdx, arr)) {
                    index = lIdx;
                }
                if(isMinimal(rIdx, arr)){
                    index = rIdx;
                }
                return index;
            }
        }
        index = l;
        return l;
    }

    private static boolean isMinimal(int idx, int[] arr){
        int l = idx > 0 ? arr[idx - 1] : Integer.MAX_VALUE;
        int r = idx < arr.length - 1 ? arr[idx + 1] : Integer.MAX_VALUE;
        if(l > arr[idx] && arr[idx] < r) return true;
        return false;
    }
    public static void main(String[] args){
        int[] arr = {1,2,2,2,2,2,2,2,2};
        System.out.println(getLocalMinimum(arr));
        System.out.println(getMinWithDup(arr));
    }
}
