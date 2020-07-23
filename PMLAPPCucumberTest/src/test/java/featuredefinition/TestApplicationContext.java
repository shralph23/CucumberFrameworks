package featuredefinition;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import core.BaseTestContext;
import utils.generic.TestConstants;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "utils.db" })
public class TestApplicationContext {

    private static Properties properties;

    public TestApplicationContext() throws IOException {
        properties = BaseTestContext.initTestContext();
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(getDataSourceTestInfo());
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        return BaseTestContext.entityManagerFactory(properties, TestConstants.HIBERNATE_PERSISTENCE_UNIT);
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return BaseTestContext.transactionManager(properties, TestConstants.HIBERNATE_PERSISTENCE_UNIT);
    }

    @Bean
    public DataSource getDataSourceTestInfo() {
        return BaseTestContext.getDataSourceTestInfo(properties);
    }

}
