package MyStatePattern;

/**
 * Created by guangzhouzeng on 3/19/16.
 */
public class SoldOutState implements State {
    private GumballMachine machine;
    public SoldOutState(GumballMachine m){
        machine = m;
    }

    @Override
    public void insertCoin() {
        ejectCoin();
    }

    @Override
    public void ejectCoin() {
        System.out.println("The gumball is sold out");
    }

    @Override
    public void turnCrank() {
        System.out.println("The gumball is sold out");
    }

    @Override
    public void dispense() {
        System.out.println("The gumball is sold out");
    }

    @Override
    public String toString() {
        return "Sold Out!";
    }
}
