package Homework.hw4.ex1.Enums;

public enum ServiceSubmenuTop {
    SUPPORT("SUPPORT"),
    DATES("DATES"),
    SEARCH("SEARCH"),
    COMPLEX_TABLE("COMPLEX TABLE"),
    SIMPLE_TABLE("SIMPLE TABLE"),
    USER_TABLE("USER TABLE"),
    TABLE_WITH_PAGES("TABLE WITH PAGES"),
    DIFFERENT_ELEMENTS("DIFFERENT ELEMENTS"),
    PERFORMANCE("PERFORMANCE");

    private String text;

    ServiceSubmenuTop(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
