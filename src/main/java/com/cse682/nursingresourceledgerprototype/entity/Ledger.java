package com.cse682.nursingresourceledgerprototype.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ledger")
public class Ledger {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date arrivalDate;
    private String arrivalRoom;
    private String purposeOfVisit;
    private Boolean readmission;
    private String patientName;
    private String sex;
    private String patientOrigin;
    private Boolean isVentilatorSupport;
    private String lifeSavingDevices;
    private String transferLocation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalRoom() {
        return arrivalRoom;
    }

    public void setArrivalRoom(String arrivalRoom) {
        this.arrivalRoom = arrivalRoom;
    }

    public String getPurposeOfVisit() {
        return purposeOfVisit;
    }

    public void setPurposeOfVisit(String purposeOfVisit) {
        this.purposeOfVisit = purposeOfVisit;
    }

    public Boolean getReadmission() {
        return readmission;
    }

    public void setReadmission(Boolean readmission) {
        this.readmission = readmission;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPatientOrigin() {
        return patientOrigin;
    }

    public void setPatientOrigin(String patientOrigin) {
        this.patientOrigin = patientOrigin;
    }

    public Boolean getVentilatorSupport() {
        return isVentilatorSupport;
    }

    public void setVentilatorSupport(Boolean ventilatorSupport) {
        isVentilatorSupport = ventilatorSupport;
    }

    public String getLifeSavingDevices() {
        return lifeSavingDevices;
    }

    public void setLifeSavingDevices(String lifeSavingDevices) {
        this.lifeSavingDevices = lifeSavingDevices;
    }

    public String getTransferLocation() {
        return transferLocation;
    }

    public void setTransferLocation(String transferLocation) {
        this.transferLocation = transferLocation;
    }


    
}
