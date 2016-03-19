package MyStatePattern;

/**
 * Created by guangzhouzeng on 3/19/16.
 */
public class NoCoinState implements State{
    private GumballMachine machine;
    public NoCoinState(GumballMachine m){
        machine = m;
    }

    @Override
    public void insertCoin() {
        machine.setCurState(machine.getHasCoinState());
        System.out.println("You have insert a coin, waiting for turn the crank...");
    }

    @Override
    public void ejectCoin() {
        System.out.println("No coin to eject!");
    }

    @Override
    public void turnCrank() {
        System.out.println("Please insert coin first!");
    }

    @Override
    public void dispense() {
        System.out.println("Please insert coin first!");
    }

    @Override
    public String toString() {
        return "Waiting for coin...";
    }
}
