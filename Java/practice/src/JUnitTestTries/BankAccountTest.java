package JUnitTestTries;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by guangzhouzeng on 3/28/16.
 */
public class BankAccountTest {
    @BeforeClass
    public static void setupBeforeClass() throws Exception{
        //can do some initialize thing at the beginning of the class
    }

    @AfterClass
    public static void teardownAfterClass() throws Exception{

    }
    @Before
    public void setup() throws Exception{
        //can do some initialize thing at the beginning of each test cases
    }

    @After
    public void teardown() throws Exception{

    }

    @Test
    public void testDeposit(){
        //test deposit
        BankAccount account = new BankAccount();
        account.deposit(50);
        assertEquals(account.getBalance(), 50);
        account.deposit(30);
        assertEquals(account.getBalance(), 80);
    }

    @Test
    public void testWithdraw(){
        //test deposit
        BankAccount account = new BankAccount(75);
        assertFalse(account.withdraw(10000));
        assertEquals(account.getBalance(), 75);

        assertTrue(account.withdraw(40));
        assertEquals(account.getBalance(), 35);
    }

    @Test
    public void testWithdrawWithPenalty(){
        //test deposit
        BankAccount account = new BankAccount(20);
        account.withdraw(30);
        assertEquals(account.getBalance(), -15);
    }


}
