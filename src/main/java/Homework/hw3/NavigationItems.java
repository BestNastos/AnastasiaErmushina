package Homework.hw3;

public enum NavigationItems {
    HOME("HOME"),
    CONTACT("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS("METALS & COLORS");

    String value;

    NavigationItems(String value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}
