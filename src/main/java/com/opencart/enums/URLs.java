package com.opencart.enums;

public enum URLs {
    BASE_URL("http://localhost:8888/opencart3/index.php");

    private final String value;

    URLs(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }
}



