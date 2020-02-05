import less_64_67_PageObject.LoginPage;
import less_64_67_PageObject.MainPage;
import less_64_67_PageObject.SignUpPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\seleniumWebDrivers\\chromeDrivers\\chromedriver_79.0.3945.36.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/");
        mainPage = new MainPage(driver);
    }

    @Test
    public void signInTest(){
        LoginPage loginPage = mainPage.clickSignInButton();
        String header = loginPage.getHeaderText();
        Assert.assertEquals("Sign in to GitHub", header);
    }

    @Test
    public void registerFailTest(){
        SignUpPage signUpPage = mainPage.register("qwer", "qwer", "1234qwer");
        Assert.assertEquals("Join GitHub\n" +
                "Create your account", signUpPage.getHeaderText());
        Assert.assertEquals("Username is not available", signUpPage.getUsernameFieldErrorText());
        Assert.assertEquals("Email is invalid or already taken", signUpPage.getEmailFieldErrorText());
        Assert.assertEquals("Password is weak and can be easily guessed", signUpPage.getPasswordFieldErrorText());
    }

    @Test
    public void emptyFields(){
        SignUpPage signUpPage = mainPage.register("", "", "");
        Assert.assertEquals("Username can't be blank", signUpPage.getUsernameFieldErrorText());
        Assert.assertEquals("Email can't be blank", signUpPage.getEmailFieldErrorText());
        Assert.assertEquals("Password can't be blank", signUpPage.getPasswordFieldErrorText());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
