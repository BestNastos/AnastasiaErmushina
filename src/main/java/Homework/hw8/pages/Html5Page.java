package Homework.hw8.pages;

import Homework.hw8.forms.Header;
import Homework.hw8.forms.MetalsAndColorsForm;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.common.DateTimeSelector;

public class Html5Page extends WebPage {

    public Header header;
    public MetalsAndColorsForm metalsAndColorsForm;

    @UI("#birth-date") public static DateTimeSelector birthDate;
}
