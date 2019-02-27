package Homework.hw7.forms;

import Homework.hw7.utils.MetalsAndColorsData;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.RadioButtons;

public class MetalsAndColorsForm extends Form<MetalsAndColorsData> {

    @Css("#odds-selector")
    public static RadioButtons oddNumbersSummary;

    @Css("#even-selector")
    public static RadioButtons evenNumbersSummary;

    @Css("#elements-checklist > p > label")
    public static WebList forcesOfNature;

    @JDropdown(root = "div[ui=dropdown]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Droplist colors;

    @JDropdown(root = "div[ui=combobox]",
            value = "input",
            list = "li",
            expand = ".caret")
    public static Droplist metals;

    @JDropdown(root = "div[ui=droplist]",
            value = ".dropdown-toggle",
            list = "li",
            expand = ".caret")
    public static Droplist vegetables;

    @Css("#submit-button")
    public static Button submitButton;

    @Override
    public void submit(MetalsAndColorsData data) {
        oddNumbersSummary.select(data.oddNumber);
        evenNumbersSummary.select(data.evenNumber);
        for (String force : data.forces) {
            forcesOfNature.select(force);
        }
        colors.select(data.color);
        metals.select(data.metal);
        vegetables.select(vegetables.getSelected());
        for (String vegetable : data.vegetables) {
            vegetables.select(vegetable);
        }
        submitButton.click();
    }
}
