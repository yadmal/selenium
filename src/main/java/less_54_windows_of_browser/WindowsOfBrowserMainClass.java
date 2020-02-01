package less_54_windows_of_browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WindowsOfBrowserMainClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\seleniumWebDrivers\\chromeDrivers\\chromedriver_79.0.3945.36.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        chromeDriver.get("https://www.oracle.com/technetwork/java/javase/downloads/2133151");

        WebElement link = chromeDriver.findElement(By.xpath("//table[@class='downloadBox']//a[text()='Oracle Technology Network License Agreement for Oracle Java SE']"));
        String mainWindowTitle = chromeDriver.getWindowHandle();
        link.click();
        for(String windowHandle : chromeDriver.getWindowHandles()){
            chromeDriver.switchTo().window(windowHandle);
        }
        chromeDriver.findElement(By.xpath("//div[@class='u28s1']//a[@class='u28ham']")).click();
        chromeDriver.switchTo().window(mainWindowTitle);
        chromeDriver.findElement(By.xpath("//ul[@class='level01']//a[@class='level01_top_link_subnav']//div[text()='Java SE']")).click();

        chromeDriver.quit();
    }
}
