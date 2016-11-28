package spittr.data.impl;

import org.springframework.stereotype.Repository;
import spittr.Spittle;
import spittr.data.SpittleRepository;

import java.util.List;

/**
 * Created by Administrator on 2016/11/11.
 */
@Repository
public class SpittleRepositoryImpl implements SpittleRepository {

    @Override
    public List<Spittle> findRecentSpittles() {
        return null;
    }

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }

    @Override
    public Spittle findOne(long id) {
        return null;
    }

    @Override
    public Spittle save(Spittle spittle) {

    }
}
