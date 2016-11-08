package com.lp.summary.springinaction.javaconfig;

import com.lp.summary.springinaction.ioc.CompactDisc;
import com.lp.summary.springinaction.ioc.impl.CDPlayer;
import com.lp.summary.springinaction.ioc.impl.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2016/11/2.
 */
@Configuration
public class CdConfig {
    @Bean(name = "sgtPeppers")//默认情况下bean的ID和方法名是一致的
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();
    }
   /* @Bean
    public CDPlayer cdPlayer(){
        return new CDPlayer(sgtPeppers());
    }*/

    /**
     * 采用构造函数注入
     * @param compactDisc
     * @return
     */
    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc){
        return new CDPlayer(compactDisc);
    }

    /**
     * 采用属性注入
     * @return
     */
    @Bean
    public CDPlayer cdPlayer1(){
        CDPlayer cdPlayer=new CDPlayer();
        cdPlayer.setCompactDisc(sgtPeppers());
        return cdPlayer;
    }
}
