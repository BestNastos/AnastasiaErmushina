package Homework.hw6.ex2.Enums;

public enum UserTablePageInfo {

    TITLE("User Table");

    String title;

    @Override
    public String toString() {
        return title;
    }

    UserTablePageInfo(String title) {
        this.title = title;
    }
}
