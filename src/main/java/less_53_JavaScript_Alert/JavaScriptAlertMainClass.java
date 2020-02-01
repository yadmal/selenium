package less_53_JavaScript_Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class JavaScriptAlertMainClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\seleniumWebDrivers\\chromeDrivers\\chromedriver_79.0.3945.36.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        chromeDriver.manage().window().maximize();

        chromeDriver.get("https://www.oracle.com/technetwork/java/javase/downloads/2133151");
        chromeDriver.findElement(By.xpath("//a[text()='jdk-8u241-windows-x64.exe']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Нажимаем на "Ок"
        chromeDriver.switchTo().alert().accept();

        JavascriptExecutor jse = (JavascriptExecutor)chromeDriver;
        jse.executeScript("confirm('Are you ready?');");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Нажимаем на "нет"
        chromeDriver.switchTo().alert().dismiss();
        chromeDriver.quit();
    }
}
