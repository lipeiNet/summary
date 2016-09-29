import com.lp.rpc.commen.JedisTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/9/29.
 */
public class JedisTest {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("redis-config.xml");
        JedisTemplate jedisTemplate=(JedisTemplate)context.getBean("jedisTemplate");
        jedisTemplate.set("userName","张三");
        Thread.sleep(2000);
        String userName=jedisTemplate.get("userName");
        System.out.println(userName);
    }
}
