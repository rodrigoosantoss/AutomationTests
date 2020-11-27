package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
import org.openqa.selenium.*;

public class RootPage {
        public void clicar(WebDriver driver, WebElement element){
            try {
                esperarElemento(driver, element);
                element.click();
            }catch (Exception ex){
                esperarTempo();
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("arguments[0].click();", element);
            }
        }

        public void escrever(WebDriver driver, WebElement element, String texto){
            esperarElemento(driver, element);
            try {
                esperarElemento(driver, element);
                element.clear();
                element.sendKeys(texto);
            }catch(Exception ex) {
                JavascriptExecutor jse = (JavascriptExecutor)driver;
                jse.executeScript("arguments[0].value = '" + texto + "';", element);
            }
        }

        public boolean esperarElemento(WebDriver driver, WebElement element) {
            WebElement webElement = null;

            try {
                Wait<WebDriver> wait = (new FluentWait(driver)).withTimeout(Duration.ofSeconds(Long.valueOf((long)10))).pollingEvery(Duration.ofMillis(200L)).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class).ignoring(TimeoutException.class);
                webElement = (WebElement)wait.until(ExpectedConditions.visibilityOf(element));
            } catch (StaleElementReferenceException | TimeoutException | NoSuchElementException var5) {
                return false;
            }
            return webElement != null;
        }

        public void esperarTempo() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public String obterTexto(WebDriver driver, WebElement element){
            String texto = null;
            try {
                esperarElemento(driver, element);
                texto = element.getText();
            } catch (Exception ex) {
                esperarTempo();
                JavascriptExecutor jse = (JavascriptExecutor)driver;
                texto = (String) jse.executeScript("return arguments[0].innerText;", element);
            }
            return texto;
        }
    }


