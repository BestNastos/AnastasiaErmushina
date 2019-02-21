package Homework.hw7.pages;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.complex.Checklist;
import com.epam.jdi.light.ui.html.complex.RadioButtons;

public class MetalsAndColorsPage extends WebPage {

    @Css("[id='odds-selector']")
    public static RadioButtons oddNumbersSummary;

    @Css("[id='even-selector']")
    public static RadioButtons evenNumbersSummary;

    @Css("[id='elements-checklist']")
    public static Checklist forcesOfNature;

    @JDropdown(root = "div[ui=dropdown]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Droplist colors;




}
