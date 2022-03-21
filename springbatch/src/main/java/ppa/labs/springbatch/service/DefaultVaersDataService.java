package ppa.labs.springbatch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ppa.labs.springbatch.model.VAERSData;
import ppa.labs.springbatch.repository.VAERSDataRepositoty;
import ppa.labs.springbatch.service.api.VaersDataService;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultVaersDataService implements VaersDataService {
    private final VAERSDataRepositoty vaersDataRepositoty;

    @Autowired
    public DefaultVaersDataService(VAERSDataRepositoty vaersDataRepositoty) {
        this.vaersDataRepositoty = vaersDataRepositoty;
    }

    @Override
    public List<VAERSData> getVaersDatas() {
        return vaersDataRepositoty.findAll();
    }

    @Override
    public Optional<VAERSData> getVaersDataById(long id) {
        return vaersDataRepositoty.findById(id);
    }

    @Override
    public VAERSData createVaersData(VAERSData vaersData) {
        return vaersDataRepositoty.insert(vaersData);
    }

    @Override
    public List<VAERSData> createManyVaersData(List<VAERSData> vaersDataList) {
        return vaersDataRepositoty.saveAll(vaersDataList);
    }
}
