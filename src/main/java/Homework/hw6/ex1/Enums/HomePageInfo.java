package Homework.hw6.ex1.Enums;

public enum HomePageInfo {

    URL("https://epam.github.io/JDI/index.html"),
    TITLE("Home Page");

    private String value;

    HomePageInfo(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
