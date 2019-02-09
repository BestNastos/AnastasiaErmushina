package Homework.hw5.ex1.DiffElementsPageWithAllureAnnotations.Enums;

public enum HomePageInfo {

    URL("https://epam.github.io/JDI/index.html"),
    HOME_PAGE_TITLE("Home Page");

    private String value;

    HomePageInfo(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
