package src.test.structure.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import src.test.structure.objects.webConfigurationObjects;
import src.test.structure.objects.webObjects;

import static src.test.structure.hooks.WebInitializer.webDriver;


public class WebFactory {

    static private WebElement webElement;

    public static void launchApplication(String url) {

        webDriver.get(url);
    }

    public static void findElementByXpathAndClick(String elementXpath) {
        webDriver.findElement(By.xpath(elementXpath)).click();
    }

    public static boolean isElementVisibleOnPage(String elementXpath) {
        boolean element_present = false;
        try {
            element_present = webDriver.findElements(By.xpath(elementXpath)).size() != 0;
            if (element_present) {
                return element_present;
            }
        } catch (Exception e) {
            System.out.println("isElementVisibleOnPage failed " + e);
            return false;
        }
        return element_present;
    }


    /**
     * @param elementIs
     * @return
     * @throws Exception
     */
    public static String verifyTextByXPATH(String elementIs) throws Exception {
        String textIs = null;
        try {
            System.out.println("Verification of Text Message");
            textIs = webDriver.findElement(By.xpath(elementIs)).getText();
        } catch (Exception e) {
            System.out.println("[FAIL --] Not able to find the desired webElement ->" + elementIs);
        }
        return textIs;
    }

    public static String verifyTextByAttribute(String elementIs, String attributeIs) throws Exception {
        String attributeValue = null;
        try {
            System.out.println("Verification of Text Message");
            attributeValue = webDriver.findElement(By.xpath(elementIs)).getAttribute(attributeIs);
        } catch (Exception e) {
            System.out.println("[FAIL --] Not able to find the desired webElement ->" + elementIs);
        }
        return attributeValue;
    }


    public static Boolean isTextPresentInPage(String stringValue) {
        System.out.println("stringValue--" + stringValue);
        boolean result = webDriver.getPageSource().contains(stringValue);
        System.out.println("Result--" + result);
        return result;
    }

    /**
     * @param navigateTo browser
     */
    public static void navigateBrowser(String navigateTo) throws Exception {
        try {
            System.out.println("Begining of Navigation type");
            if (navigateTo.equalsIgnoreCase("forward")) {
                webDriver.navigate().forward();
            } else if (navigateTo.equalsIgnoreCase("back")) webDriver.navigate().back();
        } catch (Exception e) {
            System.out.println("[FAIL ---] Not able to Navigate the Browser");
        }
    }


    /**
     * @param element xpath
     * @return isItDisplayed
     */
    public static Boolean isElementDisplayedByXPATH(String element) throws Exception {
        boolean isItDisplayed;
        try {
            isItDisplayed = webDriver.findElement(By.xpath(element)).isDisplayed();
        } catch (Exception e) {
            isItDisplayed = false;
        }
        return isItDisplayed;
    }


    public static boolean scrollDownTillXpathVisible(String element) {
        try {
            boolean scrollVisible = false;
            scrollVisible = isElementDisplayedByXPATH(element);
            int scroll = 0;
            while (scroll < 5 && (!scrollVisible)) {
                JavascriptExecutor js = (JavascriptExecutor) webDriver;
                js.executeScript("window.scrollBy(0, 500);"); // scrolls d
                scroll++;
                Thread.sleep(1000);
                scrollVisible = isElementDisplayedByXPATH(element);
            }
            if (scrollVisible) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("scrollTillElementByXPATH failed!" + e);
        }
        return false;
    }

    public static void launchUrl() throws Exception {
        webDriver.navigate().to(webConfigurationObjects.apiURL);
        Thread.sleep(5000);
    }

    public static String getRequestURL() {
        return webDriver.findElement(By.xpath(webObjects.requestURL)).getText();
    }

    public static String getJsonFromOutPut() throws InterruptedException {
        Thread.sleep(3000);
        return webDriver.findElement(By.xpath(webObjects.outPutData)).getText();
    }

    public static String getJsonRequest() throws InterruptedException {
        Thread.sleep(3000);
        return webDriver.findElement(By.xpath(webObjects.requestJson)).getText();
    }

    public static String getGoodResponseCode() throws InterruptedException {
        Thread.sleep(1000);
        return webDriver.findElement(By.xpath(webObjects.goodResponse)).getText();
    }

    public static String getOtherResponseCode() throws InterruptedException {
        Thread.sleep(1000);
        return webDriver.findElement(By.xpath(webObjects.badResponse)).getText();
    }


}
