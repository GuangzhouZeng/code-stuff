package MyCompositePattern;

/**
 * Created by guangzhouzeng on 3/25/16.
 */
public class WaiterGiveMeTheMenu {
    public static void main(String[] args){
        Menu allMenus = new Menu("Hi Sir", "Here are all the menus for you: ");

        Menu breakfast = new Menu("KFC", "Breakfast");
        Menu lunch = new Menu("Panda", "lunch");
        Menu dinner = new Menu("Spicy city", "Dinner");

        allMenus.add(breakfast);
        allMenus.add(lunch);
        allMenus.add(dinner);

        MenuItem b1 = new MenuItem("b1", "breakfast1", true, 1.50);
        MenuItem b2 = new MenuItem("b2", "breakfast2", false, 2.50);
        breakfast.add(b1);
        breakfast.add(b2);

        MenuItem l1 = new MenuItem("l1", "lunch1", false, 12.00);
        MenuItem l2 = new MenuItem("l2", "lunch2", true, 5.00);
        MenuItem l3 = new MenuItem("l3", "lunch3", false, 6.00);
        lunch.add(l1);
        lunch.add(l2);
        lunch.add(l3);

        MenuItem d1 = new MenuItem("d1", "dinner1", false, 22.00);
        MenuItem d2 = new MenuItem("d2", "dinner2", true, 15.00);
        MenuItem d3 = new MenuItem("d3", "dinner3", true, 36.00);
        dinner.add(d1);
        dinner.add(d2);
        dinner.add(d3);

        Waiter David = new Waiter(allMenus);
        David.print();
    }
}
