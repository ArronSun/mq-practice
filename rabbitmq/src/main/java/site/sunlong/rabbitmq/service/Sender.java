package site.sunlong.rabbitmq.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import site.sunlong.pojo.User;

/**
 * @Author: Sunlong
 * @date: 2022/1/19 18:31
 */
@Component
public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Queue helloQueue;


    /**
     * 通过
     */
    public void sendHello(){
        final String queueName = helloQueue.getName();
        System.out.println(queueName);
        rabbitTemplate.convertAndSend( queueName , "hello_rabbitmq");
    }

    /**
     *
     *  生产者发送消息
     *
     *  SimpleMessageConverter only supports String, byte[] and Serializable payloads
     *
     */
    public void sendHelloUser(){
        final String queueName = helloQueue.getName();
        final User user = new User();
        user.setUsername("hello_rabbitmq");
        rabbitTemplate.convertAndSend( queueName , user);
    }

}
