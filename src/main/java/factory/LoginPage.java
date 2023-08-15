package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    public static final String PAGE_URL = "http://training.skillo-bg.com/users/login";
    private final WebDriver driver;
    private WebDriverWait wait;

    @FindBy(className = "h4")
    private WebElement signInFormTitle;
    @FindBy(id ="defaultLoginFormUsername")
    private WebElement userName;
    @FindBy (id ="defaultLoginFormPassword")
    private WebElement userPassword;
    @FindBy(id ="sign-in-button")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);

    }
    public boolean isUrlLoaded() {return wait.until(ExpectedConditions.urlToBe(PAGE_URL));
    }

    public String getSignInElementText () {
        wait.until(ExpectedConditions.visibilityOf(signInFormTitle));
        return signInFormTitle.getText();
    }

    public void userName(String username) {
        userName.sendKeys("bk7777");
    }

    public void userPassword (String password) {
        userPassword.sendKeys("12345678910");
    }
    public void clickSignIn () {
        signInButton.click();
    }
}
