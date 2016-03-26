package MyCompositePattern;

/**
 * Created by guangzhouzeng on 3/25/16.
 */
public class Waiter {
    private MenuComponent menu;
    public Waiter(MenuComponent menu){
        this.menu = menu;
    }
    public void print(){
        menu.print();
    }

}
