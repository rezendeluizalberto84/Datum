import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class CadastroUsuarioTest {
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
    public void cadastrarUsuario() {
        WebElement acessarTelaLogin = driver.findElement(By.xpath("//*[@title=\"Log in to your customer account\"]"));
        acessarTelaLogin.findElement(By.xpath("//*[@title=\"Log in to your customer account\"]")).click();

        WebElement campoEmail = driver.findElement(By.id("email_create"));
        campoEmail.findElement(By.id("email_create")).sendKeys("laar@gmail.com");

        WebElement botaoCreateAccount = driver.findElement(By.id("SubmitCreate"));
        botaoCreateAccount.findElement(By.id("SubmitCreate")).click();

        Screenshot.tirar(driver, "/home/idd_lrezende/Datum/Screenshots/Cadastro" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png");
    }

    @Test
    public void preencherFormulario() {
        WebElement marcarGenero = driver.findElement(By.id("id_gender1"));
        marcarGenero.findElement(By.id("id_gender1")).click();

        WebElement preencherNome = driver.findElement(By.id("customer_firstname"));
        preencherNome.findElement(By.id("customer_firstname")).sendKeys("Luiz");

        WebElement preencherSobreNome = driver.findElement(By.id("customer_lastname"));
        preencherSobreNome.findElement(By.id("customer_lastname")).sendKeys("Rezende");

        WebElement preencherSenha = driver.findElement(By.id("passwd"));
        preencherSenha.findElement(By.id("passwd")).sendKeys("abc.123");

        WebElement preencherNomeEnd = driver.findElement(By.id("firstname"));
        preencherNomeEnd.findElement(By.id("firstname")).sendKeys("Luiz");

        WebElement preencherSobreNomeEnd = driver.findElement(By.id("lastname"));
        preencherSobreNomeEnd.findElement(By.id("lastname")).sendKeys("Rezende");

        WebElement preencherEnderecoEnd = driver.findElement(By.id("address1"));
        preencherEnderecoEnd.findElement(By.id("address1")).sendKeys("A Street");

        WebElement preencherCidadeEnd = driver.findElement(By.id("city"));
        preencherCidadeEnd.findElement(By.id("city")).sendKeys("Abbeville");

        Select preencherEstadoEnd = new Select(driver.findElement(By.id("id_state")));
        preencherEstadoEnd.selectByVisibleText("Alabama");

        WebElement preencherCepEnd = driver.findElement(By.id("postcode"));
        preencherCepEnd.findElement(By.id("postcode")).sendKeys("30165");

        Select preencherPaisEnd = new Select(driver.findElement(By.id("id_country")));
        preencherPaisEnd.selectByVisibleText("United States");

        WebElement preencherCelularEnd = driver.findElement(By.id("phone_mobile"));
        preencherCelularEnd.findElement(By.id("phone_mobile")).sendKeys("+553299999999");

        WebElement preencherReferenciaEnd = driver.findElement(By.id("alias"));
        preencherReferenciaEnd.findElement(By.id("alias")).sendKeys("My Adress");

        WebElement registrarCadastro = driver.findElement(By.id("submitAccount"));
        registrarCadastro.findElement(By.id("submitAccount")).click();

        String texto = driver.findElement(By.xpath("//*[@title=\"View my customer account\"]")).getText();
        Assert.assertEquals("Luiz Rezende", texto);

        Screenshot.tirar(driver, "/home/idd_lrezende/Datum/Screenshots/Cadastro" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png");

    }

    @After
    public void fecharBrowser() {
        driver.quit();
    }
}
