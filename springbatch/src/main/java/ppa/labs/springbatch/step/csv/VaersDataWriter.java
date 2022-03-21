package ppa.labs.springbatch.step.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import ppa.labs.springbatch.model.VAERSData;
import ppa.labs.springbatch.service.api.VaersDataService;

import java.util.List;

public class VaersDataWriter implements ItemWriter<VAERSData> {
    private final static Logger LOGGER = LoggerFactory.getLogger(VaersDataWriter.class);

    @Autowired
    private VaersDataService vaersDataService;

    @Override
    public void write(List<? extends VAERSData> vaersData) throws Exception {
        LOGGER.info(String.format(" ------------- %s --", this.getClass().getSimpleName()));
        vaersData.stream()
                .forEach(vaersDataDto -> {
                    StringBuilder wout = new StringBuilder();
                    wout.append("vaers data = ")
                    .append(vaersDataDto.getId())
                    .append(" ").append(vaersDataDto.getDtRecv())
                    .append(" ").append(vaersDataDto.getDied());
                    System.out.println(wout.toString());
                });
        vaersDataService.createManyVaersData((List<VAERSData>) vaersData);
    }
}
