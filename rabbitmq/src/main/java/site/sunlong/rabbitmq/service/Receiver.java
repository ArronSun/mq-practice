package site.sunlong.rabbitmq.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import site.sunlong.pojo.User;

/**
 * @Author: Sunlong
 * @date: 2022/1/19 18:34
 */
@Component
@RabbitListener(queues = {"hello"})
public class Receiver {

    @RabbitHandler
    public void receiveHello(String hello){
        System.out.println("received message :"+hello);
    }

    @RabbitHandler
    public void receiveHelloUser(User user){
        System.out.println("received user message :"+user);
    }
}
