import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AirbnbTest {

    WebDriver webD;

    @BeforeEach
    public void init() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        webD = new ChromeDriver();
    }

    @Test
    public void abrirPaginaCesarTest() {
        webD.manage().window().maximize();
        webD.get("https://www.cesar.org.br/");
        Assertions.assertEquals("https://www.cesar.org.br/", webD.getCurrentUrl());
    }

    @Test
    public void buttonIdCesarTest() {

        webD.manage().window().maximize();
        webD.get("https://www.cesar.org.br/");
        WebElement botao = webD.findElement(By.id("p_com_liferay_portal_search_web_search_bar_portlet_SearchBarPortlet_INSTANCE_templateSearch"));
    }
    @Test
    public void buttonIdCesarElementsTest() {
        webD.manage().window().maximize();
        webD.get("https://www.cesar.org.br/");
        List<WebElement> elements = webD.findElements(By.id("p_com_liferay_portal_search_web_search_bar_portlet_SearchBarPortlet_INSTANCE_templateSearch"));
        for (WebElement elementID : elements) {
            System.out.println(elementID.getText());
        }
    }

    @Test
    public void inserindoDadosEmCampoDePesquisaTest() {

        webD.manage().window().maximize();
        webD.get("https://www.cesar.org.br/");

        WebElement search = webD.findElement(By.id("search-header"));
        search.sendKeys("tecnologia");

    }
    @Test
    public void inserindoDadosEmCampoDePesquisa2Test() {

        webD.manage().window().maximize();
        webD.get("https://www.cesar.org.br/");

        WebElement search = webD.findElement(By.id("search-header"));
        search.sendKeys("turismo");

    }
    @Test
    public void inserindoDadosEmCampoDePesquisa3Test() {

        webD.manage().window().maximize();
        webD.get("https://www.cesar.org.br/");

        WebElement search = webD.findElement(By.id("search-header"));
        search.sendKeys("esporte");

    }

    @Test
    public void moveElementEspecificadoTrueTest (){

        webD.manage().window().maximize();
        webD.get("https://www.cesar.org.br/");
        Actions actions = new Actions(webD);
        WebElement botao = webD.findElement(
                By.id("search-header"));
        actions.moveToElement(botao).perform();
        Assertions.assertTrue(webD.getPageSource().contains(botao.getAttribute("type")));
    }
    @Test
    public void moveElementEspecificadoTrue2Test (){

        webD.manage().window().maximize();
        webD.get("https://www.cesar.org.br/");
        Actions actions = new Actions(webD);
        WebElement botao = webD.findElement(
                By.id("search-header"));
        actions.moveToElement(botao).perform();
        Assertions.assertTrue(webD.getPageSource().contains(botao.getAttribute("id")));
    }

    @Test
    public void moveElementEspecificadoFalseTest (){

        webD.manage().window().maximize();
        webD.get("https://www.cesar.org.br/");
        Actions actions = new Actions(webD);
        WebElement botao = webD.findElement(
                By.id("search-header"));
        actions.moveToElement(botao).perform();
        Assertions.assertFalse(webD.getPageSource().contains(botao.getAttribute("placeholder")));

    }
    @Test
    public void findElementsByXpathTeste(){

        webD.get("https://www.cesar.org.br/");

        WebElement lista = webD.findElement(By.xpath("//*[@id=\"main-content\"]"));
        List<WebElement> elements = lista.findElements(By.xpath("./div"));

        Assertions.assertEquals(12, elements.size());
    }


    @AfterEach
    public void finish() {
        webD.close();
    }

}