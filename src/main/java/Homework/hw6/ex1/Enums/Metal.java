package Homework.hw6.ex1.Enums;

public enum Metal {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    private String text;

    Metal(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
