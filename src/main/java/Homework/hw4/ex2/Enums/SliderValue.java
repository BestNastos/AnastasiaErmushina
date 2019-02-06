package Homework.hw4.ex2.Enums;

public enum SliderValue {

    ZERO(0),
    HUNDRED(100),
    SEVENTY(70),
    THIRTY(30);

    public final int value;

    SliderValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
