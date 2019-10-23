# Concurrency in Java: Overview
### Aim:
This repository is intend to outline the key concepts of concurrency in Java and provide reference materials that may act as a refresher on the topic of concurrency/threads in Java.
### Introduction
Concurrency in programming is the ability of a computer to execute 2 or more tasks at the same time. More accurately, the tasks are executed one at a time but done in such a way as to give the appearance of being executed in parallel (at the same time).

For example, consider an application designed to do the following:
- Download data
- Draw a shape on the monitor using the data

Without concurrency, this application would first download all the data then draw the shape once all the required data had finished downloading.

A concurrent implementation of this application however could download some data, draw a pixel on the screen, download some more data then draw another pixel etc and by repeating this process it appears to the user that the program is executing both tasks at the same time.

Concurrency allows:
- Multiple apps to run at the same time on a smartphone
- Website servers to process the requests of simultaneous users
- Multiple applications to run at the same time on a computer
- GUI based programs to perform background tasks that do not interrupt user experience

##### Concurrency Terms Defined
- **Process:** A process is a unit of execution that has its own memory space, called a ***heap***, which cannot be accessed by any other process. A heap can only be accessed by the unique process associated with it. When a Java console application is run, a process is kicked off. When we start a GUI application on a computer, a process is kicked off. A process is made up of threads and all processes always have at minimum of one thread, in Java called the "main" thread.

- **Thread:** A thread is a unit of execution within a process that, similarly to a process, has its own memory space called a ***thread stack***. All threads created by a process have access to that processes' heap (memory and files). A single process can have multiple threads.

### Using Threads in Java
Java provides the *java.lang.Thread* class or *java.lang.Runnable* interface for working with threads.
```Java
import java.lang.Thread;
import java.lang.Runnable;
```
#### Creating Threads
There are 2 approaches of creating new threads in Java, outlined below:
1. ) A new thread may be created by creating a class that inherits from the *Thread* class and overriding the *run()* method. The code to be executed in a new thread is placed inside the *run()* method.

```java
import java.lang.Thread;

public class Thread1 extends Thread {
    private final static String threadName = "THREAD-1";

    @Override
    public void run(){
        this.setName(threadName);
        System.out.println("This message is from: " + this.getName());
    }
}
```
2. ) New threads may also be created by creating a class that implements the *Runnable* interface provided by *java.lang.Runnable* and implementing the *run()* method of the interface, placing the code to be executed by the new thread inside the *run()* method.

```Java
import java.lang.Runnable;

public class RunnableThread implements Runnable {
    private static final String threadName = "RUNNABLE-THREAD";

    public void run(){
        System.out.println("This message is from: " + threadName);
    }
}
```
#### Running Threads
- To run a thread created through approach *1)*, we instantiate a *Thread* object, here *thread1* and *thread2*, then call the Thread objects' *start()* methods from the *'main'* thread:

```Java
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
```
*Note: 'Thread2' class available in source code*.
##### Output:
![](RunningThreadDemo.png)
- To run a thread created through approach *2)*, a *Thread* object is instantiated along with an instance of our implemented *Runnable* class, which is passed as an argument to the constructor of the *Thread* object. The thread is ran by calling the *start()* method of the *Thread* object.

```Java
import java.lang.Thread;

public class Main {

    public static void main(String[] args) {
    	System.out.println("This message is from: " + Thread.currentThread().getName().toUpperCase());

    	Thread runnableThread = new Thread(new RunnableThread());
	    runnableThread.start();
    }
}
```
##### Output:
![](RunningThreadDemo2.png)
