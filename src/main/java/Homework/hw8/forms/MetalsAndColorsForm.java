package Homework.hw8.forms;

import Homework.hw8.utils.MetalsColorsFormData;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.RadioButtons;

public class MetalsAndColorsForm extends Form<MetalsColorsFormData> {

    @Css("#odds-selector")
    public RadioButtons oddNumbersSummary;

    @Css("#even-selector")
    public RadioButtons evenNumbersSummary;

    @Css("#elements-checklist > p > label")
    public WebList forcesOfNature;

    @JDropdown(root = "div[ui=dropdown]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Droplist colors;

    @JDropdown(root = "div[ui=combobox]",
            value = "input",
            list = "li",
            expand = ".caret")
    public Droplist metals;

    @JDropdown(root = "div[ui=droplist]",
            value = ".dropdown-toggle",
            list = "li",
            expand = ".caret")
    public Droplist vegetables;

    @Css("#submit-button")
    public Button submitButton;

    @Override
    public void submit(MetalsColorsFormData data) {
        oddNumbersSummary.select(String.valueOf(data.summary.get(0)));
        evenNumbersSummary.select(String.valueOf(data.summary.get(1)));
        for (String force : data.elements) {
            forcesOfNature.select(force);
        }
        colors.select(data.color);
        metals.select(data.metals);
        vegetables.select(vegetables.getSelected());
        for (String vegetable : data.vegetables) {
            vegetables.select(vegetable);
        }
        submitButton.click();
    }
}
