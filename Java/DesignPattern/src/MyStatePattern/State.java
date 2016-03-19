package MyStatePattern;

/**
 * Created by guangzhouzeng on 3/19/16.
 */
public interface State {
    public void insertCoin();
    public void ejectCoin();
    public void turnCrank();
    public void dispense();
}
