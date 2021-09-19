package com.cse682.nursingresourceledgerprototype.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.util.Date;

/**
 * Ledger entity store in the datastore
 */
@Entity
@Table(name = "ledger")
public class Ledger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date arrivalDate;
    private String arrivalRoom;
    private String purposeOfVisit;
    private boolean readmission;
    private String patientName;
    private String sex;
    private String patientOrigin;
    @JsonProperty
    private boolean isVentilatorSupport;
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

    public boolean getReadmission() {
        return readmission;
    }

    public void setReadmission(boolean readmission) {
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

    public boolean getVentilatorSupport() {
        return isVentilatorSupport;
    }

    public void setVentilatorSupport(boolean ventilatorSupport) {
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
