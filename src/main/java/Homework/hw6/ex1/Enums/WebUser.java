package Homework.hw6.ex1.Enums;

public enum WebUser {
    PITER_CHAILOVSKII("epam", "1234", "PITER CHAILOVSKII");

    public String login;
    public String password;
    public String name;

    WebUser(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }
}
