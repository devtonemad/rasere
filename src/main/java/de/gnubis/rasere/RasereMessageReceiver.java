package de.gnubis.rasere;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RasereMessageReceiver {

    @RabbitListener(queues = RasereRabbitConfigNames.QUEUE_MESSAGES)
    public void receiveMessageFromMyQueue(String message) throws InterruptedException {
        System.out.println("Consumer 1 Received from myqueue: " + message);
        Thread.sleep(1000);
    }

    @RabbitListener(queues = RasereRabbitConfigNames.QUEUE_MESSAGES)
    public void receiveMessageFromMyQueue2(String message) throws InterruptedException {
        System.out.println("Consumer 2 Received from myqueue: " + message);
        Thread.sleep(100);
    }
//
//    @RabbitListener(queues = "myqueue2")
//    public void receiveMessageFromMyQueue2(String message) {
//        System.out.println("Received from myqueue2: " + message);
//    }
//
//    @RabbitListener(queues = "mystream")
//    public void receiveMessageFromMyStream(String message) {
//        System.out.println("Received from mystream: " + message);
//    }
//    @RabbitListener(queues = "mystream")
//    public void receiveMessageFromMyStream2(String message) {
//        System.out.println("2nd Received from mystream: " + message);
//    }

}
