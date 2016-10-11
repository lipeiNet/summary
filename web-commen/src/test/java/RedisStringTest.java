import com.lp.rpc.commen.JedisTemplate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2016/10/11.
 */
public class RedisStringTest{
    private static JedisTemplate jedisTemplate;
    @Before
    public void setUp(){
        ApplicationContext context=new ClassPathXmlApplicationContext("redistest-config.xml");
        jedisTemplate=(JedisTemplate)context.getBean("jedisTemplate");
    }
    @Test
    public void setTest(){
        jedisTemplate.set("user","张三");
        String result=jedisTemplate.get("user");
        assertEquals("张三",result);
        jedisTemplate.delete("user");
    }
    @Test
    public void setoftimeTest() throws InterruptedException {
        jedisTemplate.set("user","李四",2);
        Thread.sleep(2000);
        String result=jedisTemplate.get("user");
        assertEquals("",result);
    }
    @Test
    public void getTest() {
        jedisTemplate.set("user", "王五");
        String result = jedisTemplate.get("user");
        assertEquals("王五", result);
        jedisTemplate.delete("user");
    }
    @Test
    public void deletekeysTest(){
        jedisTemplate.set("user","张三");
        jedisTemplate.set("age","18");
        String[] keys={"user","age"};
        jedisTemplate.delete(keys);
        String result1=jedisTemplate.get("age");
        String result2=jedisTemplate.get("user");
        assertEquals("",result2);
        assertEquals("",result1);
    }

    @After
    public void tearDown(){
        if (jedisTemplate!=null){
            jedisTemplate=null;
        }
    }
}

