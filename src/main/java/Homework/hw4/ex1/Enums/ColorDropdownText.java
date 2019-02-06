package Homework.hw4.ex1.Enums;

public enum ColorDropdownText {

    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    private String colorText;

    ColorDropdownText(String colorText) {
        this.colorText = colorText;
    }

    @Override
    public String toString() {
        return colorText;
    }
}
