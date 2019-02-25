package Homework.hw7_Form;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.RadioButtons;

public class MCform extends Form<MC> {

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
    @Css("#submit-button")public Button submit;

    public void m(){

    }

}
