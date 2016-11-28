package spittr.data;

import spittr.Spitter;

/**
 * Created by Administrator on 2016/11/11.
 */
public interface SpitterRepository {
    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}
