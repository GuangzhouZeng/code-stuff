package RandomHashMap;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by guangzhouzeng on 2/9/16.
 */
public class RandomHashMap<K, V> {
    HashMap<K, V> map;
    List<K> keys;
    public RandomHashMap(){
        map = new HashMap<>();
        keys = new ArrayList<>();
    }

    //insert
    public void insertIntoMap(K key, V val){
        map.put(key, val);
        keys.add(key);
    }

    //delete
    public void removeFromMap(K key){
        map.remove(key);
        keys.remove(key);
    }

    //get
    public V getFromMap(K key){
        return map.get(key);
    }

    private int getRandomIndex(int min, int max){
        Random rd = new Random();
        //return Math.abs(rd.nextInt()) % (max - min);
        return rd.nextInt(max - min) + min;
    }

    //random get
    public V randomGetFromMap(){
        int index = getRandomIndex(0, keys.size());
        K key = keys.get(index);
        return map.get(key);
    }

    //print map
    public void printMap(){
        System.out.print("PrintMap: ");
        for(K key: map.keySet()){
            System.out.print(map.get(key) + " ");
        }
        System.out.println();
    }



    //print list
    public void printList(){
        System.out.print("PrintList: ");
        for(K key: keys){
            System.out.print(key + " ");
        }
        System.out.println();
    }


}
