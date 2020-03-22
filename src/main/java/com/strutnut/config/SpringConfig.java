package com.strutnut.config;

import com.strutnut.model.pojo.User;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.strutnut")
@MapperScan("com.strutnut.dao")
@PropertySource("classpath:mybatis-config.properties")
public class SpringConfig {

    public SpringConfig() {
        System.out.println("OKSpringConfig");
    }

    @Value("${mybatis.driver}")
    private String driverPath;

    @Value("${mybatis.username}")
    private String username;

    @Value("${mybatis.password}")
    private String password;

    @Value("${mybatis.url}")
    private String url;

    @Bean
    public DataSource getDataSource() {
        System.out.println("OKMyDataSource");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverPath);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        return dataSource;
    }

    @Bean
    @Autowired
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        ClassPathResource[] mappers= new ClassPathResource[]{
                new ClassPathResource("com/strutnut/dao/impl/UserMapper.xml"),
                new ClassPathResource("com/strutnut/dao/impl/ThemeMapper.xml")
        };
        sqlSessionFactoryBean.setMapperLocations(mappers);
        return sqlSessionFactoryBean;
    }

    @Bean
    ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}
