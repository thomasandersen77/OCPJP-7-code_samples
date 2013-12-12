package no.bouvet.cert.gau.chapter13.TheWaitNotifyMechanism;

/**
 * Created by gaute.lyngstad on 09.12.13.
 */

// The CoffeeMachine class runs as an independent thread.
// Once the machine makes a coffee, it notifies the waiter to pick it up.
// When the waiter asks the coffee machine to make a coffee again,
// it starts all over again, and this process keeps going on ...
public class CoffeeMachine extends Thread {
    static String coffeeMade = null;
    static final Object lock = new Object();
    private static int coffeeNumber = 1;
    void makeCoffee(){
        synchronized (CoffeeMachine.lock){
            if(coffeeMade!=null){
                try {
                    System.out.println("Coffee machine: Waiting for waiter " +
                            "notification to deliver coffee");
                    CoffeeMachine.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            coffeeMade = "Coffee no. "+coffeeNumber ++;
            System.out.println("Coffee machine says: Made "+coffeeMade);
            //once coffee is ready, notify the waiter to pick it up
            CoffeeMachine.lock.notifyAll();
            System.out.println("Coffee machine: Notifying waiter to pick up the coffee ");
        }
    }

    @Override
    public void run() {
        while(true){
            makeCoffee();
            try {
                System.out.println("Coffee machine: making another coffee now");
                // simulate the time taken to make a coffee by calling sleep method
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                // it's okay to ignore this exception
                // since we're not using thread interrupt mechanism
                e.printStackTrace();
            }
        }
    }
}
