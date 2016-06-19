/**
 * Created by diney on 5/1/16.
 */
public class App {

    public static void main(String args[]) throws InterruptedException{

        final Runner runner = new Runner();


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runner.first();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runner.second();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        runner.finished();
    }
}
