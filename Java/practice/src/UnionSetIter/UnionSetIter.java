package UnionSetIter; /**
 * Created by guangzhouzeng on 3/5/16.
 */
/*
Should notice: Should not print same value
 */
import java.util.HashSet;
import java.util.Iterator;

public class UnionSetIter {
    HashSet<Integer> set1;
    HashSet<Integer> set2;
    HashSet<Integer> set;

    Iterator it1;
    Iterator it2;
    Integer peek = null;

    public UnionSetIter(int[] arr1, int[] arr2){
        set1 = new HashSet<>();
        set2 = new HashSet<>();
        set = new HashSet<>();


        for(int i = 0; i < arr1.length || i < arr2.length; i++){
            if(i < arr1.length) set1.add(arr1[i]);
            if(i < arr2.length) set2.add(arr2[i]);
        }

        it1 = set1.iterator();
        it2 = set2.iterator();
    }

    public boolean hasNext(){
        if(!it1.hasNext() && !it2.hasNext()) return false;
        peek = next();
        return peek != null ? true : false;
    }

    public Integer next(){
        if(peek != null){
            Integer res = peek;
            peek = null;
            return res;
        }
        while(it1.hasNext() || it2.hasNext()) {
            Integer res = it1.hasNext() ? (Integer) it1.next() : (Integer) it2.next();
            if (!set.contains(res)){
                set.add(res);
                return res;
            }
        }
        return null;
    }

   /*
   set1: 1
   set2: 1
    */
}
