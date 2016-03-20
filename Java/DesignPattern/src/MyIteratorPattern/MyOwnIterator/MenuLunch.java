package MyIteratorPattern.MyOwnIterator;

/**
 * Created by guangzhouzeng on 3/20/16.
 */
import java.util.ArrayList;

public class MenuLunch implements Menu{
    private ArrayList<String> menuItem;

    public MenuLunch(){
        menuItem = new ArrayList<>();
        menuItem.add("LunchCombo1");
        menuItem.add("LunchCombo2");
        menuItem.add("LunchCombo3");
        menuItem.add("LunchCombo4");
        menuItem.add("LunchCombo5");
    }

    public ArrayList<String> getMenuItem(){
        return menuItem;
    }

    @Override
    public Iterator getMenuIterator() {
        return new IteratorLunch(menuItem);
    }
}
