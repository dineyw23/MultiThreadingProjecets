import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;

/**
 * Created by diney on 5/1/16.
 */
public class Connection {

    private static Connection instance = new Connection();
    private int connections = 0;
    private Semaphore sem = new Semaphore(10,true);

    private Connection(){


    }

    public static Connection getInstance(){
        return instance;
    }

    public void connect(){
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            doConnect();
        }finally {
            sem.release();
        }
    }
    public void doConnect(){



        synchronized (this){
            connections++;
            System.out.println("Current connection :" + connections);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this){
            connections--;
        }


    }
}
