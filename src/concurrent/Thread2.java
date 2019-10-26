package concurrent;
import java.lang.Thread;

public class Thread2 extends Thread{
    private final static String threadName = "THREAD-2";

    public Thread2(){
        this.setName(threadName);
    }

    @Override
    public void run(){
        System.out.println("This message is from: " + this.getName());
    }
}
