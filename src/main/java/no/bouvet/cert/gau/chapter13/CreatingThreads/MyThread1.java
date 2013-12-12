package no.bouvet.cert.gau.chapter13.CreatingThreads;

/**
 * Created by gaute.lyngstad on 09.12.13.
 */
public class MyThread1 extends Thread {
    @Override
    public void run() {
        try{
            sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("In run method; thread name is: " + getName());
    }


    public static void main(String[] args) {
        MyThread1 myThread = new MyThread1();
        myThread.start();

        //main method is static, and don't have access to this.
        // Therefore you call Thread.currentThread().getName();, not this.getName();
        // See extra() method for example of no static method!
        System.out.println("In main method; thread name is: "+
            Thread.currentThread().getName());
    }
    public void extra(){
        //java.lang.Thread
        this.getName();
    }
}
