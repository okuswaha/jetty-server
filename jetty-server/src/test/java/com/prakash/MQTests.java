package com.prakash;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

public class MQTests {
    @Test
    public void jmsProducerTest() throws JMSException {
        ActiveMQConnectionFactory mqConntionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        final Connection connection = mqConntionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue("queue1");

        MessageProducer producer = session.createProducer(queue);

        TextMessage message = session.createTextMessage("Hello World !!");
        producer.send(message);

        connection.stop();
        System.exit(0);
    }

    @Test
    public void jmsConsumerTest() throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        final Queue queue1 = session.createQueue("queue1");

        MessageConsumer consumer = session.createConsumer(queue1);

        int messages = 0;
        final int MESSAGES_TO_CONSUME = 10;
        do {
            TextMessage message = (TextMessage) consumer.receive();
            messages++;
            System.out.println("Message #"+ messages+ " : "+ message.getText());
        } while (messages < MESSAGES_TO_CONSUME);

        connection.stop();
        System.exit(0);
    }
}
