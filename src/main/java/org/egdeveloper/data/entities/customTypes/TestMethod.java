package org.egdeveloper.data.entities.customTypes;


public enum TestMethod {
    IN_VIVO("in vivo"), IN_VITRO("in vitro");
    private String testMethod;
    TestMethod(String testMethod){
        this.testMethod = testMethod;
    }
}
