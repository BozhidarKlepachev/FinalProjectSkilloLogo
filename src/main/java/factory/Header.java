package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {

    private final WebDriver driver;
    @FindBy(id = "nav-link-login")
    private WebElement loginLink;
    @FindBy(id="nav-link-profile")
    private WebElement profileLink;
    @FindBy(id="nav-link-new-post")
    private WebElement newPostLink;
    @FindBy(id = "search-bar")
    private WebElement searchBar;
    @FindBy (id = "homeIcon")
    private WebElement isHomeLogoIsDisplayed;



    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickProfile (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(profileLink));
        profileLink.click();
    }

    public void searchBar () {
        WebElement searchFile = driver.findElement(By.id("search-bar"));
        searchFile.click();
    }

    public void clickLogin () {
        loginLink.click();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void clickNewPostLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement newPostLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-new-post")));
        newPostLink.click();
    }

    public boolean isHomeLogoIsDisplayed () {
        return isHomeLogoIsDisplayed.isDisplayed();
    }
}
