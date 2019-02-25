package Homework.hw7.enums;

public enum Metal {

    Metals("Metals"),
    Gold("Gold"),
    Silver("Silver"),
    Bronze("Bronze"),
    Selen("Selen");

    public final String value;

    Metal(String value) {
        this.value = value;
    }
}
