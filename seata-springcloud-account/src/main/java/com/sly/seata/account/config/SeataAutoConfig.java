package com.sly.seata.account.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.sly.seata.account.filter.SeataXidFilter;
import io.seata.rm.datasource.DataSourceProxy;
import io.seata.rm.datasource.xa.DataSourceProxyXA;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * seata配置
 *
 * @author sly
 * @time 2019年6月11日
 */
@Configuration
public class SeataAutoConfig {
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DruidDataSource druidDataSource() {
		return new DruidDataSource();
	}

	@Bean("dataSourceProxy")
	public DataSource dataSourceProxy(DruidDataSource druidDataSource) {
		// DataSourceProxy for AT mode
//		 return new DataSourceProxy(druidDataSource);

		// DataSourceProxyXA for XA mode
		return new DataSourceProxyXA(druidDataSource);
	}

	@Bean("jdbcTemplate")
	public JdbcTemplate jdbcTemplate(DataSource dataSourceProxy) {
		return new JdbcTemplate(dataSourceProxy);
	}

	@Bean
	public PlatformTransactionManager txManager(DataSource dataSourceProxy) {
		return new DataSourceTransactionManager(dataSourceProxy);
	}

	/**
	 * 初始化seataXid过滤器
	 *
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	@Bean
	public SeataXidFilter fescarXidFilter() {
		return new SeataXidFilter();
	}
}
