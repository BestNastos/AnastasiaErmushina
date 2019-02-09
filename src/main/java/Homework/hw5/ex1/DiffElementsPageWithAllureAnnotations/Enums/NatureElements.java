package Homework.hw5.ex1.DiffElementsPageWithAllureAnnotations.Enums;

public enum NatureElements {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    private String txt;

    NatureElements(String txt) {
        this.txt = txt;
    }

    @Override
    public String toString() {
        return txt;
    }
}
