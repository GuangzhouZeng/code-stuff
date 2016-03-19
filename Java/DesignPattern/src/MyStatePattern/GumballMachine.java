package MyStatePattern;

/**
 * Created by guangzhouzeng on 3/19/16.
 */
public class GumballMachine {
    private State noCoinState;
    private State hasCoinState;
    private State soldState;
    private State soldOutState;

    private State curState = soldOutState;

    private int count = 0;

    public GumballMachine(int count){
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);
        refill(count);
    }

    public void insertCoin(){
        curState.insertCoin();
    }

    public void ejectCoin(){
        curState.ejectCoin();
    }

    public void turnCrank(){
        curState.turnCrank();
        curState.dispense();
    }

    public void refill(int count){
        curState = noCoinState;
        this.count += count;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("\nBegin:\n");
        result.append("Current state: " + curState.toString() + "\n");
        result.append("Current gumball: " + getCount() + "\n");
        return result.toString();
    }

    /*************getter and setter*******************/
    public int getCount(){
        return count;
    }
    public void setCount(int cnt){
        this.count = cnt;
    }

    public State getNoCoinState() {
        return noCoinState;
    }

    public State getHasCoinState() {
        return hasCoinState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getCurState() {
        return curState;
    }

    public void setCurState(State curState) {
        this.curState = curState;
    }
}
