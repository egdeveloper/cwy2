package org.egdeveloper.data.entities.custom_types;

/**
 * Created by egdeveloper on 17.11.15.
 */
public enum Rh {
    POSITIVE("Rh+"), NEGATIVE("Rh-");
    private String rh;
    private Rh(String rh){
        this.rh = rh;
    }
}
