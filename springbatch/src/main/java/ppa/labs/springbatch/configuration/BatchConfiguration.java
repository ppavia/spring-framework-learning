package ppa.labs.springbatch.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import ppa.labs.springbatch.model.VAERSData;
import ppa.labs.springbatch.model.dto.VAERSDataDto;
import ppa.labs.springbatch.model.mapper.VaersFieldMapper;
import ppa.labs.springbatch.step.csv.VaersCsvReader;
import ppa.labs.springbatch.step.csv.VaersDataProcessor;
import ppa.labs.springbatch.step.csv.VaersDataWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
    @Value("${csv.path.name}")
    private String csvPathName;
    @Value("${csv.delimiter}")
    private String csvDelimiter;

    @Autowired
    private VaersFieldMapper vaersFieldMapper;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public VaersCsvReader vaersCsvReader() {
        return new VaersCsvReader();
    }

    @Bean("vaersDataProcessor")
    public VaersDataProcessor vaersDataProcessor() {
        return new VaersDataProcessor();
    }

    @Bean
    public VaersDataWriter vaersDataWriter() {
        return new VaersDataWriter();
    }

    @Bean
    public Job cvsJob() {
        return jobBuilderFactory.get("csvJob")
                .start(csvStep())
                .build();
    }

    @Bean("csvStep")
    public Step csvStep() {
        return stepBuilderFactory.get("csvStep")
                .<VAERSDataDto, VAERSData>chunk(100)
                .reader(flatFileItemReader())
                .processor(vaersDataProcessor())
                .writer(vaersDataWriter())
                .build();
    }

    @Bean
    public LineMapper<VAERSDataDto> lineMapper() {
        final DefaultLineMapper<VAERSDataDto> defaultLineMapper = new DefaultLineMapper<>();
        final DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(csvDelimiter);
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(new String[] {
                "VAERS_ID"
                ,"RECVDATE"
                ,"STATE"
                ,"AGE_YRS"
                ,"CAGE_YR"
                ,"CAGE_MO"
                ,"SEX"
                ,"RPT_DATE"
                ,"SYMPTOM_TEXT"
                ,"DIED"
                ,"DATEDIED"
                ,"L_THREAT"
                ,"ER_VISIT"
                ,"HOSPITAL"
                ,"HOSPDAYS"
                ,"X_STAY"
                ,"DISABLE"
                ,"RECOVD"
                ,"VAX_DATE"
                ,"ONSET_DATE"
                ,"NUMDAYS"
                ,"LAB_DATA"
                ,"V_ADMINBY"
                ,"V_FUNDBY"
                ,"OTHER_MEDS"
                ,"CUR_ILL"
                ,"HISTORY"
                ,"PRIOR_VAX"
                ,"SPLTTYPE"
                ,"FORM_VERS"
                ,"TODAYS_DATE"
                ,"BIRTH_DEFECT"
                ,"OFC_VISIT"
                ,"ER_ED_VISIT"
                ,"ALLERGIES"
        });
        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(vaersFieldMapper);
        return defaultLineMapper;
    }

    @Bean
    public FlatFileItemReader<VAERSDataDto> flatFileItemReader() {

            return new FlatFileItemReaderBuilder<VAERSDataDto>()
                    .name("vaersItemReader")
                    .resource(new ClassPathResource(csvPathName))
                    .delimited()
                    .names(new String[] {
                            "VAERS_ID"
                            ,"RECVDATE"
                            ,"STATE"
                            ,"AGE_YRS"
                            ,"CAGE_YR"
                            ,"CAGE_MO"
                            ,"SEX"
                            ,"RPT_DATE"
                            ,"SYMPTOM_TEXT"
                            ,"DIED"
                            ,"DATEDIED"
                            ,"L_THREAT"
                            ,"ER_VISIT"
                            ,"HOSPITAL"
                            ,"HOSPDAYS"
                            ,"X_STAY"
                            ,"DISABLE"
                            ,"RECOVD"
                            ,"VAX_DATE"
                            ,"ONSET_DATE"
                            ,"NUMDAYS"
                            ,"LAB_DATA"
                            ,"V_ADMINBY"
                            ,"V_FUNDBY"
                            ,"OTHER_MEDS"
                            ,"CUR_ILL"
                            ,"HISTORY"
                            ,"PRIOR_VAX"
                            ,"SPLTTYPE"
                            ,"FORM_VERS"
                            ,"TODAYS_DATE"
                            ,"BIRTH_DEFECT"
                            ,"OFC_VISIT"
                            ,"ER_ED_VISIT"
                            ,"ALLERGIES"
                    })
                    .linesToSkip(1)
                    .lineMapper(lineMapper())
                    .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                        setTargetType(VAERSDataDto.class);
                    }})
                    .build();

    }

}
