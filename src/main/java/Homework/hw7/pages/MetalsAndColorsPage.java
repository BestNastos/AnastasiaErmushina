package Homework.hw7.pages;

import Homework.hw7.forms.MetalsAndColorsForm;
import Homework.hw7.utils.*;
import Homework.hw7.forms.Header;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;

import static org.testng.Assert.*;

public class MetalsAndColorsPage extends WebPage {

    public Header header;
    public MetalsAndColorsForm metalsAndColorsForm;

    @Css(".results > li")
    private WebList results;

    public void checkResult(MetalsAndColorsData data) {
        int sum = Integer.parseInt(data.oddNumber) + Integer.parseInt(data.evenNumber);
        assertEquals(results.get(0).getText(), "Summary: " + sum);
        assertEquals(results.get(1).getText(), "Elements: " + data.forces[0]
                + ", " + data.forces[1]);
        assertEquals(results.get(2).getText(), "Color: " + data.color);
        assertEquals(results.get(3).getText(), "Metal: " + data.metal);
        assertEquals(results.get(4).getText(), "Vegetables: " +
                data.vegetables[0] + ", " + data.vegetables[1]);
    }
}
