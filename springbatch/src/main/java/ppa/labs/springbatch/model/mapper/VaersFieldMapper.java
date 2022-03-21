package ppa.labs.springbatch.model.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import ppa.labs.springbatch.model.convertor.VaersFieldConvertor;
import ppa.labs.springbatch.model.dto.VAERSDataDto;
import ppa.labs.springbatch.model.enums.CsvVaersHeader;

public class VaersFieldMapper implements FieldSetMapper<VAERSDataDto> {
    private final VaersFieldConvertor vaersFieldConvertor;

    @Autowired
    public VaersFieldMapper(VaersFieldConvertor vaersFieldConvertor) {
        this.vaersFieldConvertor = vaersFieldConvertor;
    }

    @Override
    public VAERSDataDto mapFieldSet(FieldSet fieldSet) throws BindException {
        VAERSDataDto VAERSDataDto = new VAERSDataDto(
                fieldSet.readLong(CsvVaersHeader.VAERS_ID.toString()),
                vaersFieldConvertor.fieldLocalDateConvertor(fieldSet.readString(CsvVaersHeader.RECVDATE.toString())),
                fieldSet.readString(CsvVaersHeader.STATE.toString()),
                vaersFieldConvertor.fieldFloatConvertor(fieldSet.readString(CsvVaersHeader.AGE_YRS.toString())),
                vaersFieldConvertor.fieldIntegerConvertor(fieldSet.readString(CsvVaersHeader.CAGE_YR.toString())),
                vaersFieldConvertor.fieldIntegerConvertor(fieldSet.readString(CsvVaersHeader.CAGE_MO.toString())),
                fieldSet.readString(CsvVaersHeader.SEX.toString()),
                vaersFieldConvertor.fieldLocalDateConvertor(fieldSet.readString(CsvVaersHeader.RPT_DATE.toString())),
                fieldSet.readString(CsvVaersHeader.SYMPTOM_TEXT.toString()),
                fieldSet.readString(CsvVaersHeader.DIED.toString()),
                vaersFieldConvertor.fieldLocalDateConvertor(fieldSet.readString(CsvVaersHeader.DATEDIED.toString())),
                fieldSet.readString(CsvVaersHeader.L_THREAT.toString()),
                fieldSet.readString(CsvVaersHeader.ER_VISIT.toString()),
                fieldSet.readString(CsvVaersHeader.HOSPITAL.toString()),
                vaersFieldConvertor.fieldIntegerConvertor(fieldSet.readString(CsvVaersHeader.HOSPDAYS.toString())),
                fieldSet.readString(CsvVaersHeader.X_STAY.toString()),
                fieldSet.readString(CsvVaersHeader.DISABLE.toString()),
                fieldSet.readString(CsvVaersHeader.RECOVD.toString()),
                vaersFieldConvertor.fieldLocalDateConvertor(fieldSet.readString(CsvVaersHeader.VAX_DATE.toString())),
                vaersFieldConvertor.fieldLocalDateConvertor(fieldSet.readString(CsvVaersHeader.ONSET_DATE.toString())),
                vaersFieldConvertor.fieldIntegerConvertor(fieldSet.readString(CsvVaersHeader.NUMDAYS.toString())),
                fieldSet.readString(CsvVaersHeader.LAB_DATA.toString()),
                fieldSet.readString(CsvVaersHeader.V_ADMINBY.toString()),
                fieldSet.readString(CsvVaersHeader.V_FUNDBY.toString()),
                fieldSet.readString(CsvVaersHeader.OTHER_MEDS.toString()),
                fieldSet.readString(CsvVaersHeader.CUR_ILL.toString()),
                fieldSet.readString(CsvVaersHeader.HISTORY.toString()),
                fieldSet.readString(CsvVaersHeader.PRIOR_VAX.toString()),
                fieldSet.readString(CsvVaersHeader.SPLTTYPE.toString()),
                fieldSet.readString(CsvVaersHeader.FORM_VERS.toString()),
                vaersFieldConvertor.fieldLocalDateConvertor(fieldSet.readString(CsvVaersHeader.TODAYS_DATE.toString())),
                vaersFieldConvertor.fieldLocalDateConvertor(fieldSet.readString(CsvVaersHeader.BIRTH_DEFECT.toString())),
                fieldSet.readString(CsvVaersHeader.OFC_VISIT.toString()),
                fieldSet.readString(CsvVaersHeader.ER_ED_VISIT.toString()),
                fieldSet.readString(CsvVaersHeader.ALLERGIES.toString())
        );
        return VAERSDataDto;
    }
}
