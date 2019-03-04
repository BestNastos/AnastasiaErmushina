package Homework.hw8;

import Homework.hw8.pages.EpamWebsite;
import Homework.hw8.utils.MetalsColorsFormData;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

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
        JsonObject jsonMap = new JsonParser()
                .parse(new FileReader("src/test/resources/JDI_ex8_metalsColorsDataSet.json"))
                .getAsJsonObject();
        Object[][] returnedArray = new Object[jsonMap.size()][1];
        int i= 0;
        for (Map.Entry<String, JsonElement> entry : jsonMap.entrySet()) {
            returnedArray[i++][0] = new Gson()
                    .fromJson(entry.getValue(), MetalsColorsFormData.class);
        }
        return returnedArray;
    }
}
