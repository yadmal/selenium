package less_64_67_PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class PageObjectMainPageMainClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\seleniumWebDrivers\\chromeDrivers\\chromedriver_79.0.3945.36.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://github.com/");

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.register("asdfasdf", "sadf@asdf.com", "asdfasdf325");
    }
}
