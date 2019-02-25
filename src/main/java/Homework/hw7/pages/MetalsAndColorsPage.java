package Homework.hw7.pages;

import Homework.hw7.enums.*;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.base.HtmlRadioGroup;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.*;
import org.testng.Assert;

import static Homework.hw7.enums.NatureForces.Fire;
import static Homework.hw7.enums.NatureForces.Water;
import static Homework.hw7.enums.Vegetable.*;
import static org.testng.Assert.*;

@Url("metals-colors.html") @Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {

    @Css(".results > li")
    public static WebList results;

    @Css("[id='odds-selector']")
    public static RadioButtons oddNumbersSummary;

    @Css("[id='even-selector']")
    public static RadioButtons evenNumbersSummary;

    @Css("[id='elements-checklist'] > p > label")
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
            value = "dropdown-menu",
            list = "li",
            expand = ".caret")
    public static Droplist vegetables;

    @Css("#submit-button")
    public static Button submitButton;

    public void fillForm(DefaultFormData data){
        oddNumbersSummary.select(data.oddNumber);
        evenNumbersSummary.select(data.evenNumber);
        for (NatureForces force : data.forces) {
            forcesOfNature.select(force);
        }
        colors.select(data.color);
        metals.select(data.metal);
        vegetables.select(Vegetables);
        for (Vegetable vegetable : data.vegetables) {
            vegetables.select(vegetable);
        }
    }

    public void verifyForm(DefaultFormData data){
//        forcesOfNature.elements().get(0).isSelected()
//        metals.getSelected();
//        colors.getSelected();
    }

    public void submitForm(){
        submitButton.click();
    }

    public void checkResult(DefaultFormData data){
        int sum = Integer.parseInt(data.oddNumber) + Integer.parseInt(data.evenNumber);
        assertEquals(results.get(0).getText(), "Summary: " + sum);
        assertEquals(results.get(1).getText(), "Elements: " + data.forces[0].value
                + ", " + data.forces[1].value);
        assertEquals(results.get(2).getText(), "Color: " + data.color.value);
        assertEquals(results.get(3).getText(), "Metal: " + data.metal.value);
        assertEquals(results.get(4).getText(), "Vegetables: " +
                data.vegetables[0].value + ", " + data.vegetables[1].value);
    }

}
