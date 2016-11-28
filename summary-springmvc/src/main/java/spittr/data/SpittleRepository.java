package spittr.data;

import spittr.Spittle;

import java.util.List;

/**
 * Created by Administrator on 2016/11/11.
 */
public interface SpittleRepository {
    List<Spittle> findRecentSpittles();

    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long id);

    Spittle save(Spittle spittle);

}
