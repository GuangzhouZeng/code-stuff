package MyIteratorPattern.IteratorBuiltIn;

/**
 * Created by guangzhouzeng on 3/20/16.
 */
import java.util.Iterator;
public class MenuDinner implements Menu {
    private String[] menuItem;
    private int number = 0;
    private int maxNum = 4;

    public MenuDinner(){
        menuItem = new String[maxNum];
        addItem("DinnerCombo1");
        addItem("DinnerCombo2");
        addItem("DinnerCombo3");
        addItem("DinnerCombo4");
    }

    private void addItem(String item){
        if(number >= maxNum){
            System.out.println("The menu is full!");
            return;
        }
        menuItem[number++] = item;
    }

    public String[] getMenuItem(){
        return menuItem;
    }


    @Override
    public Iterator<String> getMenuIterator() {
        return new IteratorDinner(menuItem);
    }
}
