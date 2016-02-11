package Trie;

/**
 * Created by guangzhouzeng on 2/10/16.
 */
public class OverlapSegment {
    static class Interval{
        int start;
        int end;
        Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public static int findOverlap(Interval p, Interval q){
        if(p.start > q.start) return findOverlap(q, p);
        if(p.end <= q.start) return 0;
        return Math.min(p.end, q.end) - q.start;
    }
    public static void main(String[] args){
        Interval p = new Interval(11,20);
        Interval q = new Interval(4,10);
        System.out.println(findOverlap(p, q));
    }
}
