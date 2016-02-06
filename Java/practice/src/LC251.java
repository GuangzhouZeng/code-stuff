/**
 * Created by guangzhouzeng on 2/6/16.
 */
/*
Problem:

Implement an iterator to flatten a 2d vector.

For example,

Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
 */
import java.util.*;
public class LC251 {
    static class Vector2D {
        LinkedList<Integer> element;
        public Vector2D(List<List<Integer>> vec2d) {
            element = new LinkedList<>();
            for(List<Integer> vec1d: vec2d) {
                element.addAll(vec1d);
            }
        }

        public int next() {
            if(!element.isEmpty()){
                return element.poll();
            }
            return -1;
        }

        public boolean hasNext() {
            return !element.isEmpty();
        }
    }


    public static void main(String[] agrs){
        List<List<Integer>> vec2d = new ArrayList<>();
        List<Integer> row1 = Arrays.asList(1,2);
        List<Integer> row2 = Arrays.asList(3);
        List<Integer> row3 = Arrays.asList(4,5,6);
        vec2d.add(row1);
        vec2d.add(row2);
        vec2d.add(row3);

        Vector2D i = new Vector2D(vec2d);
        while(i.hasNext()){
            System.out.print(i.next()+" ");
        }
    }

}


