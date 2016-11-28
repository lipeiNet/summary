package spittr.data.impl;

import org.springframework.stereotype.Repository;
import spittr.Spitter;
import spittr.data.SpitterRepository;

/**
 * Created by Administrator on 2016/11/11.
 */
@Repository
public class SpitterRepositoryImpl implements SpitterRepository {
    @Override
    public Spitter save(Spitter spitter) {
        return null;
    }

    @Override
    public Spitter findByUsername(String username) {
        return null;
    }
}
