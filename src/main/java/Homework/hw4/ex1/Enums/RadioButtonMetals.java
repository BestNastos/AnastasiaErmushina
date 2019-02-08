package Homework.hw4.ex1.Enums;

public enum RadioButtonMetals {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    private String text;

    RadioButtonMetals(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
