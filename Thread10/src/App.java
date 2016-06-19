/**
 * Created by diney on 5/1/16.
 */
public class App {


    public static void main(String args[]) throws Exception{

        final Runner runner = new Runner();


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runner.firstThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runner.secondThread();
                } catch (InterruptedException e) {


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
