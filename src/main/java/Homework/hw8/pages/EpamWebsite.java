package Homework.hw8.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;

@JSite("https://epam.github.io/JDI/")
public class EpamWebsite {

    @Url("metals-colors.html")
    @Title("Metal and Colors")
    public static MetalsAndColorsPage metalsAndColorsPage;

    @Url("index.html")
    @Title("Home Page")
    public static HomePage homePage;


    @Url("html5.html")
    @Title("html5 Page")
    public static Html5Page html5page;
}
