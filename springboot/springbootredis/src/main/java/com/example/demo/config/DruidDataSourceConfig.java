package com.example.demo.config;

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
 * @description: 
 * @author viakiba
 * @date 2017年7月12日
 */
@Configuration
@MapperScan(basePackages = DruidDataSourceConfig.PACKAGE,sqlSessionFactoryRef = "sqlSessionFactory")
public class DruidDataSourceConfig {
	static final String PACKAGE = "com.example.demo.dao";
	static final String MAPPER_LOCATION = "classpath:mapper/*.xml";
	
	//接下来使用的value注解获取application.properties拿到值进行初始化  spring-EL表达式
	@Value("${spring.datasource.url}")
	private String url ;
	@Value("${spring.datasource.username}")
	private String user ;
	@Value("${spring.datasource.password}")
	private String password ;
	@Value("${spring.datasource.driver-class-name}")
	private String driverClass ;
	
	//数据源
	//Bean明确地指示产生一个bean的方法，并且交给Spring容器管理；
	@Bean(name="dataSource")
	//标志这个 Bean 如果在多个同类 Bean 候选时，该 Bean 优先被考虑。「多数据源配置的时候注意，必须要有一个主数据源，用 @Primary 标志该 Bean
	@Primary
	public DataSource dataSource(){
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setUrl(url);
		druidDataSource.setUsername(user);
		druidDataSource.setPassword(password);
		druidDataSource.setDriverClassName(driverClass);
		return druidDataSource;
		
	}
	//主库事务
	@Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
	//主库sqlSessionFactory   @Qualifier("XXX") 中的 XX是 Bean 的名称，所以 @Autowired 和 @Qualifier 结合使用时，自动注入的策略就从 byType 转变成 byName 了。
	@Bean(name = "sqlSessionFactory")
	@Primary
	public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception{
		final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DruidDataSourceConfig.MAPPER_LOCATION));
		return sqlSessionFactoryBean.getObject();
	}
}
