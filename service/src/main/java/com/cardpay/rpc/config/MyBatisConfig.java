package com.cardpay.rpc.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PreDestroy;
import org.apache.tomcat.jdbc.pool.DataSource;

@Configuration
@EnableConfigurationProperties({DBconfig.class})
@ComponentScan(basePackages = {"com.cardpay.dao"})
public class MyBatisConfig {

    @Autowired
    private DBconfig dBconfig;

    @Autowired
    private DataSource dataSource;

    @Bean(destroyMethod = "close")
    public DataSource createDataSource() {
        DBconfig config = this.dBconfig;

        this.dataSource = new DataSource();
        this.dataSource.setDriverClassName(config.getDriverClassName());
        this.dataSource.setUrl(config.getUrl());
        this.dataSource.setUsername(config.getUsername());
        this.dataSource.setPassword(config.getPassword());

        return this.dataSource;
    }

    @PreDestroy
    public void close(){
        if(this.dataSource != null){
            this.dataSource.close();
        }
    }

    @Bean
    @Lazy
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(createDataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:com/cardpay/dao/mapper/*Mapper.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    @Lazy
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager((createDataSource()));
    }
}
