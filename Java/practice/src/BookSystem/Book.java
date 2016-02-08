package BookSystem; /**
 * Created by guangzhouzeng on 2/7/16.
 */

import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Book {
    public String author;
    public String title;
    private PriorityQueue<People> queue;
    public int rating;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
        queue = new PriorityQueue<>(new Comparator<People>(){
            @Override
            public int compare(People p1, People p2){
                return p1.priority == p2.priority ? p1.timestamp - p2.timestamp : p1.priority - p2.priority;
            }
        });
    }

    public Book(){
        author = new String();
        title = new String();
        queue = new PriorityQueue<>(new Comparator<People>(){
            @Override
            public int compare(People p1, People p2){
                return p1.priority == p2.priority ? p1.timestamp - p2.timestamp : p1.priority - p2.priority;
            }
        });
    }

    public void addPeopleInQueue(People p){
        queue.add(p);
    }

    public People getFirstPeopleFromQueue(){
        return queue.poll();
    }

    public void removePeopleInQueue(People people){
        queue.remove(people);
    }
}
