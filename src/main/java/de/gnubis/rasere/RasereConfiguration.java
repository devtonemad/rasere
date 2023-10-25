package de.gnubis.rasere;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RasereConfiguration {

    @Bean
    Queue messagesQueue() {
        return QueueBuilder.durable(RasereRabbitConfigNames.QUEUE_MESSAGES)
                .build();
    }

    @Bean
    DirectExchange messagesExchange() {
        return new DirectExchange(RasereRabbitConfigNames.EXCHANGE_MESSAGES);
    }

    @Bean
    Binding bindingMessages() {
        return BindingBuilder.bind(messagesQueue()).to(messagesExchange()).with(RasereRabbitConfigNames.QUEUE_MESSAGES);
    }
//    @Bean
//    public Queue myQueue() {
//        return new Queue("myqueue");
//    }
//
//    @Bean
//    public Exchange myExchange() {
//        return ExchangeBuilder.fanoutExchange("myexchange").build();
//
//    }





}
