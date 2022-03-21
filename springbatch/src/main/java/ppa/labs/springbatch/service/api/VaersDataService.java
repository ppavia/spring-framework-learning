package ppa.labs.springbatch.service.api;

import ppa.labs.springbatch.model.VAERSData;

import java.util.List;
import java.util.Optional;

public interface VaersDataService {

    List<VAERSData> getVaersDatas();

    Optional<VAERSData> getVaersDataById(long id);

    VAERSData createVaersData(VAERSData vaersData);

    List<VAERSData> createManyVaersData(List<VAERSData> vaersDataList);

}
