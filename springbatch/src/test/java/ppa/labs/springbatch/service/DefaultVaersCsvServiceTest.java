package ppa.labs.springbatch.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.TestPropertySource;
import ppa.labs.springbatch.configuration.DataConfiguration;
import ppa.labs.springbatch.configuration.VaersMongoConfig;
import ppa.labs.springbatch.model.convertor.VaersFieldConvertor;
import ppa.labs.springbatch.service.api.VaersDataService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataMongoTest
@TestPropertySource({"classpath:application.properties"})
@Import({VaersMongoConfig.class, DataConfiguration.class})
@ComponentScan({"ppa.labs.springbatch.service"})
public class DefaultVaersCsvServiceTest {

    private final VaersDataService vaersDataService;

    private final MongoTemplate mongoTemplate;

    private final VaersFieldConvertor vaersFieldConvertor;

    @Autowired
    public DefaultVaersCsvServiceTest(
            VaersDataService vaersDataService,
            VaersFieldConvertor vaersFieldConvertor,
            MongoTemplate mongoTemplate) {
        this.vaersDataService = vaersDataService;
        this.vaersFieldConvertor = vaersFieldConvertor;
        this.mongoTemplate = mongoTemplate;
    }

    @Test
    void fieldLongConvertor_numericField() {
        long fieldLong = this.vaersFieldConvertor.fieldLongConvertor("17800");
        assertEquals(17800L, fieldLong);
    }

    @Test
    void fieldLongConvertor_zeroField() {
        long fieldLong = this.vaersFieldConvertor.fieldLongConvertor("0");
        assertEquals(0L, fieldLong);
    }

    @Test
    void fieldLongConvertor_naField() {
        long fieldLong = this.vaersFieldConvertor.fieldLongConvertor("n/a");
        assertEquals(0L, fieldLong);
    }

    @Test
    void fieldLongConvertor_badField() {
        long fieldLong = this.vaersFieldConvertor.fieldLongConvertor("bad field");
        assertEquals(0L, fieldLong);
    }

    @Test
    void fieldFloatConvertor_startPointField() {
        float fieldFloat = this.vaersFieldConvertor.fieldFloatConvertor(".45");
        assertEquals(0.45f, fieldFloat);
    }

    @Test
    void fieldFloatConvertor_badField() {
        float fieldFloat = this.vaersFieldConvertor.fieldFloatConvertor("bad field");
        assertEquals(0f, fieldFloat);
    }

    @Test
    void fieldLocalDateConvertor_dateField() {
        LocalDate fieldDate = this.vaersFieldConvertor.fieldLocalDateConvertor("08/04/2015");
        assertEquals(LocalDate.of(2015, 8, 4), fieldDate);
    }

    @Test
    void fieldLocalDateConvertor_badField() {
        LocalDate fieldDate = this.vaersFieldConvertor.fieldLocalDateConvertor("bad field");
        assertNull(fieldDate);
    }
}
