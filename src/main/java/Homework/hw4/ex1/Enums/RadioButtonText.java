package Homework.hw4.ex1.Enums;

public enum RadioButtonText {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    private String text;

    RadioButtonText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
