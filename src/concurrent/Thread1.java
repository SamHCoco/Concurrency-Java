package concurrent;
import java.lang.Thread;

public class Thread1 extends Thread {
    private final static String threadName = "THREAD-1";

    public Thread1(){
        this.setName(threadName);
    }

    @Override
    public void run(){
        System.out.println("This message is from: " + this.getName());
    }
}
