package Homework.hw8;

import Homework.hw8.pages.EpamWebsite;
import Homework.hw8.utils.MetalsColorsFormData;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static Homework.hw8.pages.EpamWebsite.homePage;
import static Homework.hw8.pages.EpamWebsite.metalsAndColorsPage;
import static Homework.hw8.utils.Defaults.PITER;
import static Homework.hw8.utils.NavigationItems.METALS_COLORS;

public class JdiWithDataProviderTest {
    @BeforeMethod
    public void beforeSuite() {
        PageFactory.initElements(EpamWebsite.class);
        homePage.open();
    }

    @AfterMethod
    public void afterSuite() {
        WebDriverFactory.close();
    }

    @Test(dataProvider = "provideData")
    public void metalsAndColorsPageTest(MetalsColorsFormData data) {
        // 1. Login on JDI site as User
        homePage.login(PITER);

        // 2. Open Metals & Colors page by Header menu
        homePage.openMenuItem(METALS_COLORS);

        // 3. Fill form Metals & Colors by data
        // Submit form Metals & Colors
        metalsAndColorsPage.metalsAndColorsForm.submit(data);

        // 4. Result sections should contain data
        metalsAndColorsPage.checkResult(data);
    }

    @DataProvider
    public Object[][] provideData() throws FileNotFoundException {
        JsonObject jsonObject = new JsonParser()
                .parse(new FileReader("src/test/resources/JDI_ex8_metalsColorsDataSet.json"))
                .getAsJsonObject();
        Object[][] returnedArray = new Object[jsonObject.size()][1];
        for (int i = 0; i < returnedArray.length; i++) {
            returnedArray[i][0] = new Gson()
                    .fromJson(jsonObject.get("data_" + (i + 1)), new TypeToken<MetalsColorsFormData>() {
                    }.getType());
        }
        return returnedArray;
    }
}
