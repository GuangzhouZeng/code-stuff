package RandomHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by guangzhouzeng on 2/9/16.
 * This is wrong answer, I haven't solve how to change the key-value pair
 * when I want to place the last elements at the place where I delete an
 * element. The map's information should update also. So this answer doesn't
 * do any improvements.
 * Solved: add Node class, this class can store the key, so whenever we want
 * to modify the map, we use the key stored in this class.
 */
public class RandomHashMapImprove<K, V> {
    class Node{
        K key;
        V value;
        Node(K key, V  value){
            this.key = key;
            this.value = value;
        }
    }

    HashMap<K, Integer> map; //<Key, index>
    List<Node> list; //<index, value>

    public RandomHashMapImprove(){
        map = new HashMap();
        list = new ArrayList<>();
    }

    public void insertIntoMap(K key, V value){
        map.put(key, list.size());
        list.add(new Node(key, value));
    }

    public void swap(int i, int j){
        Node first = list.get(i);
        Node second = list.get(j);
        list.set(i, second);
        list.set(j, first);
    }

    public void removeFromMap(K key){
        if(map.size() == 0) return;
        int pos = map.get(key); //get the index of the element we want to delete.
        int lastPos = list.size() - 1; // get the last node's position
        Node lastNode = list.get(lastPos); // get the last node

        swap(pos, lastPos); //swap the lastnode to the position we want to delete a node there
        map.put(lastNode.key, pos); // map update the lastnode's position.

        map.remove(key); //map remove the current last node, the node we want to delete
        list.remove(lastPos); //list remove the current last node.
    }

    public V getFromMap(K key){
        return list.get(map.get(key)).value;
    }

    public V getRandomFromMap(){
        return list.get((int)(Math.random() * list.size())).value;
    }

    //print map
    public void printMap(){
        System.out.print("PrintMap: ");
        for(K key: map.keySet()){
            System.out.print("(" + key + ", " +map.get(key) + ") ");
        }
        System.out.println();
    }

    //print list
    public void printList(){
        System.out.print("PrintList: ");
        for(Node node: list){
            System.out.print("("+node.key + ", " + node.value + ") ");
        }
        System.out.println();
    }

}
