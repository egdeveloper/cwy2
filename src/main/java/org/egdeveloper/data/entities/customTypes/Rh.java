package org.egdeveloper.data.entities.customTypes;


public enum Rh {
    POSITIVE("Rh+"), NEGATIVE("Rh-");
    private String rh;
    Rh(String rh){
        this.rh = rh;
    }
    public String Rh2String(){
        return rh;
    }
}
