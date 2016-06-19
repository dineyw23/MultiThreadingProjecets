import java.util.concurrent.CountDownLatch;

/**
 * Created by diney on 5/1/16.
 */
public class Processor implements Runnable {

    private CountDownLatch latch;

    public Processor(CountDownLatch latch){

        this.latch = latch;
    }

    public void run()   {

        System.out.println("Started.. :");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        latch.countDown();

    }
}
