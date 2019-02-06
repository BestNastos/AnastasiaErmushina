package Homework.hw4.ex1.Enums;

public enum CheckBoxText {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    private String txt;

    CheckBoxText(String txt) {
        this.txt = txt;
    }

    @Override
    public String toString() {
        return txt;
    }
}
