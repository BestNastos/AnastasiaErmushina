package Homework.hw6.ex1.Enums;

public enum ForceOfNature {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    private String txt;

    ForceOfNature(String txt) {
        this.txt = txt;
    }

    @Override
    public String toString() {
        return txt;
    }
}
