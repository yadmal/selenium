package less_60_upload_files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UploadFilesMainClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\seleniumWebDrivers\\chromeDrivers\\chromedriver_79.0.3945.36.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://images.google.ru/");
        WebElement icon = driver.findElement(By.xpath("//*[@id=\"sbtc\"]/div/div[3]/div[1]/span"));
        icon.click();
        WebElement uploadTitle = driver.findElement(By.xpath("//*[@id=\"qbug\"]/div/a"));
        uploadTitle.click();
        WebElement uploadButton = driver.findElement(By.id("qbfile"));

        // нет необходимости нажимать на кнопку загрузить файл, можно сразу вопспользоваться методом sendKeys()
        uploadButton.sendKeys("D:\\github\\selenium\\src\\main\\java\\less_60_upload_files\\test.png");

        driver.quit();
    }
}
