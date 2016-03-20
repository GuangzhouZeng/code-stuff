package MyIteratorPattern.MyOwnIterator;

/**
 * Created by guangzhouzeng on 3/20/16.
 */

import java.util.ArrayList;

public class Cafe {
    public static void main(String[] args){
        //Dinner use Array
        System.out.println("Dinner Menu: -----------");
        MenuDinner dinner = new MenuDinner();

        //iterate without iterator
        String[] dinnerItems = dinner.getMenuItem();
        for(String menuItem: dinnerItems){
            System.out.print(menuItem + " ");
        }
        System.out.println();


        //iterate with iterator
        Iterator dinnerIterator = dinner.getMenuIterator();
        while(dinnerIterator.hasNext()){
            System.out.print(dinnerIterator.next() + " ");
        }
        System.out.println();


        //Lunch use ArrayList
        System.out.println("\nLunch Menu: -----------");
        MenuLunch lunch = new MenuLunch();

        //iterate without iterator
        ArrayList<String> lunchItems = lunch.getMenuItem();
        for(String lunchItem: lunchItems){
            System.out.print(lunchItem + " ");
        }
        System.out.println();

        //iterate with iterator
        Iterator lunchIterator = lunch.getMenuIterator();
        while(lunchIterator.hasNext()){
            System.out.print(lunchIterator.next() + " ");
        }
        System.out.println();
    }
}
