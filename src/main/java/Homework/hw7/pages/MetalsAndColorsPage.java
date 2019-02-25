package Homework.hw7.pages;

import Homework.hw7.enums.*;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.complex.*;

import static Homework.hw7.enums.NatureForces.Fire;
import static Homework.hw7.enums.NatureForces.Water;

@Url("metals-colors.html") @Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {

//    @Css(".form")
//    public static MetalsColorsForm form;

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

    public void fillForm(DefaultFormData data){
        oddNumbersSummary.select(data.oddNumber);
        evenNumbersSummary.select(data.evenNumber);
        forcesOfNature.get(Water).click();
        forcesOfNature.get(Fire).click();

        colors.select(data.color);
        metals.select(data.metal);
        for (Vegetable vegetable : data.vegetables) {
            vegetables.select(vegetable);
        }
        System.out.println();
    }

    public void checkResult(){

    }

}
