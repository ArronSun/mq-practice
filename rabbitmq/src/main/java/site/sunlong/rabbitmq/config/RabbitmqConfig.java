package site.sunlong.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import site.sunlong.rabbitmq.service.Receiver;
import site.sunlong.rabbitmq.service.Sender;

/**
 * @Author: Sunlong
 * @date: 2022/1/19 18:28
 */
@Configuration
public class RabbitmqConfig {


    /**
     * 创建一个队列，队列名字为 hello
     * @return
     */
    @Bean
    public Queue helloQueue(){
        return new Queue("hello");
    }


}
