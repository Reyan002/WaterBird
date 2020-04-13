package com.practiceandroid.waterbird.Classes;

public class Test {
    private String name;
    private String controlLimit;
    private String value;

    public Test(String name, String controlLimit, String value) {
        this.name = name;
        this.controlLimit = controlLimit;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getControlLimit() {
        return controlLimit;
    }

    public void setControlLimit(String controlLimit) {
        this.controlLimit = controlLimit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

