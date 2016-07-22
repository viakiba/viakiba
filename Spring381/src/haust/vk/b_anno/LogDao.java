package haust.vk.b_anno;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//测试：日志传播行为
@Repository
public class LogDao {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	// 始终开启事务
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void insertLog() {
		jdbcTemplate.update("insert into log_ values('dept.....')");
	}
	
}
