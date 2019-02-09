package Homework.hw5.ex1.DiffElementsPageWithAllureAnnotations.Enums;

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
