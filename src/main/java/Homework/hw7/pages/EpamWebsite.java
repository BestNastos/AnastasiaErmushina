package Homework.hw7.pages;

import Homework.hw7_Form.MCform;
import Homework.TRYmain.ContactForm;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;

@JSite("https://epam.github.io/JDI/")
public class EpamWebsite {
    public static MetalsAndColorsPage metalsAndColorsPage;

    @Url("index.html") @Title("Home Page")
    public static HomePage homePage;

    @Url("metals-colors.html") @Title("Metal and Colors")
    public static MCform MCform;

    @Url("contacts.html") @Title("Contact Form")
    public static ContactForm contactForm;
}
