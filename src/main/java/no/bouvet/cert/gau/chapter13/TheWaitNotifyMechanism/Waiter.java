package no.bouvet.cert.gau.chapter13.TheWaitNotifyMechanism;

/**
 * Created by gaute.lyngstad on 09.12.13.
 */
public class Waiter extends Thread {
    public void getCoffee(){
        synchronized (CoffeeMachine.lock){
            if (CoffeeMachine.coffeeMade == null) {
                try{
                    // wait till the CoffeeMachine says (notifies) that
                    // coffee is ready
                    System.out.println("Waiter: Will get orders till coffee machine notifies me");
                    CoffeeMachine.lock.wait();
                } catch (InterruptedException e) {
                    // its okay to ignore this exception
                    // because we're not using thread interrupt mechanism
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Waiter: Delivering " + CoffeeMachine.coffeeMade);
        CoffeeMachine.coffeeMade = null;
        //ask (notify) the coffee machine to prepare the next coffee
        try {
            CoffeeMachine.lock.notifyAll();
        } catch (IllegalMonitorStateException  e) {
            // if the current thread is not the owner of this object's monitor.
            //This exception is getting thrown each time, since waiter is not the owner of CoffeeMachine
        }
        System.out.println("Waiter: Notifying coffee machine to make another one");
    }

    @Override
    public void run() {
        // keep going till the user presses ctrl-C and terminates the program
        while(true){
            getCoffee();
        }
    }
}
