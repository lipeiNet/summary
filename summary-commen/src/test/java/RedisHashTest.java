import com.lp.rpc.commen.JedisTemplate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/10/11.
 */
public class RedisHashTest {
    private static JedisTemplate jedisTemplate;
    @Before
    public void setUp(){
        ApplicationContext context=new ClassPathXmlApplicationContext("redistest-config.xml");
        jedisTemplate=(JedisTemplate)context.getBean("jedisTemplate");
    }
    @Test
    public void hsetTest(){
        jedisTemplate.hset("user","userName","张三");
        String result=jedisTemplate.hget("user","userName");
        assertEquals("张三",result);
        jedisTemplate.hdel("user","userName");
    }
    @Test
    public void hmsetTest() {
        String[] fields = {"userName","age","realName","phone"};
        String[] values = {"zhangsan", "18", "张三", "139358412580"};
        jedisTemplate.hmset("user", fields, values);
        List<String> userList = jedisTemplate.hmget("user", fields);
        ReflectionAssert.assertReflectionEquals(values,userList.toArray());
        jedisTemplate.hdel("user", fields);
    }
    @Test
    public void hmsetMapTest(){
        String[] expecteds={"lisi","18"};
        Map<String,String> userMap=new HashMap<String, String>();
        userMap.put("userName","lisi");
        userMap.put("age","18");
        jedisTemplate.hmset("user",userMap);
        List<String> userList=jedisTemplate.hmget("user","userName,age".split(","));
        ReflectionAssert.assertReflectionEquals(expecteds,userList.toArray());
        jedisTemplate.hdel("user", "userName,age".split(","));
    }
    @Test
    public void hsetNXTest(){
        jedisTemplate.hdel("user","userName");
        jedisTemplate.hsetNX("user","userName","lisi");
        String result=jedisTemplate.hget("user","userName");
        assertEquals("lisi",result);
        jedisTemplate.hsetNX("user","userName","wangwu");
        String result2=jedisTemplate.hget("user","userName");
        assertEquals("lisi",result2);
    }
    @Test
    public void hgetAllTest(){
       /* Map<String,String>expecteds=new HashMap<String, String>();
        expecteds.put("userName","张三");
        expecteds.put("age","18");
        jedisTemplate.hset("user","userName","张三");
        jedisTemplate.hset("user","age","18");
        Map<String,String>resultMap=jedisTemplate.hgetAll("user");
        ReflectionAssert.assertReflectionEquals(expecteds,resultMap);
        jedisTemplate.hdel("user","userName,age".split(","));*/
    }
    @Test
    public void hexistsTest(){
        jedisTemplate.hset("user","userName","lisi");
        boolean result=jedisTemplate.hexists("user","userName");
        assertTrue(result);
        jedisTemplate.hdel("user","userName");
    }
    @Test
    public void hincrByTest(){
        jedisTemplate.hincrBy("array","size",1);
        jedisTemplate.hincrBy("array","size",5);
        jedisTemplate.hincrBy("array","size",-2);
        String result=jedisTemplate.hget("array","size");
        assertEquals("4",result);
        jedisTemplate.hdel("array","size");
    }


    @After
    public void tearDown(){
        if (jedisTemplate!=null){
            jedisTemplate=null;
        }
    }

    private class ReflectionComparatorMode {
    }
}
