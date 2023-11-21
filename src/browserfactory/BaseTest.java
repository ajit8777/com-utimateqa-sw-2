package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;

/**
 * Create the package ‘browserfactory’ and create the
 * class with the name ‘BaseTest’ inside the
 * ‘browserfactory’ package. And write the browser setup
 * code inside the class ‘Base Test’.
 */
public class BaseTest {

    // Declaring global variable
    static String browser = "Chrome";

    public WebDriver driver;

    //Browser open method
    public void openBrowser(String baseUrl){
        //Declaring multiple browser
        if (browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Internet Explorer")){
            driver = new InternetExplorerDriver();
        } else {
            System.out.println("Wrong browser name");
        }

        driver.get(baseUrl);  // Launch baseUrl
        driver.manage().window().maximize();  // Maximise Url
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //Closing browser method
    public void closeBrowser(){
        driver.quit();
    }
}
