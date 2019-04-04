package Homework.hw4.ex1.Enums;

public enum ServiceSubmenuLeft {
    SUPPORT("SUPPORT"),
    DATES("DATES"),
    COMPLEX_TABLE("COMPLEX TABLE"),
    SIMPLE_TABLE("SIMPLE TABLE"),
    SEARCH("SEARCH"),
    USER_TABLE("USER TABLE"),
    TABLE_WITH_PAGES("TABLE WITH PAGES"),
    DIFFERENT_ELEMENTS("DIFFERENT ELEMENTS"),
    PERFORMANCE("PERFORMANCE");

    private String text;

    ServiceSubmenuLeft(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
