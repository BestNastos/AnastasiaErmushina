package Homework.hw7.utils;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Users {
    String login;
    String password;
    String fullName;

    @Override
    public String toString() {
        return fullName;
    }
}
