package haust.vk.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by viakiba on 2017/5/30.
 */
@Repository
public interface TestDao {
    List<Map> selectTest();
}
