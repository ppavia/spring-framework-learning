package ppa.labs.springbatch.model.mapper;

import ppa.labs.springbatch.model.VAERSData;
import ppa.labs.springbatch.model.dto.VAERSDataDto;

public interface VaersDataMapper {
    VAERSDataDto toVaersDto(VAERSData vaersData);

    VAERSData toDto(VAERSDataDto vaersDataDto);
}
