package ppa.labs.springbatch.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class VAERSDataDto implements Serializable {
    private long id;

    private LocalDate dtRecv;

    private String state;

    private float ageYears;

    private int cageYear;

    private int cageMonth;

    private String sex;

    private LocalDate dtRp;

    private String symptom;

    private String died;

    private LocalDate dtDied;

    private String threat;

    private String erVisit;

    private String hospital;

    private int hospitalDays;

    private String xStay;

    private String disable;

    private String recovd;

    private LocalDate dtVax;

    private LocalDate dtOnset;

    private int numDays;

    private String labData;

    private String vAdminBy;

    private String vFundBy;

    private String otherMeds;

    private String curIll;

    private String history;

    private String priorVax;

    private String spltType;

    private String fromVers;

    private LocalDate dtTodays;

    private LocalDate birthEffect;

    private String ofcVisit;

    private String erEdVisit;

    private String allergies;

    public VAERSDataDto(
            long id
            ,LocalDate dtRecv
            ,String state
            ,float ageYears
            ,int cageYear
            ,int cageMonth
            ,String sex
            ,LocalDate dtRp
            ,String symptom
            ,String died
            ,LocalDate dtDied
            ,String threat
            ,String erVisit
            ,String hospital
            ,int hospitalDays
            ,String xStay
            ,String disable
            ,String recovd
            ,LocalDate dtVax
            ,LocalDate dtOnset
            ,int numDays
            ,String labData
            ,String vAdminBy
            ,String vFundBy
            ,String otherMeds
            ,String curIll
            ,String history
            ,String priorVax
            ,String spltType
            ,String fromVers
            ,LocalDate dtTodays
            ,LocalDate birthEffect
            ,String ofcVisit
            ,String erEdVisit
            ,String allergies) {
        this.id = id;
        this.dtRecv = dtRecv;
        this.state = state;
        this.ageYears = ageYears;
        this.cageYear = cageYear;
        this.cageMonth = cageMonth;
        this.sex = sex;
        this.dtRp = dtRp;
        this.symptom = symptom;
        this.died = died;
        this.dtDied = dtDied;
        this.threat = threat;
        this.erVisit = erVisit;
        this.hospital = hospital;
        this.hospitalDays = hospitalDays;
        this.xStay = xStay;
        this.disable = disable;
        this.recovd = recovd;
        this.dtVax = dtVax;
        this.dtOnset = dtOnset;
        this.numDays = numDays;
        this.labData = labData;
        this.vAdminBy = vAdminBy;
        this.vFundBy = vFundBy;
        this.otherMeds = otherMeds;
        this.curIll = curIll;
        this.history = history;
        this.priorVax = priorVax;
        this.spltType = spltType;
        this.fromVers = fromVers;
        this.dtTodays = dtTodays;
        this.birthEffect = birthEffect;
        this.ofcVisit = ofcVisit;
        this.erEdVisit = erEdVisit;
        this.allergies = allergies;
    }

    public long getId() {
        return id;
    }

    public LocalDate getDtRecv() {
        return dtRecv;
    }

    public void setDtRecv(LocalDate dtRecv) {
        this.dtRecv = dtRecv;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public float getAgeYears() {
        return ageYears;
    }

    public void setAgeYears(float ageYears) {
        this.ageYears = ageYears;
    }

    public int getCageYear() {
        return cageYear;
    }

    public void setCageYear(int cageYear) {
        this.cageYear = cageYear;
    }

    public int getCageMonth() {
        return cageMonth;
    }

    public void setCageMonth(int cageMonth) {
        this.cageMonth = cageMonth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getDtRp() {
        return dtRp;
    }

    public void setDtRp(LocalDate dtRp) {
        this.dtRp = dtRp;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getDied() {
        return died;
    }

    public void setDied(String died) {
        this.died = died;
    }

    public LocalDate getDtDied() {
        return dtDied;
    }

    public void setDtDied(LocalDate dtDied) {
        this.dtDied = dtDied;
    }

    public String getThreat() {
        return threat;
    }

    public void setThreat(String threat) {
        this.threat = threat;
    }

    public String getErVisit() {
        return erVisit;
    }

    public void setErVisit(String erVisit) {
        this.erVisit = erVisit;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public int getHospitalDays() {
        return hospitalDays;
    }

    public void setHospitalDays(int hospitalDays) {
        this.hospitalDays = hospitalDays;
    }

    public String getxStay() {
        return xStay;
    }

    public void setxStay(String xStay) {
        this.xStay = xStay;
    }

    public String getDisable() {
        return disable;
    }

    public void setDisable(String disable) {
        this.disable = disable;
    }

    public String getRecovd() {
        return recovd;
    }

    public void setRecovd(String recovd) {
        this.recovd = recovd;
    }

    public LocalDate getDtVax() {
        return dtVax;
    }

    public void setDtVax(LocalDate dtVax) {
        this.dtVax = dtVax;
    }

    public LocalDate getDtOnset() {
        return dtOnset;
    }

    public void setDtOnset(LocalDate dtOnset) {
        this.dtOnset = dtOnset;
    }

    public int getNumDays() {
        return numDays;
    }

    public void setNumDays(int numDays) {
        this.numDays = numDays;
    }

    public String getLabData() {
        return labData;
    }

    public void setLabData(String labData) {
        this.labData = labData;
    }

    public String getvAdminBy() {
        return vAdminBy;
    }

    public void setvAdminBy(String vAdminBy) {
        this.vAdminBy = vAdminBy;
    }

    public String getvFundBy() {
        return vFundBy;
    }

    public void setvFundBy(String vFundBy) {
        this.vFundBy = vFundBy;
    }

    public String getOtherMeds() {
        return otherMeds;
    }

    public void setOtherMeds(String otherMeds) {
        this.otherMeds = otherMeds;
    }

    public String getCurIll() {
        return curIll;
    }

    public void setCurIll(String curIll) {
        this.curIll = curIll;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getPriorVax() {
        return priorVax;
    }

    public void setPriorVax(String priorVax) {
        this.priorVax = priorVax;
    }

    public String getSpltType() {
        return spltType;
    }

    public void setSpltType(String spltType) {
        this.spltType = spltType;
    }

    public String getFromVers() {
        return fromVers;
    }

    public void setFromVers(String fromVers) {
        this.fromVers = fromVers;
    }

    public LocalDate getDtTodays() {
        return dtTodays;
    }

    public void setDtTodays(LocalDate dtTodays) {
        this.dtTodays = dtTodays;
    }

    public LocalDate getBirthEffect() {
        return birthEffect;
    }

    public void setBirthEffect(LocalDate birthEffect) {
        this.birthEffect = birthEffect;
    }

    public String getOfcVisit() {
        return ofcVisit;
    }

    public void setOfcVisit(String ofcVisit) {
        this.ofcVisit = ofcVisit;
    }

    public String getErEdVisit() {
        return erEdVisit;
    }

    public void setErEdVisit(String erEdVisit) {
        this.erEdVisit = erEdVisit;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }
}
