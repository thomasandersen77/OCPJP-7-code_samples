package no.bouvet.cert.gau.chapter13.TheWaitNotifyMechanism;

/**
 * Created by gaute.lyngstad on 09.12.13.
 */
public class CoffeeShop {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Waiter waiter = new Waiter();
        coffeeMachine.start();
        waiter.start();

    }
}
