package ppa.labs.springbatch.step.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import ppa.labs.springbatch.model.dto.VAERSDataDto;


public class VaersCsvReader implements ItemReader<VAERSDataDto> {
    private final static Logger LOGGER = LoggerFactory.getLogger(VaersCsvReader.class);
    @Override
    public VAERSDataDto read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        LOGGER.info(String.format(" ------------- %s --", this.getClass().getSimpleName()));
        return null;
    }

}
