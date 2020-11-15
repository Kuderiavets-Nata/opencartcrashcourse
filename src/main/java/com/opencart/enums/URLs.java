package com.opencart.enums;

public enum URLs {
    BASE_URL("http://localhost/opencart/upload/index.php"),
    TEMP_MAILS_URL("https://www.1secmail.com/api/v1/?action="),
    ADMIN_PAGE_URL("http://localhost/opencart/upload/admin/");

    private final String value;

    URLs(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
