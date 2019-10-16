package user.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
public class SpringConfiguration {
	@Autowired
	private ApplicationContext applicationContext;
	
	@Bean(name="dataSource")
	public BasicDataSource getBasicDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		basicDataSource.setUsername("system");
		basicDataSource.setPassword("oracle");
		basicDataSource.setMaxTotal(20);
		basicDataSource.setMaxIdle(3);
		
		return basicDataSource;
	}
	
	@Bean(name="sqlSessionFactory")
	public SqlSessionFactory getSqlSessionFactory() throws Exception{
	  SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//	  PathMatchingResourcePatternResolver pmrpr = new PathMatchingResourcePatternResolver();
//	  factoryBean.setDataSource(getBasicDataSource());
//	  factoryBean.setConfigLocation(pmrpr.getResource("spring/mybatis-config.xml"));
//	  factoryBean.setMapperLocations(pmrpr.getResources("user/dao/userMapper.xml"));
	  factoryBean.setDataSource(getBasicDataSource());
	  factoryBean.setConfigLocation(applicationContext.getResource("classpath:spring/mybatis-config.xml"));
	  factoryBean.setMapperLocations(applicationContext.getResources("classpath:user/dao/userMapper.xml"));
	  return factoryBean.getObject();
	}	
	
	@Bean(name="sqlSession")
	public SqlSessionTemplate getSqlSessionTemplate() throws Exception {
	  return new SqlSessionTemplate(getSqlSessionFactory());
	}
	
	@Bean(name="transactionManager")
	public DataSourceTransactionManager transactionManager() {
	  return new DataSourceTransactionManager(getBasicDataSource());
	}
	
	
}
