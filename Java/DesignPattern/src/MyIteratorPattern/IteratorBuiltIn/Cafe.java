package MyIteratorPattern.IteratorBuiltIn;

/**
 * Created by guangzhouzeng on 3/20/16.
 */

import java.util.Iterator;
public class Cafe {
    public static void main(String[] args){
        //Dinner use Array
        System.out.println("Dinner Menu: -----------");
        MenuDinner dinner = new MenuDinner();
        Iterator<String> dinnerIterator = dinner.getMenuIterator();
        printItems(dinnerIterator);


        //Lunch use ArrayList
        System.out.println("\nLunch Menu: -----------");
        MenuLunch lunch = new MenuLunch();
        Iterator<String> lunchIterator = lunch.getMenuIterator();
        printItems(lunchIterator);
    }

    public static void printItems(Iterator<String> it){
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}
