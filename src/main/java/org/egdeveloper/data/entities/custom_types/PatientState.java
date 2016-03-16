package org.egdeveloper.data.entities.custom_types;


public enum PatientState {
    HEALTHY("здоровый"), FAIR("стабилен"), SERIOUS("болен"), CRITICAL("серьезно болен"), UNDERTERMINED("неопределенное");
    private String patientState;
    private PatientState(String patientState){
        this.patientState = patientState;
    }
    public String patientState2String(){
        return this.patientState;
    }
}
