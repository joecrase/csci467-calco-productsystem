package csci467.calfco.productsystem.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:datasource.properties")
public class JpaConfig {

    @Bean(name = "legacyProductDB")
    @ConfigurationProperties(prefix = "calfco.productsystem")
    public DataSource getDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "legacyProductDAO")
    public JdbcTemplate legacyProductJdbc(@Qualifier("legacyProductDB") DataSource ds){
        return new JdbcTemplate(ds);
    }
}
