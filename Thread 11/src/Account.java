/**
 * Created by diney on 5/1/16.
 */
public class Account {

    private int balance = 10000;

    public void deposit(int amount){
        balance += amount;

    }

    public void withdraw(int amount){
        balance -= amount;

    }

    public int getBalance(){
        return balance;
    }

    public static void Transfer(Account acc1, Account acc2, int amount){
        acc1.withdraw(amount);
        acc2.deposit(amount);
    }


}
