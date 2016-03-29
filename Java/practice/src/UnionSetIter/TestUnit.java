package UnionSetIter;

/**
 * Created by guangzhouzeng on 3/5/16.
 */
public class TestUnit {
    public static void main(String[] args){
        int[] arr1 = {1,2};
        int[] arr2 = {1,2};
        UnionSetIter it = new UnionSetIter(arr1, arr2);
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
