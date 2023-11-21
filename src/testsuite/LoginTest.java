package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/** Create the package ‘testsuite’ and create the
 following class inside the ‘testsuite’ package.
 1. LoginTest
 3. Write down the following test into ‘LoginTest’ class
 1. userShouldNavigateToLoginPageSuccessfully *
 click on the ‘Sign In’ link
 * Verify the text ‘Welcome Back!’
 2. verifyTheErrorMessage
 * click on the ‘Sign In’ link
 * Enter invalid username
 * Enter invalid password
 * Click on Login button
 * Verify the error message ‘Invalid email or password.’
*/
 public class LoginTest extends BaseTest {

    // Declare baseUrl
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully()
    {
        // click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        // Verify the text ‘Welcome Back!’
        String expectedText = "Welcome Back!";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[@class='page__heading']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    public void verifyTheErrorMessage() throws InterruptedException {
        // click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        //Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("ajitpatel5@gmail.com");
        // Enter invalid password
        driver.findElement(By.name("user[password]")).sendKeys("ajitpatel5");
        // Click on Login button
        driver.findElement(By.xpath("//button[@data-callback='onSubmit']")).click();
        Thread.sleep(8000);
        // Verify the error message ‘Invalid email or password.’
        String expectedText = "Invalid email or password.";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='notice__form-error']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText,actualText);


    }
    // Closing browser
    @After
    public void closingBrowser() {
        closeBrowser();
    }
}
