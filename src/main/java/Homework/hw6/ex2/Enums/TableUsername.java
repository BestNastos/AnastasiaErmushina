package Homework.hw6.ex2.Enums;

public enum TableUsername {

    ROMAN("Roman"),
    SERGEY_IVAN("Sergey Ivan"),
    VLADZIMIR("Vladzimir"),
    HELEN_BENNETT("Helen Bennett"),
    YOSHI_TANNAMURI("Yoshi Tannamuri"),
    GIOVANNI_ROVELLI("Giovanni Rovelli");

    String username;

    TableUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return username;
    }
}
