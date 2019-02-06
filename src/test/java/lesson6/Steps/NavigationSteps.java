package lesson6.Steps;

import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.Given;

public class NavigationSteps {

    private static final String IND_PAGE_URL = "https://epam.github.io/JDI/index.html";

        @Given("^I open EPAM JDI site$")
        public void iOpen(){
            Selenide.open(IND_PAGE_URL);
        }
}
