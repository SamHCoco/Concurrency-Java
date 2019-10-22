package concurrent;
import java.lang.Thread;

public class Main {

    public static void main(String[] args) {
    	System.out.println("This message is from: " + Thread.currentThread().getName().toUpperCase());
	    Thread thread1 = new Thread1();
	    Thread thread2 = new Thread2();
	    thread1.start();
	    thread2.start();
    }
}
