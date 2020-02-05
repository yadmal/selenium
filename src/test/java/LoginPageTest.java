import less_64_67_PageObject.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\seleniumWebDrivers\\chromeDrivers\\chromedriver_79.0.3945.36.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithEmptyFields(){
        loginPage.loginWithInvalidFields("", "");
        Assert.assertEquals("Incorrect username or password.", loginPage.getErrorText());
    }

    @Test
    public void loginWithInvalidFields(){
        loginPage.loginWithInvalidFields("fdsafas", "1234sgf");
        Assert.assertEquals("Incorrect username or password.", loginPage.getErrorText());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
