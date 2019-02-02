package Homework.hw3;

public enum HomePageData {

    URL("https://epam.github.io/JDI/index.html"),
    HOME_PAGE_TITLE("Home Page"),
    SUBHEADER("JDI GITHUB"),
    SUBHEADER_LINK("https://github.com/epam/JDI"),
    MAIN_HEADER1("EPAM FRAMEWORK WISHES…"),
    MAIN_HEADER2("LOREM IPSUM DOLOR SIT AMET, " +
            "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT " +
            "UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS " +
            "NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO " +
            "CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT " +
            "ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

    String value;

    HomePageData(String value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}
