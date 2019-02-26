package Homework.hw7.pages;

import Homework.hw7.utils.*;
import Homework.hw7.forms.Header;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.*;

import static org.testng.Assert.*;

public class MetalsAndColorsPage extends WebPage {

    public Header header;

    @Css(".results > li")
    public static WebList results;

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

    public void enterData(FormData data){
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
    }

    public void submitData(){
        submitButton.click();
    }

    public void checkResult(FormData data){
        int sum = Integer.parseInt(data.oddNumber) + Integer.parseInt(data.evenNumber);
        assertEquals(results.get(0).getText(), "Summary: " + sum);
        assertEquals(results.get(1).getText(), "Elements: " + data.forces[0]
                + ", " + data.forces[1]);
        assertEquals(results.get(2).getText(), "Color: " + data.color);
        assertEquals(results.get(3).getText(), "Metal: " + data.metal);
        assertEquals(results.get(4).getText(), "Vegetables: " +
                data.vegetables[0] + ", " + data.vegetables[1]);
    }
}
