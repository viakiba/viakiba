package haust.vk.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
//扫描包并进行容器管理
@MapperScan(basePackages = ClusterDataSourceConfig.PACKAGE,sqlSessionFactoryRef = "clusterSqlSessionFactory")
public class ClusterDataSourceConfig {
	
	static final String PACKAGE = "haust.vk.dao.cluster";
	static final String MAPPER_LOCATION = "classpath:mapper/cluster/*.xml";
	@Value("${cluster.datasource.url}")
	private String url;
	@Value("${cluster.datasource.username}")
	private String user;
	@Value("${cluster.datasource.password}")
	private String password;
	@Value("${cluster.datasource.driverClassName}")
	private String driverClass;
	
	//从库数据源
	@Bean(name = "clusterDataSource")
	public DataSource ClusterDataSource(){
		DruidDataSource datasource = new DruidDataSource();
		datasource.setUrl(url);
		datasource.setUsername(user);
		datasource.setPassword(password);
		datasource.setDriverClassName(driverClass);
		return datasource;
	}
	
	@Bean(name = "clusterTransactionManager")
	public DataSourceTransactionManager clusterTransactionManager(){
		return new DataSourceTransactionManager(ClusterDataSource());
	}
	
	@Bean(name = "clusterSqlSessionFactory")
	public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("clusterDataSource") DataSource clusterDataSource) throws Exception{
		final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(clusterDataSource);
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(ClusterDataSourceConfig.MAPPER_LOCATION));
		return sqlSessionFactoryBean.getObject();
		
	}
}
