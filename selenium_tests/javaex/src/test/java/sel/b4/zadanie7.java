package sel.b4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class zadanie7 {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
        }

    @Test
    public void login_admin() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        List<WebElement> list1 = driver.findElements(By.xpath("//ul[@id='box-apps-menu']/li"));
        List<WebElement> list2 = driver.findElements(By.xpath("//ul[@class='docs']/li"));

        for(int i=0; i < list1.size(); i++) {
            list1 = driver.findElements(By.xpath("//ul[@id='box-apps-menu']/li"));
            list1.get(i).click();
            Assert.assertTrue(driver.findElement(By.cssSelector("h1")).isDisplayed());
            list2 = driver.findElements(By.xpath("//ul[@class='docs']/li"));
            if (list2.size() != 0) {
                for(int j=0; j < list2.size(); j++) {
                    list2 = driver.findElements(By.xpath("//ul[@class='docs']/li"));
                    list2.get(j).click();
                    Assert.assertTrue(driver.findElement(By.cssSelector("h1")).isDisplayed());
                }
            }
        }
    }

    @After
    public void stop () {
        driver.quit();
        driver = null;
    }
}
