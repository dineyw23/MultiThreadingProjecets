import java.util.Scanner;

/**
 * Created by diney on 5/1/16.
 */
public class Processor {



    public void produce() throws InterruptedException{

        synchronized (this){
            System.out.println("Producer thread is running....");
            wait();
            System.out.println("Resumesd");

        }


    }


    public void consume() throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);

        synchronized (this){
            System.out.println("Waiting for return key");
            scanner.nextLine();
            System.out.println("Pressed return key");
            notify();
        }

    }

}
