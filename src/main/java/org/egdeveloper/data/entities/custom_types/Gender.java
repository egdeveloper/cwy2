package org.egdeveloper.data.entities.custom_types;

/**
 * Created by egdeveloper on 17.11.15.
 */
public enum Gender {
    MALE("мужской"), FEMALE("женский");
    private String gender;
    private Gender(String gender){
        this.gender = gender;
    }
}
