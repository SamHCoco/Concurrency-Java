package concurrent;
import java.lang.Thread;

public class Main {

    public static void main(String[] args) {
		Countdown countdown = new Countdown();

		Thread thread1 = new Thread1(){
			@Override
			public void run(){
				countdown.begin();
			}
		};
		Thread thread2 = new Thread2(){
			@Override
			public void run(){
				countdown.begin();
			}
		};

		thread1.start();
		thread2.start();
	}
}

class Countdown {
	private int i = 10;

	// Counts down from 10 to 1, printing each value and the thread which printed it
	public synchronized void begin(){
		String threadName = Thread.currentThread().getName();
		String color = "";

		if(threadName.equals("THREAD-1")){
			color = Color.BLUE;
		} else if(threadName.equals("THREAD-2")){
			color = Color.PURPLE;
		}

		while(i > 0){
			System.out.println(color + threadName + ": i = " + i);
			i--;
		}
	}
}


