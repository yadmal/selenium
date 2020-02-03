package less_59_screenshots;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ScreenshotsMainClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\seleniumWebDrivers\\chromeDrivers\\chromedriver_79.0.3945.36.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://yandex.ru/");

        WebElement search = driver.findElement(By.id("text"));
        search.sendKeys("some text");
        search.sendKeys(Keys.ENTER);

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh_mm_ss");
        String fileName = format.format(dateNow) + ".png";

        try {
            FileHandler.copy(screenshot, new File("D:\\github\\selenium\\src\\main\\java\\less_59_screenshots\\" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
