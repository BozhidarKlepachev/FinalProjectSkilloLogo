package HomeWorkFinal;

import io.github.bonigarcia.wdm.WebDriverManager;
import factory.Header;
import factory.HomePage;
import factory.LoginPage;
import factory.ProfilePage;
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

        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();

        Header header = new Header(driver);
        header.isHomeLogoIsDisplayed();
        Assert.assertTrue(header.isHomeLogoIsDisplayed(), (" The Logo is not displayed"));
    }

    @Test(invocationCount = 1)
    public void testSkilloLogoSignInPage() {

        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();

        Header header = new Header(driver);
        header.clickLogin();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isUrlLoaded(),"Login URL is not correct");

        String signInText = loginPage.getSignInElementText();
        Assert.assertEquals(signInText,"Sign in");

        Header header1 =  new Header(driver);
        header.isHomeLogoIsDisplayed();

        Assert.assertTrue(header1.isHomeLogoIsDisplayed(), (" The Logo is not displayed"));


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

        Header header1 = new Header(driver);
        header1.isHomeLogoIsDisplayed();
        Assert.assertTrue(header1.isHomeLogoIsDisplayed(), (" The Logo is not displayed"));

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

        ProfilePage profilePage = new ProfilePage(driver);
        Assert.assertTrue(profilePage.isUrlLoaded(),"Profile URL is not correct");

        Header header1 = new Header(driver);
        header1.isHomeLogoIsDisplayed();
        Assert.assertTrue(header1.isHomeLogoIsDisplayed(), (" The Logo is not displayed"));

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

        Header header1 = new Header(driver);
        header1.isHomeLogoIsDisplayed();
        Assert.assertTrue(header1.isHomeLogoIsDisplayed(), (" The Logo is not displayed"));

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

        Header header1 = new Header(driver);
        header1.isHomeLogoIsDisplayed();
        Assert.assertTrue(header1.isHomeLogoIsDisplayed(), (" The Logo is not displayed"));

    }
}

