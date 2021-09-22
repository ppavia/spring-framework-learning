package ppa.labs.springbatch.step.csv;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;


public class CsvReader<VAERSData> implements ItemReader<VAERSData> {

    @Override
    public VAERSData read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return null;
    }

}
