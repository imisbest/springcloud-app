package com.csw;

import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringcloudAppDetailApplicationTests {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    public void ProductSend() {
        ActiveMQTopic springbootTopic = new ActiveMQTopic("SpringbootTopic");
        jmsTemplate.convertAndSend(springbootTopic, "msg");
    }

    @Test
    @JmsListener(destination = "SpringbootTopic")
    public void Consumers(TextMessage msg) {
        try {
            System.out.println(msg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
