package no.bouvet.cert.tan.chapter13.coffemachine;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 04.02.14
 * Time: 11:50
 * To change this template use File | Settings | File Templates.
 */
public class CoffeeMachine extends Thread {
    static String coffeeMade ="";
    static final Object lock = new Object();
    static int coffeeNumber  = 1;

    void makeCoffee(){
        synchronized (CoffeeMachine.lock) {
            if(coffeeMade != null){
                try {
                    System.out.println("Coffee machine: Waiting for waiter to deliver the coffe");
                    CoffeeMachine.lock.wait();
                } catch (InterruptedException e) {

                }
            }

            coffeeMade = "Coffee No: "  + (++coffeeNumber) + "";
            System.out.println("Coffee machine says: Made " + coffeeMade);
            CoffeeMachine.lock.notifyAll();
        }
    }

    @Override
    public void run() {
        while (true) {
            makeCoffee();
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) {

    }
}
