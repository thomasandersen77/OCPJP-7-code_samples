package no.bouvet.cert.tan.chapter13.coffemachine;

import no.bouvet.cert.gau.chapter13.TheWaitNotifyMechanism.CoffeeMachine;

public class CoffeeShop {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Waiter waiter = new Waiter();
        coffeeMachine.start();
        waiter.start();

    }
}
