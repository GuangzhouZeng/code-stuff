package MyStatePattern;

/**
 * Created by guangzhouzeng on 3/19/16.
 */
public class GumballMachineTest {
    public static void main(String[] args){
        GumballMachine machine = new GumballMachine(3);
        System.out.println(machine);
        machine.ejectCoin();
        machine.turnCrank();

        System.out.println(machine);
        machine.insertCoin();
        machine.turnCrank();

        System.out.println(machine);
        machine.insertCoin();
        machine.ejectCoin();

        System.out.println(machine);
        machine.insertCoin();
        machine.turnCrank();

        System.out.println(machine);
        machine.insertCoin();
        machine.turnCrank();

        System.out.println(machine);

        machine.insertCoin();
        machine.insertCoin();
        machine.turnCrank();

        System.out.println(machine);

        machine.refill(2);
        machine.refill(1);
        System.out.println(machine);

    }
}
