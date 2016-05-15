package org.egdeveloper.data.entities.customTypes;


public enum Gender {
    MALE("мужской"), FEMALE("женский");
    private String gender;
    private Gender(String gender){
        this.gender = gender;
    }
    public String gender2String(){
        return gender;
    }
}
