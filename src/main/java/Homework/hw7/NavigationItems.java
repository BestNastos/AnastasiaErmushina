package Homework.hw7;

public enum NavigationItems {
    HOME("HOME"),
    CONTACT("CONTACT FORM"),
    SERVICE("\"SERVICE \""),
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
