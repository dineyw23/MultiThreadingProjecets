import java.util.Scanner;

/**
 * Created by diney on 4/29/16.
 */


public class App {
    public static void main(String args[]){

        Processor proc1 = new Processor();

        proc1.start();
        System.out.println("Hit Enter!");

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        proc1.shutdown();


    }
}
