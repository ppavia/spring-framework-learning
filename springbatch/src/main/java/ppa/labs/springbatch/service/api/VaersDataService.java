package ppa.labs.springbatch.service.api;

import ppa.labs.springbatch.model.VAERSData;

import java.util.Map;

public interface VaersCsvService {

    Map<Long, VAERSData> getVAERSData();
}
