package RandomHashMap;

/**
 * Created by guangzhouzeng on 2/9/16.
 */
import java.util.concurrent.ThreadLocalRandom;
public class Main {
    public static void main(String[] args){
        RandomHashMap<Integer, String> map = new RandomHashMap();
        map.insertIntoMap(1,"Tom");
        map.insertIntoMap(2,"Jerry");
        map.insertIntoMap(3,"Jason");
        map.insertIntoMap(4,"Jean");
        map.insertIntoMap(5,"Alen");

        map.printMap();
        map.printList();


        System.out.println("Get key=3: " + map.getFromMap(3));


        System.out.println("Random Get: " + map.randomGetFromMap());


        map.removeFromMap(3);
        map.removeFromMap(4);
        map.removeFromMap(1);

        System.out.println("Random Get: " + map.randomGetFromMap());
        System.out.println("here: " + map.getFromMap(5));

        map.printMap();
        map.printList();

        System.out.println("---------------------random improve------------------------");

        RandomHashMapImprove<Integer, String> map2 = new RandomHashMapImprove();
        map2.insertIntoMap(1,"Tom");
        map2.insertIntoMap(2,"Jerry");
        map2.insertIntoMap(3,"Jason");
        map2.insertIntoMap(4,"Jean");
        map2.insertIntoMap(5,"Alen");

        map2.printMap();
        map2.printList();



        System.out.println("Get key=3: " + map2.getFromMap(3));


        System.out.println("Random Get: " + map2.getRandomFromMap());


        map2.removeFromMap(3);
        map2.removeFromMap(4);
        map2.removeFromMap(1);

        System.out.println("Random Get: " + map2.getRandomFromMap());
        System.out.println("here: " + map2.getFromMap(2));

        map2.printMap();
        map2.printList();

    }

}
