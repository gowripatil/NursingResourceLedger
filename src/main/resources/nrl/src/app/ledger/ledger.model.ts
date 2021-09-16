export class Ledger {
    arrivalDate: Date;
    arrivalRoom: string;
    purposeOfVisit: string;
    readmission: boolean;
    patientName: string;
    sex: string;
    patientOrigin: string;
    isVentilatorSupport: boolean;
    lifeSavingDevices: string;
    transferLocation: string;

    constructor(arrivalDate: Date, arrivalRoom: string, purposeOfVisit: string,
                readmission: boolean, patientName: string, sex: string,
                patientOrigin: string, isVentilatorSupport: boolean,
                lifeSavingDevices: string, transferLocation: string) {
        this.arrivalDate = arrivalDate;
        this.arrivalRoom = arrivalRoom;
        this.purposeOfVisit = purposeOfVisit;
        this.readmission = readmission;
        this.patientName = patientName;
        this.sex = sex;
        this.patientOrigin = patientOrigin;
        this.isVentilatorSupport = isVentilatorSupport;
        this.lifeSavingDevices = lifeSavingDevices;
        this.transferLocation = transferLocation;
    }
}