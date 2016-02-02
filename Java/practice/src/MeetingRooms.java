/**
 * Created by guangzhouzeng on 2/2/16.
 */

/**
 * Problem Description:

 Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

 For example,
 Given [[0, 30],[5, 10],[15, 20]],
 return false.
 */

import java.util.Arrays;
import java.util.Comparator;
//Definition for an interval.
public class MeetingRooms {
    static class Interval{
        int start;
        int end;
        Interval(){
            start = 0;
            end = 0;
        }
        Interval(int s, int e){
            start = s;
            end = e;
        }
    }

    public static boolean soultion(Interval[] intervals){
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });

        for(int i = 0; i < intervals.length-1; i++){
            if(intervals[i].end > intervals[i+1].start) return false;
        }

        return true;
    }

    private static Interval[] constructInterval(int[][] arrs){
        Interval[] intervals = new Interval[arrs.length];
        int idx = 0;
        for(int[] arr: arrs){
            intervals[idx++] = new Interval(arr[0], arr[1]);
        }
        return intervals;
    }

    public static void main(String[] args){
        int[][] arrs = {{0, 30},{5, 10},{15, 20}};
        Interval[] intervals = constructInterval(arrs);
        System.out.println(soultion(intervals));
    }
}
