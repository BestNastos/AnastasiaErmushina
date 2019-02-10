package Homework.hw6.ex2.Steps;

import Homework.hw6.ex2.Enums.UserTablePageInfo;
import Homework.hw6.ex2.UserTablePage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

import static com.codeborne.selenide.Selenide.page;

public class AssertionSteps {
    private UserTablePage userTablePage = page(UserTablePage.class);

    @Then("^'([^\"]*)' page is opened$")
    public void userTablePageIsOpened(UserTablePageInfo title){
        userTablePage.checkTitle(title);
    }

    @Then("^User table contains following values:$")
    public void userTableContainsValues(DataTable dataTable){
        userTablePage.checkUserTableContainsElements(dataTable);
    }


}
