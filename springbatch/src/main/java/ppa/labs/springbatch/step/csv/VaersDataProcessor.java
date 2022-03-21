package ppa.labs.springbatch.step.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import ppa.labs.springbatch.model.VAERSData;
import ppa.labs.springbatch.model.dto.VAERSDataDto;
import ppa.labs.springbatch.model.mapper.VaersDataMapper;

public class VaersDataProcessor implements ItemProcessor<VAERSDataDto, VAERSData> {
    private final static Logger LOGGER = LoggerFactory.getLogger(VaersDataProcessor.class);
    @Autowired
    private VaersDataMapper vaersDataMapper;

    @Override
    public VAERSData process(VAERSDataDto vaersDataDto) throws Exception {
        LOGGER.info(String.format(" ------------- %s --", this.getClass().getSimpleName()));
        return vaersDataMapper.toDto(vaersDataDto);
    }
}
