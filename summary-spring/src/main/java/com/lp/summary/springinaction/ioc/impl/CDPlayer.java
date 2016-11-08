package com.lp.summary.springinaction.ioc.impl;

import com.lp.summary.springinaction.ioc.CompactDisc;
import com.lp.summary.springinaction.ioc.MediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/11/2.
 */
public class CDPlayer implements MediaPlayer {
    public  CDPlayer(){}

    private CompactDisc compactDisc;
    public void setCompactDisc(CompactDisc compactDisc){
        this.compactDisc=compactDisc;
    }
    public CDPlayer(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    public void play() {

    }
}
