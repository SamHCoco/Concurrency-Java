package concurrent;
import java.lang.Thread;

public class Thread1 extends Thread {
    private final static String threadName = "THREAD-1";

    @Override
    public void run(){
        this.setName(threadName);
        System.out.println("This message is from: " + this.getName());
    }
}
