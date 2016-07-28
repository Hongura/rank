package com;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 *
 */
@Configuration
@EnableAutoConfiguration
@MapperScan(basePackages = "com.hongura.rank", annotationClass = Mapper.class)
public abstract class DatabaseConfig {
    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() throws SQLException {
        return DataSourceBuilder.create()
                .url(env.getProperty("mysql.datasource.url"))
                .driverClassName(env.getProperty("mysql.datasource.driverClassName"))
                .username(env.getProperty("mysql.datasource.username"))
                .password(env.getProperty("mysql.datasource.password"))
                .build();
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource oracleDataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

        sessionFactory.setDataSource(oracleDataSource);
        sessionFactory.setTypeAliasesPackage("com.hongura.rank");
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));

        SqlSessionFactory sqlSessionFactory = null;

        sqlSessionFactory = sessionFactory.getObject();
        sqlSessionFactory.getConfiguration().setJdbcTypeForNull(JdbcType.VARCHAR);
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        sqlSessionFactory.getConfiguration().setDefaultExecutorType(ExecutorType.BATCH);

        return sqlSessionFactory;
    }

    @Bean(destroyMethod = "clearCache")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
