package com.opencart.enums;

public enum AdminNavigationMenuButtons {
    DASHBOARD("menu-dashboard"),
    CATALOG("menu-catalog"),
    EXTENSIONS("menu-extension"),
    DESIGN("menu-design"),
    SALES("menu-sale"),
    CUSTOMERS("menu-customer"),
    MARKETING("menu-marketing"),
    SYSTEM("menu-system"),
    REPORTS("menu-report");

    private String id;

    AdminNavigationMenuButtons(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
