package Homework.hw7.forms;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;

public class Header extends Section {

    @FindBy(xpath = "//a[text()='%s']") //a[text()='Metals & Colors'] //li:nth-child(4)
    public WebList serviceMenu; //TODO WebPage or Link?

}
