package Homework.hw7.utils;

public abstract class Defaults {

    private static String[] forces = {"Water", "Fire"};
    private static String[] vegetables = {"Cucumber", "Tomato"};

    public static FormData DEFAULT_DATA =
            new FormData("3", "8", forces, "Red", "Selen", vegetables);

    public static Users PITER = new Users("epam", "1234", "PITER CHAILOVSKII");
}
