package guru.springframework.config;

import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

@Component
public class PropertyConfig {

    @Value("${guru.db.username}")
    String user;
    @Value("${guru.db.password}")
    String password;
    @Value("${guru.db.dburl}")
    String url;

    @Value("${guru.jms.username}")
    String jms_user;
    @Value("${guru.jms.password}")
    String jms_password;
    @Value("${guru.jms.dburl}")
    String jms_url;

    @Bean
    public FakeDataSource fakeDataSource(){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUrl(url);
        fakeDataSource.setUser(user);
        fakeDataSource.setPassword(password);
        return fakeDataSource;
    }
    @Bean
    public FakeJmsBroker fakeJmsBroker(){
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUrl(jms_url);
        fakeJmsBroker.setUser(jms_user);
        fakeJmsBroker.setPassword(jms_password);
        return fakeJmsBroker;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer =
                new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
