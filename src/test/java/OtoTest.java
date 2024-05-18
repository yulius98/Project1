
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;


public class OtoTest {

    WebDriver homepage;
    //WebDriverWait wait = new WebDriverWait(homepage, Duration.ofSeconds(30) );



    @BeforeTest
    public void OpenWeb()
    {
        System.setProperty("webdriver.chrome.driver","D:\\Document C\\Belajar software tester\\Automatic Test\\TestDemo\\chromedriver.exe");
        ChromeOptions op = new ChromeOptions();
        op.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        //WebDriverManager.chromedriver().setup();
        homepage = new ChromeDriver(op);
        //homepage.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        homepage.navigate().to("https://www.demoblaze.com/index.html");
        homepage.manage().window().maximize();
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@id='nava']")));
    }
    @Test (priority = 1)
    public void Signuptest () throws InterruptedException {
        homepage.findElement(By.xpath("//a[.='Sign up']")).click();
        Thread.sleep(1000);
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h5[@id='signInModalLabel']")));
        homepage.findElement(By.xpath("//input[@id='sign-username']")).sendKeys("fttest1243");
        homepage.findElement(By.xpath("//input[@id='sign-password']")).sendKeys("123456");
        homepage.findElement(By.xpath("//button[.='Sign up']")).click();
        Thread.sleep(1000);
        homepage.switchTo().alert();
        Thread.sleep(3000);
        String actualalert = homepage.switchTo().alert().getText();
        String expecalert = "Sign up successful.";
        System.out.println(homepage.switchTo().alert().getText());
        homepage.switchTo().alert().accept();
        Thread.sleep(3000);
        if (actualalert.equals(expecalert)) {

            homepage.findElement(By.xpath("//button[.='Sign up']")).click();
        }
        else {
            homepage.findElement(By.xpath("//div[@id='signInModal']//button[@class='btn btn-secondary']")).click();
        }

    }
    @Test (priority = 2)
    public void LoginTest() throws InterruptedException {
        homepage.findElement(By.xpath("//a[.='Log in']")).click();
        Thread.sleep(1000);
        homepage.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("tanimbar1243");
        homepage.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("123456");
        homepage.findElement(By.xpath("//button[.='Log in']")).click();
        Thread.sleep(1000);
        try {
            homepage.switchTo().alert();
            Thread.sleep(1000);
            System.out.println(homepage.switchTo().alert().getText());
            homepage.switchTo().alert().accept();
            homepage.findElement(By.xpath("//div[@id='logInModal']//button[@class='btn btn-secondary']")).click();
            homepage.quit();
        } catch (NoAlertPresentException e) {
            System.out.println("Login successful");
        }
    }
    @Test (priority = 3)
    public void AddCart() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(homepage, Duration.ofSeconds(120));

            //add product Samsung galaxy s6
            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@id='cat']")));
            homepage.findElement(By.xpath("//a[.='Samsung galaxy s6']")).click();
            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h2[@class='name']")));
            homepage.findElement(By.xpath("//a[.='Add to cart']")).click();
            Thread.sleep(3000);
            homepage.switchTo().alert();
            Thread.sleep(3000);
            System.out.println("Samsung galaxy s6 " + homepage.switchTo().alert().getText());
            homepage.switchTo().alert().accept();
            homepage.findElement(By.xpath("//a[.='Home (current)']")).click();
            Thread.sleep(3000);

            //add product Sony xperia z5
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@id='cat']")));
            homepage.findElement(By.xpath("//a[.='Sony xperia z5']")).click();
            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h2[@class='name']")));
            homepage.findElement(By.xpath("//a[.='Add to cart']")).click();
            Thread.sleep(3000);
            homepage.switchTo().alert();
            Thread.sleep(3000);
            System.out.println("Sony xperia z " + homepage.switchTo().alert().getText());
            homepage.switchTo().alert().accept();
            homepage.findElement(By.xpath("//a[.='Home (current)']")).click();
            Thread.sleep(3000);

            //add product Sony vaio i5
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@id='cat']")));
            homepage.findElement(By.xpath("//a[.='Laptops']")).click();
            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[.='Sony vaio i5']")));
            homepage.findElement(By.xpath("//a[.='Sony vaio i5']")).click();
            Thread.sleep(3000);
            homepage.findElement(By.xpath("//a[.='Add to cart']")).click();
            Thread.sleep(3000);
            homepage.switchTo().alert();
            Thread.sleep(3000);
            System.out.println("Sony vaio i5 " + homepage.switchTo().alert().getText());
            homepage.switchTo().alert().accept();
            homepage.findElement(By.xpath("//a[.='Home (current)']")).click();
            Thread.sleep(3000);


    }
    @Test (priority = 4)
    public void Payment() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(homepage, Duration.ofSeconds(1000));

        homepage.findElement(By.xpath("//a[@id='cartur']")).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h2[.='Products']")));
        String totalharga = "Total: "+ homepage.findElement(By.xpath("//h3[@id='totalp']")).getText();
        System.out.println(totalharga);
        Thread.sleep(3000);
        homepage.findElement(By.xpath("//button[@class='btn btn-success']")).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h5[@id='orderModalLabel']")));
        String harga = homepage.findElement(By.xpath("//label[@id='totalm']")).getText();
        if (totalharga.equals(harga)) {
                homepage.findElement(By.xpath("//input[@id='name']")).sendKeys("Wijaya");
                homepage.findElement(By.xpath("//input[@id='country']")).sendKeys("Indonesia");
                homepage.findElement(By.xpath("//input[@id='city']")).sendKeys("Jogja");
                homepage.findElement(By.xpath("//input[@id='card']")).sendKeys("54651010");
                Thread.sleep(3000);
                homepage.findElement(By.xpath("//button[.='Purchase']")).click();
                Thread.sleep(3000);
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h2[.='Thank you for your purchase!']")));
                homepage.findElement(By.xpath("//button[@class='confirm btn btn-lg btn-primary']")).click();

        }
        else {
            System.out.println("Total harga beda");
            homepage.findElement(By.xpath("//div[@id='orderModal']//button[@class='btn btn-secondary']")).click();
        }
        homepage.quit();
    }


}
