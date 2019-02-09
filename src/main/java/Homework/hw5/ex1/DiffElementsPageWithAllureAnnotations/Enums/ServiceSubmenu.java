package Homework.hw5.ex1.DiffElementsPageWithAllureAnnotations.Enums;

public enum ServiceSubmenu {
    SUPPORT("SUPPORT"),
    DATES("DATES"),
    COMPLEX_TABLE("COMPLEX TABLE"),
    SIMPLE_TABLE("SIMPLE TABLE"),
    USER_TABLE("USER TABLE"),
    TABLE_WITH_PAGES("TABLE WITH PAGES"),
    DIFFERENT_ELEMENTS("DIFFERENT ELEMENTS"),
    PERFORMANCE("PERFORMANCE");

    private String text;

    ServiceSubmenu(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
