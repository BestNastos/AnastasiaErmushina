package Homework.hw7.forms;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.common.Icon;

public class Header extends Section {

    public SignInForm signInForm;

    @XPath("//a[text()='%s']")
    public WebList navigationBar;

    @Css("[id='user-icon']")
    public Icon profileIcon;

    @Css("[id='user-name']")
    public UIElement usernameDisplayed;
}
