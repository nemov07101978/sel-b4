package sel.b4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class login_litecart_admin {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        //WebDriver chromeDriver = new ChromeDriver();
        //WebDriver ieDriver = new InternetExplorerDriver();
        //WebDriver firefoxDriver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void login_admin() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @After
    public void stop () {
        driver.quit();
        driver = null;
    }
}
