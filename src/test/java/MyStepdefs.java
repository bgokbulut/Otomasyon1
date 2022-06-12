import Variables.Variables;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

import static Variables.Variables.driver;


public class MyStepdefs {

    Variables variables = new Variables();


    @Given("OBSS siteye Girilir")
    public void obssSiteyeGirilir() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(variables.baseUrl);
        Thread.sleep(2000);
    }

    @When("Cerezler Kabul Edilir")
    public void cerezlerKabulEdilir() throws InterruptedException {
        WebElement addButton= driver.findElement(By.id(variables.acceptCookies)) ;
        addButton.click();
        Thread.sleep(2000);
    }

    @And("Search Ikonuna Tıklanır")
    public void searchIkonunaTıklanır() throws InterruptedException {
        WebElement searchButton= driver.findElement(By.id(variables.searchIcon)) ;
        searchButton.click();
        Thread.sleep(2000);
    }

    @And("Text Alana Automation Yazılır")
    public void textAlanaAutomationYazılır() throws InterruptedException {
        WebElement searchBox= driver.findElement(By.id(variables.searchBox)) ;
        searchBox.sendKeys("Automation");
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    @And("Sonuçların Geldiği Doğrulanır")
    public void sonuçlarınGeldiğiDoğrulanır() {
        String TEXT = "Testing & Automation";
        String mesaj = driver.findElement(By.cssSelector(variables.testingAutomationLocation)).getText();
        Assert.assertEquals(mesaj,TEXT,"kontrol başarısız");
    }

    @And("Çıkan Sonuçlardan Ilkine Tıklanır")
    public void çıkanSonuçlardanIlkineTıklanır() throws InterruptedException {
        WebElement element= driver.findElement(By.xpath(variables.firstItem)) ;
        element.click();
        Thread.sleep(2000);
    }

    @And("Testing & Automation Sayfasının Açıldığı Doğrulanır")
    public void testingAutomationSayfasınınAçıldığıDoğrulanır() {
        String automationText = "Testing & Automation";
        String mesaj = driver.findElement(By.xpath(variables.testingAutomationPage)).getText();
        Assert.assertEquals(mesaj,automationText,"kontrol başarısız");
    }

    @And("Sayfanın En Altına Gidilir")
    public void sayfanınEnAltınaGidilir() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        Thread.sleep(2000);
    }

    @Then("Obss Footer Geldiği Doğrulanır")
    public void obssFooterGeldiğiDoğrulanır(){
        String automationText = "KVKK";
        String mesaj = driver.findElement(By.xpath(variables.KVKKFooterXpath)).getText();
        Assert.assertEquals(mesaj,automationText,"kontrol başarısız");
        driver.quit();
    }
}
