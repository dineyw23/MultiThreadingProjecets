import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

/**
 * Created by diney on 5/1/16.
 */
public class Runner {

    private Account acc1 = new Account();
    private Account acc2 = new Account();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public void acquireLocks(Lock firstLock, Lock secondLock)throws InterruptedException{

        while (true){
            //Acquire locks
                boolean got1 = false;
                boolean got2 = false;

            try {
                got1 = firstLock.tryLock();
                got2 = secondLock.tryLock();
            } finally {

                if(got1 && got2)
                    return;

                if(got1)
                    firstLock.unlock();

                if(got2)
                    secondLock.unlock();
            }


            //If not acquired
            Thread.sleep(1);

        }


    }
    public void first() throws InterruptedException{

        Random random = new Random();

        for(int i = 0; i < 10000; i++){

            acquireLocks(lock1,lock2);

            try {
                Account.Transfer(acc1,acc2,random.nextInt(100));
            }finally {
                lock1.unlock();
                lock2.unlock();
            }

        }
    }

    public void second() throws InterruptedException{

        Random random = new Random();

        for(int i = 0; i < 10000; i++){

            acquireLocks(lock1,lock2);

            try {
                Account.Transfer(acc2,acc1,random.nextInt(100));
            }finally {
                lock1.unlock();
                lock2.unlock();
            }

        }
    }

    public void finished() throws InterruptedException{

        System.out.println("Account 1 balance : " + acc1.getBalance());
        System.out.println("Account 2 balance : " + acc2.getBalance());
        System.out.println("Total : " + (acc1.getBalance() + acc2.getBalance()));
    }
}
