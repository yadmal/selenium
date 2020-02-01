package less_55_inlay_of_browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InlayOfBrowserMainClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\seleniumWebDrivers\\chromeDrivers\\chromedriver_79.0.3945.36.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        chromeDriver.get("https://iz.ru/");
        // запомнить название главной страницы
        String izMain = chromeDriver.getWindowHandle();

        chromeDriver.findElement(By.xpath("//a[@class='top-panel-inside__bottom__right__logos__item rentv']")).click();

        // перебор открытых вкладок, выбираем последнюю, которую открыли кликом на ссылку
        for (String inlay : chromeDriver.getWindowHandles()){
            chromeDriver.switchTo().window(inlay);
        }
        // переход по ссылке на новой вкладке
        chromeDriver.findElement(By.xpath("//span[text()='Мнения']")).click();
        // возвращение по имени вкладки на главную страницу (первую)
        chromeDriver.switchTo().window(izMain);
        chromeDriver.findElement(By.xpath(".//a[@class='search']")).click();
        chromeDriver.findElement(By.xpath(".//input[@id='edit-text']")).sendKeys("Hello!");
        chromeDriver.findElement(By.xpath(".//input[@id='edit-submit']")).submit();
        chromeDriver.quit();

    }
}
