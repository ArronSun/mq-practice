package site.sunlong.rabbitmq;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import site.sunlong.rabbitmq.service.Sender;

@RunWith(SpringRunner.class)
@SpringBootTest
class RabbitmqApplicationTests {

    @Autowired
    private Sender sender;

    @Test
    public void testHello(){
//        sender.sendHello();

        sender.sendHelloUser();
    }


}
