package Homework.hw7.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;

@JSite("https://epam.github.io/JDI/")
public class EpamWebsite {

    @Url("index.html") @Title("Home Page")
    public static HomePage homePage;

    @Url("metals-colors.html") @Title("Metal and Colors")
    public static MetalsAndColorsPage metalsAndColorsPage;
}
