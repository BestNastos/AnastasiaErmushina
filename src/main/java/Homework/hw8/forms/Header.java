package Homework.hw8.forms;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.common.Icon;
import com.epam.jdi.light.ui.html.complex.Menu;

public class Header extends Section {

    public SignInForm signInForm;

    @XPath("//a[text()='%s']")
    public Menu navigationBar;

    @Css("#user-icon")
    public Icon profileIcon;

    @Css("#user-name")
    public UIElement usernameDisplayed;
}
