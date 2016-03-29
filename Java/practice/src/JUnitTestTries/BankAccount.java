package JUnitTestTries;

/**
 * Created by guangzhouzeng on 3/28/16.
 */
public class BankAccount {
    private int balance;

    public BankAccount(int money) {
        balance = money;
    }

    public BankAccount() {
        balance = 0;
    }


    public void deposit(int money) {
        balance += money;
    }

    public boolean withdraw(int money) {
        if(money > 1000){ //should withdraw less than 1000 each time
            return false;
        }

        balance -= money;
        if(balance < 0){
            balance -= 5;
        }
        return true;
    }

    public int getBalance() {
        return balance;
    }
}
