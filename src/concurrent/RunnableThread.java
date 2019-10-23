package concurrent;

import java.lang.Runnable;

public class RunnableThread implements Runnable {

    private static final String threadName = "RUNNABLE-THREAD";

    @Override
    public void run(){
        System.out.println("This message is from: " + threadName);
    }
}
