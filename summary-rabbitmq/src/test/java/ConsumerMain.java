import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/11/18.
 */
public class ConsumerMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("amqp/amqp-consumer.xml");
        System.out.println("开始监听");
    }
}

