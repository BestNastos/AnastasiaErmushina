package lesson6.Steps;

import base.lesson6.SelenideIndexPage;
import cucumber.api.java.en.When;

public class ActionSteps {

    //only steps for actions: login, move slider etc, which provide results

    @When("^I login as user '([^\"]*)' with password '([^\"]*)'$") // ([^"]*)
    public void iLogin(String userName, String psw){
        new SelenideIndexPage().login(userName, psw);
    }

//    @When("^I login as user '[^\"]*'$")
//    public void iLoginAs(Users user){
//        // to complete
////        new SelenideIndexPage().login(user);
//    }
}
