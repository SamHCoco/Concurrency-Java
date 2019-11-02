package concurrent.prodconsume;
/* The following example is from Tim Buchalka's Java Programming Masterclass for Software Developers on Udemy */

public class Message {
    private String message;
    private boolean empty = true;

    public synchronized String read(){
        while(empty){

        }
        empty = true;
        return message;
    }

    public synchronized void write(String message){
        while(!empty){

        }
        empty = false;
        this.message = message;
    }
}
