package com.lp.summary.rabbitmq.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/11/18.
 */
public class Spittle implements Serializable {
    private Long id;
    private Spitter spitter;
    private String message;
    private Date postedTime;

    public  Spittle(){};
    public Spittle(Long id, Spitter spitter, String message, Date postedTime) {
        this.id = id;
        this.spitter = spitter;
        this.message = message;
        this.postedTime = postedTime;
    }

    public Spitter getSpitter() {
        return spitter;
    }

    public void setSpitter(Spitter spitter) {
        this.spitter = spitter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getPostedTime() {
        return postedTime;
    }

    public void setPostedTime(Date postedTime) {
        this.postedTime = postedTime;
    }
}
