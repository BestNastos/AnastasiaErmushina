package Homework.hw8.utils;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Users {
    String login;
    String password;
    public String fullName;

    @Override
    public String toString() {
        return fullName;
    }
}
