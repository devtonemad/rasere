package de.gnubis.rasere;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RasereMessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void sendMessage(String message) {
//        rabbitTemplate.convertAndSend(queue.getName(), message);
//        System.out.println("Sent to " + queue.getName() + " : " + message);

//        log.debug("sending to "+ RasereRabbitConfigNames.EXCHANGE_MESSAGES +" : " + message);
        rabbitTemplate.convertAndSend(RasereRabbitConfigNames.EXCHANGE_MESSAGES,"my-queue",message);

    }
}
