package Homework.hw6.ex2.Enums;

public enum UserCredentials {
    PITER("epam", "1234", "PITER CHAILOVSKII");

    public String login;
    public String password;
    public String name;

    UserCredentials(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }
}
