package HomeWorkFinal;

import io.github.bonigarcia.wdm.WebDriverManager;
import object.Header;
import object.HomePage;
import object.LoginPage;
import object.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class ExerciseTests {

    private WebDriver driver;

    @BeforeSuite
    protected final void setupTestSuite() {
        WebDriverManager.edgedriver().setup();
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    public final void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public final void tearDawnTest() {
        if (this.driver != null) {
            this.driver.quit();
        }
//            driver.close();
    }

    @DataProvider(name = "getUsers")
    public Object[][] getUsers(){
        return new Object[][]{{"bk7777" , "12345678910"}
        };
    }

    @Test(invocationCount = 1)
    public void testSkilloLogoHomePageGestUser() {

        driver.get("http://training.skillo-bg.com/posts/all");
        WebElement homeLogo = driver.findElement(By.id("homeIcon"));
       Assert.assertTrue(homeLogo.isDisplayed(), "Logo is not displayed!");
    }

    @Test(invocationCount = 1)
    public void testSkilloLogoSignInPage() {

        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();

        Header header = new Header(driver);
        header.clickLogin();

        driver.get("http://training.skillo-bg.com/users/login");
        WebElement homeLogo = driver.findElement(By.id("homeIcon"));
        Assert.assertTrue(homeLogo.isDisplayed(), ("Logo is not displayed"));


    }

    @Test(dataProvider = "getUsers")
    public void testSkilloLogoHomePageRegisterUser(String name,String password) {

        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();

        Header header = new Header(driver);
        header.clickLogin();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isUrlLoaded(),"Login URL is not correct");

        String signInText = loginPage.getSignInElementText();
        Assert.assertEquals(signInText,"Sign in");

        loginPage.userName(name);

        loginPage.userPassword(password);

        loginPage.clickSignIn();

        Assert.assertTrue(homePage.isUrlLoaded(), "Home URl is not correct");

        driver.get("http://training.skillo-bg.com/posts/all");
        WebElement homeLogo = driver.findElement(By.id("homeIcon"));
        Assert.assertTrue(homeLogo.isDisplayed(), "Logo is not displayed!");

    }

    @Test(dataProvider = "getUsers")
    public void testSkilloLogoProfilePage(String name,String password) {

        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();

        Header header = new Header(driver);
        header.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isUrlLoaded(),"Login URL is not correct");

        String signInText = loginPage.getSignInElementText();
        Assert.assertEquals(signInText,"Sign in");

        loginPage.userName(name);

        loginPage.userPassword(password);

        loginPage.clickSignIn();
        Assert.assertTrue(homePage.isUrlLoaded(), "Home URl is not correct");

        header.clickProfile();

//        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com/users/4694"));

//        WebElement userNameElement = driver.findElement(By.tagName("h2"));
//        String actualUserName = userNameElement.getText();
//        String expectedUserName = "bk7777";
//        Assert.assertEquals(actualUserName, expectedUserName, "User name is incorrect");
        ProfilePage profilePage = new ProfilePage(driver);
        Assert.assertTrue(profilePage.isUrlLoaded(),"Profile URL is not correct");

        driver.get("http://training.skillo-bg.com:4300/users/4694");
        WebElement homeLogo = driver.findElement(By.id("homeIcon"));
        Assert.assertTrue(homeLogo.isDisplayed(), "Logo is not displayed!");
    }

    @Test(dataProvider = "getUsers")
    public void testSkilloLogoNewPostPage(String name,String password) {

        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();

        Header header = new Header(driver);
        header.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isUrlLoaded(),"Login URL is not correct");

        String signInText = loginPage.getSignInElementText();
        Assert.assertEquals(signInText,"Sign in");

        loginPage.userName(name);

        loginPage.userPassword(password);

        loginPage.clickSignIn();
        Assert.assertTrue(homePage.isUrlLoaded(), "Home URl is not correct");

        header.clickNewPostLink();

        driver.get("http://training.skillo-bg.com/posts/create");
        WebElement homeLogo = driver.findElement(By.id("homeIcon"));
        Assert.assertTrue(homeLogo.isDisplayed(), "Logo is not displayed!");
    }

    @Test(dataProvider = "getUsers")
    public void testSkilloLogoSearch(String name,String password) {
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();

        Header header = new Header(driver);
        header.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isUrlLoaded(),"Login URL is not correct");

        String signInText = loginPage.getSignInElementText();
        Assert.assertEquals(signInText,"Sign in");

        loginPage.userName(name);

        loginPage.userPassword(password);

        loginPage.clickSignIn();
        Assert.assertTrue(homePage.isUrlLoaded(), "Home URl is not correct");

        header.searchBar();

        driver.get("http://training.skillo-bg.com/posts/all");
        WebElement homeLogo = driver.findElement(By.id("homeIcon"));
        Assert.assertTrue(homeLogo.isDisplayed(), "Logo is not displayed!");
    }
}

