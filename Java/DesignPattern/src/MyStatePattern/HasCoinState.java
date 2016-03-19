package MyStatePattern;

/**
 * Created by guangzhouzeng on 3/19/16.
 */
public class HasCoinState implements State {
    private GumballMachine machine;

    public HasCoinState(GumballMachine m){
        machine = m;
    }

    @Override
    public void insertCoin() {
        System.out.println("There is already a coin, waiting for turn the crank...");
    }

    @Override
    public void ejectCoin() {
        machine.setCurState(machine.getNoCoinState());
        System.out.println("Eject the coin, waiting for inserting a coin...");
    }

    @Override
    public void turnCrank() {
        machine.setCurState(machine.getSoldState());
        System.out.println("You turned the crank, waiting for dispense...");
    }

    @Override
    public void dispense() {
        System.out.println("Please turn the crank first...");
    }

    @Override
    public String toString() {
        return "Waiting for turning the crank...";
    }
}
