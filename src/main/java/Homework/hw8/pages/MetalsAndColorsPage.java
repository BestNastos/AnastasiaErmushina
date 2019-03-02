package Homework.hw8.pages;

import Homework.hw8.forms.Header;
import Homework.hw8.forms.MetalsAndColorsForm;
import Homework.hw8.utils.MetalsColorsFormData;
import com.epam.jdi.light.elements.base.BaseUIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static Homework.hw8.utils.MetalsColorsFormData.*;
import static org.testng.Assert.assertEquals;

public class MetalsAndColorsPage extends WebPage {

    public Header header;
    public MetalsAndColorsForm metalsAndColorsForm;

    @Css(".results > li")
    private WebList results;

    public void checkResult(MetalsColorsFormData data) {
        List<String> actual = results.stream().map(BaseUIElement::getText).collect(Collectors.toList());
        List<String> expected = Arrays.asList(
                "Summary: " + (data.summary.get(0) + data.summary.get(1)),
                "Elements: " + listToStringWithoutBrackets(data.elements),
                "Color: " + data.color,
                "Metal: " + data.metals,
                "Vegetables: " + listToStringWithoutBrackets(data.vegetables));
        assertEquals(expected, actual);
    }
}
