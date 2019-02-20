package Homework.hw7;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Users {
    public static Users PITER = new Users("epam", "1234", "PITER CHAILOVSKII");

    String login;
    String password;
    String fullName;
}
