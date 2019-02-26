package Homework.hw7.pages;

import Homework.hw7.utils.NavigationItems;
import Homework.hw7.utils.Users;
import Homework.hw7.forms.Header;
import com.epam.jdi.light.elements.composite.WebPage;

public class HomePage extends WebPage {

    public Header header;

    public void login(Users user) {
        header.profileIcon.click();
        header.signInForm.loginAs(user);
    }

    public void openMenuItem(NavigationItems item){
        header.navigationBar.select(item.toString());
    }
}
