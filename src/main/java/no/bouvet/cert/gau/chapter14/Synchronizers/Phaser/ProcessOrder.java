package no.bouvet.cert.gau.chapter14.Synchronizers.Phaser;

import java.util.concurrent.Phaser;

/**
 * Created by gaute.lyngstad on 09.12.13.
 */

// ProcessOrder thread is master thread overlooking to make sure that the Cook, Helper,
// and Attendant are doing their part of the work to complete preparing the food items
// and complete order delivery
// To simplify the logic, we assume that each delivery order consists of exactly three food items
public class ProcessOrder {
    public static void main(String[] args) throws InterruptedException{
        // the Phaser is the synchronizer to make food items one-by-one.
        // and deliver it before moving to the next item
        Phaser deliveryOrder = new Phaser(1); //initiate that one thread have to arriveAndAwait before continue
        System.out.println("Starting to process the delivery order ");

        System.out.println(deliveryOrder.getRegisteredParties());
        new Worker(deliveryOrder, "Cook");
        System.out.println(deliveryOrder.getRegisteredParties());
        new Worker(deliveryOrder, "Helper");
        System.out.println(deliveryOrder.getRegisteredParties());
        new Worker(deliveryOrder, "Attendant");
        System.out.println(deliveryOrder.getRegisteredParties());

        for(int i = 1; i<=3; i++){
            // Prepare, mix and deliver this food item
            deliveryOrder.arriveAndAwaitAdvance();
            System.out.println("Deliver food item no. " + i);
        }
        // work completed for this delivery order, so unregister
        deliveryOrder.arriveAndDeregister();
        System.out.println(deliveryOrder.getRegisteredParties());
        System.out.println("Delivery order complete... give it to the customer");


    }
}

// The work could be a Cook, Helper, or Attendant. Though the three work independently, they
// should all synchronize their work together to do their part and complete preparing a food item
class Worker extends Thread{
    Phaser deliveryOrder;

    Worker(Phaser deliveryOrder, String name) {
        this.setName(name);
        this.deliveryOrder = deliveryOrder;

        // increasing the amount of threads that have to call
        // arriveAndWait before it can continue
        deliveryOrder.register();
        start();
    }

    @Override
    public void run() {
        for(int i = 1; i<=3; i++){
            System.out.println("\t"+getName() + " doing his work for order no. "+i);
            if(i == 3){
                //work completed for this delivery order, so deregister
                deliveryOrder.arriveAndDeregister();
            }else{
                deliveryOrder.arriveAndAwaitAdvance();
            }
            try{
                Thread.sleep(3000); // simulate the time for preparing the food item
            } catch (InterruptedException e) {
                /* ignore exception */
                e.printStackTrace();
            }
        }
    }
}
