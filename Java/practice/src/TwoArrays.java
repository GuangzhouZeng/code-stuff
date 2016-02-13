/**
 * Created by guangzhouzeng on 2/13/16.
 */
import PrintOut.PrintList;

import java.util.*;
//find Elements in A but not in B.
public class TwoArrays {
    public static List<Integer> findElem(int[] A, int[] B){
        HashSet<Integer> setB = new HashSet<>();
        for(int i: B){
            setB.add(i);
        }

        List<Integer> res = new ArrayList<>();
        for(int i: A){
            if(!setB.contains(i)){
                res.add(i);
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] A = {1,2,2,2,3,4,5,6,7,6,5,7,8};
        int[] B = {4,7,6,4,5,4};
        PrintList.printListInt(findElem(A,B));
    }
}
