package spittr.rest;

import org.springframework.web.client.RestTemplate;
import spittr.Spitter;

/**
 * Created by Administrator on 2016/11/17.
 */
public class RestClient {
    public Spitter getSpitter(String id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("url/{id}", Spitter.class, id);
    }
}
