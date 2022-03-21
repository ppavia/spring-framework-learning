package ppa.labs.springbatch.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ppa.labs.springbatch.model.convertor.VaersFieldConvertor;
import ppa.labs.springbatch.model.mapper.DefaultVaersDataMapper;
import ppa.labs.springbatch.model.mapper.VaersDataMapper;
import ppa.labs.springbatch.model.mapper.VaersFieldMapper;

@Configuration
public class DataConfiguration {

    @Bean
    public VaersDataMapper vaersDataMapper() {
        return new DefaultVaersDataMapper();
    }

    @Bean
    public VaersFieldMapper vaersFieldMapper() {
        return new VaersFieldMapper(vaersFieldConvertor());
    }

    @Bean
    public VaersFieldConvertor vaersFieldConvertor() {
        return new VaersFieldConvertor();
    }
}
