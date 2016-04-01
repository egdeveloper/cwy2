package org.egdeveloper.data.entities.custom_types;


public enum TestMethod {
    IN_VIVO("in vivo"), IN_VITRO("in vitro");
    private String testMethod;
    TestMethod(String testMethod){
        this.testMethod = testMethod;
    }
}
