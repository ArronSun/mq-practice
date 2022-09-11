package com.example.rocketmq;

import com.example.rocketmq.producer.ProducerDemo;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RocketmqApplication.class)
class RocketmqApplicationTests {

    @Value("${rocketmq.consumer.topic}")
    private String topic;

    @Autowired
    private ProducerDemo producerDemo;
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void testProducer(){
        String tagA = ":tag1";
        final String s = topic + tagA;

        String msg =  UUID.randomUUID().toString();
        msg = "Orderly_test";


        rocketMQTemplate.convertAndSend(topic , msg);
    }


    @Test
    public void testTransactionMsg() throws InterruptedException {
        String msg = topic + UUID.randomUUID();

        producerDemo.sendMessageInTransaction(topic , msg);

    }


}
