package MyIteratorPattern.IteratorBuiltIn;

/**
 * Created by guangzhouzeng on 3/20/16.
 */
import java.util.Iterator;
public class IteratorDinner implements Iterator<String>{
    private String[] MenuItem;
    private int pos;
    private int maxNum;

    public IteratorDinner(String[] MenuItem){
        this.MenuItem = MenuItem;
        this.maxNum = MenuItem.length;
        this.pos = 0;
    }

    @Override
    public boolean hasNext() {
        return pos < maxNum;
    }

    @Override
    public String next() {
        return hasNext() ? MenuItem[pos++] : null;
    }
}
