package ppa.labs.springbatch.model.mapper;

import ppa.labs.springbatch.model.VAERSData;
import ppa.labs.springbatch.model.dto.VAERSDataDto;

import java.time.LocalDate;

public class DefaultVaersDataMapper implements VaersDataMapper {
    @Override
    public VAERSDataDto toVaersDto(VAERSData vaersData) {
        return new VAERSDataDto(
                vaersData.getId()
            ,vaersData.getDtRecv()
            ,vaersData.getState()
            ,vaersData.getAgeYears()
            ,vaersData.getCageYear()
            ,vaersData.getCageMonth()
            ,vaersData.getSex()
            ,vaersData.getDtRp()
            ,vaersData.getSymptom()
            ,vaersData.getDied()
            ,vaersData.getDtDied()
            ,vaersData.getThreat()
            ,vaersData.getErVisit()
            ,vaersData.getHospital()
            ,vaersData.getHospitalDays()
            ,vaersData.getxStay()
            ,vaersData.getDisable()
            ,vaersData.getRecovd()
            ,vaersData.getDtVax()
            ,vaersData.getDtOnset()
            ,vaersData.getNumDays()
            ,vaersData.getLabData()
            ,vaersData.getvAdminBy()
            ,vaersData.getvFundBy()
            ,vaersData.getOtherMeds()
            ,vaersData.getCurIll()
            ,vaersData.getHistory()
            ,vaersData.getPriorVax()
            ,vaersData.getSpltType()
            ,vaersData.getFromVers()
            ,vaersData.getDtTodays()
            ,vaersData.getBirthEffect()
            ,vaersData.getOfcVisit()
            ,vaersData.getErEdVisit()
            ,vaersData.getAllergies()
        );
    }

    @Override
    public VAERSData toDto(VAERSDataDto vaersDataDto) {
        return new VAERSData(
                vaersDataDto.getId()
                ,vaersDataDto.getDtRecv()
                ,vaersDataDto.getState()
                ,vaersDataDto.getAgeYears()
                ,vaersDataDto.getCageYear()
                ,vaersDataDto.getCageMonth()
                ,vaersDataDto.getSex()
                ,vaersDataDto.getDtRp()
                ,vaersDataDto.getSymptom()
                ,vaersDataDto.getDied()
                ,vaersDataDto.getDtDied()
                ,vaersDataDto.getThreat()
                ,vaersDataDto.getErVisit()
                ,vaersDataDto.getHospital()
                ,vaersDataDto.getHospitalDays()
                ,vaersDataDto.getxStay()
                ,vaersDataDto.getDisable()
                ,vaersDataDto.getRecovd()
                ,vaersDataDto.getDtVax()
                ,vaersDataDto.getDtOnset()
                ,vaersDataDto.getNumDays()
                ,vaersDataDto.getLabData()
                ,vaersDataDto.getvAdminBy()
                ,vaersDataDto.getvFundBy()
                ,vaersDataDto.getOtherMeds()
                ,vaersDataDto.getCurIll()
                ,vaersDataDto.getHistory()
                ,vaersDataDto.getPriorVax()
                ,vaersDataDto.getSpltType()
                ,vaersDataDto.getFromVers()
                ,vaersDataDto.getDtTodays()
                ,vaersDataDto.getBirthEffect()
                ,vaersDataDto.getOfcVisit()
                ,vaersDataDto.getErEdVisit()
                ,vaersDataDto.getAllergies()
        );
    }
}
