package Homework.hw7.enums;

import lombok.AllArgsConstructor;
import lombok.Data;

import static Homework.hw7.enums.Color.*;
import static Homework.hw7.enums.EvenNum.*;
import static Homework.hw7.enums.Metal.*;
import static Homework.hw7.enums.NatureForces.*;
import static Homework.hw7.enums.OddNum.*;
import static Homework.hw7.enums.Vegetable.*;

public class DefaultFormData {
    public String oddNumber = Three.value;
    public String evenNumber = Eight.value;
    public NatureForces[] forces = {Water, Fire};
    public Color color = Red;
    public Metal metal = Selen;
    public Vegetable[] vegetables = {Vegetables, Cucumber, Tomato};
}
