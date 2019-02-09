package Homework.hw5.ex1.DatesPageWithAllureAnnotations.Enums;

public enum WebUser {
    PITER("epam", "1234", "PITER CHAILOVSKII");

    public String login;
    public String password;
    public String name;

    WebUser(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }
}
