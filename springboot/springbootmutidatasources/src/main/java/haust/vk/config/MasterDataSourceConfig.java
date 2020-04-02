package haust.vk.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * basePackages:扫描 Mapper 接口并容器管理，包路径精确到 master，为了和下面 cluster 数据源做到精确区分
 * sqlSessionFactoryRef: 表示定义了 key ，表示一个唯一 SqlSessionFactory 实例
 * @author Administrator
 *
 */
@Configuration
@MapperScan(basePackages = MasterDataSourceConfig.PACKAGE,sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig {
	static final String PACKAGE = "haust.vk.dao.master";
	static final String MAPPER_LOCATION = "classpath:mapper/master/*.xml";
	
	//接下来使用的value注解获取application.properties拿到值进行初始化  spring-EL表达式
	@Value("${master.datasource.url}")
	private String url ;
	@Value("${master.datasource.username}")
	private String user ;
	@Value("${master.datasource.password}")
	private String password ;
	@Value("${master.datasource.driverClassName}")
	private String driverClass ;
	
	//主库数据源
	//Bean明确地指示产生一个bean的方法，并且交给Spring容器管理；
	@Bean(name="masterDataSource")
	//标志这个 Bean 如果在多个同类 Bean 候选时，该 Bean 优先被考虑。「多数据源配置的时候注意，必须要有一个主数据源，用 @Primary 标志该 Bean
	@Primary
	public DataSource masterDataSource(){
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setUrl(url);
		druidDataSource.setUsername(user);
		druidDataSource.setPassword(password);
		druidDataSource.setDriverClassName(driverClass);
		return druidDataSource;
		
	}
	//主库事务
	@Bean(name = "masterTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(masterDataSource());
    }
	//主库sqlSessionFactory   @Qualifier("XXX") 中的 XX是 Bean 的名称，所以 @Autowired 和 @Qualifier 结合使用时，自动注入的策略就从 byType 转变成 byName 了。
	@Bean(name = "masterSqlSessionFactory")
	@Primary
	public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource) throws Exception{
		final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(masterDataSource);
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MasterDataSourceConfig.MAPPER_LOCATION));
		return sqlSessionFactoryBean.getObject();
	}
}
