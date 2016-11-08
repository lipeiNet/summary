package com.lp.summary.springinaction.ioc.impl;

import com.lp.summary.springinaction.ioc.CompactDisc;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/11/2.
 * component组件的应用
 */
//java可以用@Named作为Component的替代方案（一般不使用@Named）
@Component
public class SgtPeppers implements CompactDisc {
    private String title = "我的中国心";
    private String artist = "刘德华";

    public void play() {
        System.out.println("播放" + title + "歌手" + artist);
    }
}
