package haust.vk.service.serviceimpl;

import haust.vk.dao.TestDao;
import haust.vk.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by viakiba on 2017/5/30.
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestDao testDao;

    @Override
    public List<Map> selectTest() {
        List<Map> list = testDao.selectTest();
        return list;
    }
}
