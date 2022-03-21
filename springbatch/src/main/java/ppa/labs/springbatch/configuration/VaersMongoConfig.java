package ppa.labs.springbatch.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class VaersMongoConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(VaersMongoConfig.class);

    @Value("${spring.data.mongodb.uri}") String mongouri;
    @Value("${spring.data.mongodb.database}") String dbName;

    @Bean
    public MongoClient mongoClient() {
        LOGGER.info(String.format("--------------- MONGO --------------------- %s"), dbName);
        LOGGER.info(String.format("--------------- MONGO --------------------- %s"), mongouri);
        ConnectionString connectionString = new ConnectionString(mongouri);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), dbName);
    }

}
