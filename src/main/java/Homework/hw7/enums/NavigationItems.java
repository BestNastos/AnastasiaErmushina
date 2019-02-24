package Homework.hw7.enums;

public enum NavigationItems {
    HOME("Home"),
    CONTACT("Contact form"),
    SERVICE("\"Service \""),
    METALS_COLORS("Metals & Colors");

    String value;

    NavigationItems(String value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}
