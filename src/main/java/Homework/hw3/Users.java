package Homework.hw3;

public enum Users {
    PITER("epam", "1234", "PITER CHAILOVSKII");

    String login;
    String password;
    String name;

    Users(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }
}
