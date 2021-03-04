import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DesafioDatumTest {
    private WebDriver driver;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/home/idd_lrezende/Datum/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://automationpractice.com/index.php");
    }

    @Test
    public void fazerLogim() {
        WebElement acessarTelaLogin = driver.findElement(By.xpath("//*[@title=\"Log in to your customer account\"]"));
        acessarTelaLogin.findElement(By.xpath("//*[@title=\"Log in to your customer account\"]")).click();

        WebElement campoEmail = driver.findElement(By.id("email"));
        campoEmail.findElement(By.id("email")).sendKeys("datumqatest@soprock.com");

        WebElement campoPassword = driver.findElement(By.id("passwd"));
        campoPassword.findElement(By.id("passwd")).sendKeys("datum2021");

        WebElement botaoSignIn = driver.findElement(By.id("SubmitLogin"));
        botaoSignIn.findElement(By.id("SubmitLogin")).click();

        String texto = driver.findElement(By.xpath("//*[@title=\"View my customer account\"]")).getText();
        Assert.assertEquals("Datum QA Test", texto);

        Screenshot.tirar(driver, "/home/idd_lrezende/Datum/Screenshots/Login" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png");

    }

    @Test
    public void buscarProdutoBlouse() {
        WebElement buscarBlouse = driver.findElement(By.id("search_query_top"));
        buscarBlouse.findElement(By.id("search_query_top")).sendKeys("blouse");

        WebElement pesquisaBlouse = driver.findElement(By.name("submit_search"));
        pesquisaBlouse.findElement(By.name("submit_search")).click();

        String texto = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a")).getText();
        Assert.assertEquals("Blouse", texto);

        Screenshot.tirar(driver, "/home/idd_lrezende/Datum/Screenshots/BuscaBlouse" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png");
    }

    @Test
    public void adicionarBlouseCarrinho() {
        WebElement addBlouse = driver.findElement(By.xpath("//*[@title=\"Add to cart\"]"));
        addBlouse.findElement(By.xpath("//*[@title=\"Add to cart\"]")).click();

        WebElement continuaCompra = driver.findElement(By.xpath("//*[@title=\"Continue shopping\"]"));
        continuaCompra.findElement(By.xpath("//*[@title=\"Continue shopping\"]")).click();

        Screenshot.tirar(driver, "/home/idd_lrezende/Datum/Screenshots/BuscaBlouse" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png");
    }

    @Test
    public void buscarProdutoPrintedChiffonDress() {
        WebElement limparCombo = driver.findElement(By.id("search_query_top"));
        limparCombo.findElement(By.id("search_query_top")).clear();

        WebElement buscarPrintedChiffonDress = driver.findElement(By.id("search_query_top"));
        buscarPrintedChiffonDress.findElement(By.id("search_query_top")).sendKeys("Printed Chiffon Dress");

        WebElement pesquisaPrintedChiffonDress = driver.findElement(By.name("submit_search"));
        pesquisaPrintedChiffonDress.findElement(By.name("submit_search")).click();

        String texto = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")).getText();
        Assert.assertEquals("Printed Chiffon Dress", texto);

        Screenshot.tirar(driver, "/home/idd_lrezende/Datum/Screenshots/BuscaPrinted" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png");
    }

    @Test
    public void adicionarPrintedChiffonDressCarrinho() {
        WebElement addPrintedChiffonDress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]"));
        addPrintedChiffonDress.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]")).click();

        WebElement continuaCompra = driver.findElement(By.xpath("//*[@title=\"Continue shopping\"]"));
        continuaCompra.findElement(By.xpath("//*[@title=\"Continue shopping\"]")).click();

        Screenshot.tirar(driver, "/home/idd_lrezende/Datum/Screenshots/BuscaPrinted" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png");
    }

    @Test
    public void fazerCheckOut() {
        WebElement acessarCarrinho = driver.findElement(By.xpath("//*[@title=\"View my shopping cart\"]"));
        acessarCarrinho.findElement(By.xpath("//*[@title=\"View my shopping cart\"]")).isSelected();

        WebElement checkOut = driver.findElement(By.xpath("//*[@title=\"Check out\"]"]"));
        checkOut.findElement(By.xpath("//*[@title=\"Check out\"]")).click();

        Screenshot.tirar(driver, "/home/idd_lrezende/Datum/Screenshots/Checkout" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png");
    }


    @Test
    public void continuandoCheckOutSigmIn() {
        WebElement proceedCheckoutSignIn = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]"));
        proceedCheckoutSignIn.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();

        Screenshot.tirar(driver, "/home/idd_lrezende/Datum/Screenshots/Checkout" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png");
    }

    @Test
    public void continuandoCheckOutAdress() {
        WebElement proceedCheckoutAdress = driver.findElement(By.name("processAddress"));
        proceedCheckoutAdress.findElement(By.name("processAddress")).click();

        Screenshot.tirar(driver, "/home/idd_lrezende/Datum/Screenshots/Checkout" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png");
    }

    @Test
    public void aceitarTermo() {
        WebElement marcarCheck = driver.findElement(By.id("cgv"));
        marcarCheck.findElement(By.id("cgv")).isEnabled();

        Screenshot.tirar(driver, "/home/idd_lrezende/Datum/Screenshots/Checkout" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png");
    }

    @Test
    public void continuandoShipping() {
        WebElement proceedShipping = driver.findElement(By.name("processCarrier"));
        proceedShipping.findElement(By.name("processCarrier")).click();

        Screenshot.tirar(driver, "/home/idd_lrezende/Datum/Screenshots/Checkout" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png");
    }

    @Test
    public void concluindoPagamento() {
        WebElement pagamentoBoleto = driver.findElement(By.xpath("//*[@title=\"Pay by bank wire\"]"));
        pagamentoBoleto.findElement(By.xpath("//*[@title=\"Pay by bank wire\"]")).click();

        Screenshot.tirar(driver, "/home/idd_lrezende/Datum/Screenshots/Checkout" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png");
    }

    @Test
    public void confirmacaoPagamento() {
        WebElement confirmaOrdem = driver.findElement(By.xpath("//*[@class=\"button-exclusive btn btn-default\"]"));
        confirmaOrdem.findElement(By.xpath("//*[@class=\"button-exclusive btn btn-default\"]")).click();

        String texto = driver.findElement(By.xpath("//*[text()=\"Your order on My Store is complete.\"]")).getText();
        Assert.assertEquals("Your order on My Store is complete.", texto);

        Screenshot.tirar(driver, "/home/idd_lrezende/Datum/Screenshots/Checkout" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png");
    }

    @After
    public void fecharBrowser() {
        driver.quit();
    }
}
