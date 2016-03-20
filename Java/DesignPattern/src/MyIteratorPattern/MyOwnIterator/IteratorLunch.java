package MyIteratorPattern.MyOwnIterator;

/**
 * Created by guangzhouzeng on 3/20/16.
 */
import java.util.ArrayList;

//import java.util.Iterator;
public class IteratorLunch implements Iterator {
    private ArrayList<String> menuItem;
    private int pos;
    private int maxNum;

    public IteratorLunch(ArrayList<String> menuItem){
        this.menuItem = menuItem;
        pos = 0;
        maxNum = menuItem.size();
    }


    @Override
    public boolean hasNext(){
        return pos < maxNum;
    }

    @Override
    public Object next() {
        return hasNext() ? menuItem.get(pos++) : null;
    }
}
