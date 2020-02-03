package less_57_presence_of_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PresenceOfElementsMainClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\seleniumWebDrivers\\chromeDrivers\\chromedriver_79.0.3945.36.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://yandex.ru");
        if (driver.findElements(By.xpath("//a")).size() > 0){
            System.out.println("Such elements is presented. There are " + driver.findElements(By.xpath("//a")).size() + " elements.");
        } else{
            System.out.println("Cannot find such elements");
        }

        driver.quit();
    }
}
