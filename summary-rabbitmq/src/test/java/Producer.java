import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/10/18.
 */
public class Producer {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("springrabbitmq/spring-rabbitmq-producer.xml");
        AmqpTemplate amqpTemplate=context.getBean(AmqpTemplate.class);
        amqpTemplate.convertAndSend("spring.test.queueKey","Hello RabbitMQ");
    }
}
