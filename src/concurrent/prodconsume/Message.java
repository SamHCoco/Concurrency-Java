package concurrent.prodconsume;
/* The following example is from Tim Buchalka's Java Programming Masterclass for Software Developers on Udemy */

import java.util.Random;

public class Message {

    private String message;
    private boolean empty = true;

    public static void main(String[] args){
        Message message  = new Message();

        Thread writer = new Thread(new Writer(message));
        Thread reader = new Thread(new Reader(message));

        writer.start();
        reader.start();
    }

    public synchronized String read(){
        while(empty){
            try {
                wait();
            }catch(InterruptedException e){
                System.out.println("MESSAGE OBJECT READ ERROR: " + e.getMessage());
            }
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message){
        while(!empty){
            try {
                wait();
            }catch(InterruptedException e){
                System.out.println("MESSAGE OBJECT WRITE ERROR: " + e.getMessage());
            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}

/**************************************** WRITER CLASS *************************************** */

class Writer implements Runnable {

    private Message message;

    public Writer(Message message){
        this.message = message;
    }

    @Override
    public void run(){
        String[] messageData = {"message 1", "message 2", "message 3", "message 4"};
        Random random = new Random();

        for(int i = 0; i < messageData.length; i++){
            message.write(messageData[i]);
            try {
                Thread.sleep(random.nextInt(2000));
            }catch(InterruptedException e){
                System.out.println("WRITER ERROR: " + e.getMessage());
            }
        }
        message.write("finished");
    }
}

/**************************************** READER CLASS *************************************** */

class Reader implements Runnable {

    private Message message;

    public Reader(Message message){
        this.message = message;
    }

    @Override
    public void run(){
        Random random = new Random();
        for(String message = this.message.read(); !message.equals("finished"); message = this.message.read()){
            System.out.println(message);
            try {
                Thread.sleep(random.nextInt(2000));
            }catch(InterruptedException e){
                System.out.println("READER ERROR: " + e.getMessage());
            }
        }
    }
}