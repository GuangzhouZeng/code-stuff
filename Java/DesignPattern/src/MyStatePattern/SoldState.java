package MyStatePattern;

/**
 * Created by guangzhouzeng on 3/19/16.
 */
public class SoldState implements State{
    private GumballMachine machine;

    public SoldState(GumballMachine m){
        machine = m;
    }

    @Override
    public void insertCoin() {
        System.out.println("Waiting for dispense...");

    }

    @Override
    public void ejectCoin() {
        System.out.println("You have turned the crank. Waiting for dispense...");
    }

    @Override
    public void turnCrank() {
        System.out.println("You have turned the crank. Waiting for dispense...");

    }

    @Override
    public void dispense() {
        machine.setCount(machine.getCount() - 1);
        System.out.println("Success! One gumball is out!");
        System.out.println("Current gumball is " + machine.getCount());
        if(machine.getCount() == 0){
            machine.setCurState(machine.getSoldOutState());
        }else{
            machine.setCurState(machine.getNoCoinState());
        }
    }

    @Override
    public String toString() {
        return "Waiting for dispensing...\n";
    }
}
