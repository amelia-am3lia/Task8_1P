package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestRoutingServlet {

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private WebDriver createDriver() {
        System.setProperty(
                "webdriver.chrome.driver",
				"C:/Users/Amelia/Downloads/chromedriver_148/chromedriver-win64/chromedriver.exe"
        );
        return new ChromeDriver();
    }

    //reusable successful login block
    private void loginSuccess(WebDriver driver) {
        driver.get("http://127.0.0.1:8080/login");

        driver.findElement(By.id("username")).sendKeys("amelia");
        driver.findElement(By.id("passwd")).sendKeys("amelia_pass");
        driver.findElement(By.id("dob")).sendKeys("24-12-2000");

        driver.findElement(By.cssSelector("[type=submit]")).click();

        sleep(1);
    }
    
    //     successful Q1 reusable block
    private void q1Success(WebDriver driver) {
	    driver.findElement(By.id("number1")).sendKeys("2");
	    driver.findElement(By.id("number2")).sendKeys("3");
	    driver.findElement(By.id("result")).sendKeys("5");
	    driver.findElement(By.cssSelector("[type=submit]")).click();
	    sleep(1);
    }
    // reusable successful Q2
    private void q2Success(WebDriver driver) {
	    driver.findElement(By.id("number1")).sendKeys("10");
	    driver.findElement(By.id("number2")).sendKeys("3");
	    driver.findElement(By.id("result")).sendKeys("7");
	    driver.findElement(By.cssSelector("[type=submit]")).click();
	    sleep(1);
    }
    // reusable successful q3
    private void q3Success(WebDriver driver) {
	    driver.findElement(By.id("number1")).sendKeys("2");
	    driver.findElement(By.id("number2")).sendKeys("3");
	    driver.findElement(By.id("result")).sendKeys("6");
	    driver.findElement(By.cssSelector("[type=submit]")).click();
	    sleep(1);
    }
    
    
    // short login tests
    @Test
    public void testLoginSuccess() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/login");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys("amelia");
		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys("amelia_pass");
		ele = driver.findElement(By.id("dob"));
		ele.clear();
		ele.sendKeys("24-12-2000");        
		// submit login
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();
		sleep(5);      

        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
        driver.quit();
    }
    @Test
    public void testLoginFailEmptyUsername() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/login");
        sleep(2);
        // submit empty username
		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys("");
		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys("amelia_pass");
		ele = driver.findElement(By.id("dob"));
		ele.clear();
		ele.sendKeys("24-12-2000");        // submit login
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();
		sleep(5); 
        // confir didn't go to next screen
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
        driver.quit();
    }

    //q1 addition tests
    @Test
    public void testCorrectInputsAddSuccess() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q1");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("2");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("3");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
        driver.quit();
    }
    @Test
    public void testIncorrectResultAddFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q1");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("2");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("1");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);   

        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
        driver.quit();
    }
    @Test
    public void testNullInput1AddFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q1");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("2");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  
		
        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
        driver.quit();
    }
    @Test
    public void testNullInput2AddFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q1");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("2");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
        driver.quit();
    }
    @Test
    public void testNullInputResultAddFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q1");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("2");
		ele = driver.findElement(By.id("result"));
		ele.clear();		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
        driver.quit();
    }    
    @Test
    public void testEmptyInput1AddFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q1");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("2");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
        driver.quit();
    }    
    @Test
    public void testEmptyInput2AddFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q1");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("2");        
		// submit
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);   

        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
        driver.quit();
    }    
    @Test
    public void testEmptyInputResultAddFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q1");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("2");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);   

        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
        driver.quit();
    }    
    @Test
    public void testStringInput1AddFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q1");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("abc");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("2");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
        driver.quit();
    }
    @Test
    public void testStringInput2AddFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q1");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("abc");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("2");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);   

        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
        driver.quit();
    }
    @Test
    public void testStringInputResultAddFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q1");
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("2");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("abc");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
        driver.quit();
    }
    @Test
    public void testNegativeInput1AddFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q1");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("-1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("2");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("3");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  
		
        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
        driver.quit();
    }
    @Test
    public void testNegativeInput2AddFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q1");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("-2");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("1");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
        driver.quit();
    }
    @Test
    public void testNegativeInputResultAddFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q1");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("-2");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
        driver.quit();
    }
    @Test
    public void testNegativeInputsAddSuccess() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q1");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("-2");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("-1");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("3");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  
		
        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
        driver.quit();
    }   
    @Test
    public void testNegativeMixedInputsAddSuccess() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q1");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("-2");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("-1");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
        driver.quit();
    }
   
   // q2 subtraction tests
    @Test
    public void testCorrectInputsSubSuccess() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q2");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("3");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("2");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("1");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
        driver.quit();
    }
    @Test
    public void testIncorrectResultSubFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q2");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("2");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("2");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("1");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);   

        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
        driver.quit();
    }
    @Test
    public void testNullInput1SubFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q2");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("2");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  
		
        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
        driver.quit();
    }
    @Test
    public void testNullInput2SubFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q2");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("2");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
        driver.quit();
    }
    @Test
    public void testNullInputResultSubFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q2");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("2");
		ele = driver.findElement(By.id("result"));
		ele.clear();
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
        driver.quit();
    }    
    @Test
    public void testEmptyInput1SubFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q2");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("2");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
        driver.quit();
    }    
    @Test
    public void testEmptyInput2SubFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q2");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("2");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);   

        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
        driver.quit();
    }    
    @Test
    public void testEmptyInputResultSubFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q2");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("2");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("");        
		// submit login
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);   

        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
        driver.quit();
    }    
    @Test
    public void testStringInput1SubFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q2");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("abc");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("2");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
        driver.quit();
    }
    @Test
    public void testStringInput2SubFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q2");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("abc");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("2");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);   

        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
        driver.quit();
    }
    @Test
    public void testStringInputResultSubFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q2");
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("2");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("abc");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
        driver.quit();
    }
    @Test
    public void testNegativeInput1SubFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q2");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("-1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("2");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("3");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  
		
        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
        driver.quit();
    }
    @Test
    public void testNegativeInput2SubFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q2");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("-2");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("1");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
        driver.quit();
    }
    @Test
    public void testNegativeInputResultSubFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q2");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("-2");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
        driver.quit();
    }
    @Test
    public void testNegativeInputsSubSuccess() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q2");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("-1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("-4");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("3");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  
		
        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
        driver.quit();
    }  
    @Test
    public void testNegativeMixedInputsSubSuccess() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q2");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("-2");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("-3");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
        driver.quit();
    }
   
    // q3 multiplication tests
    @Test
    public void testCorrectInputsMultSuccess() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q3");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("3");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("2");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("6");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/end"));
        driver.quit();
    }
    @Test
    public void testIncorrectResultMultFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q3");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("2");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("1");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);   

        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
        driver.quit();
    }
    @Test
    public void testNullInput1MultFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q3");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("2");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  
		
        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
        driver.quit();
    }
    @Test
    public void testNullInput2MultFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q3");
        sleep(2);
        // enter credentials by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("2");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
        driver.quit();
    }
    @Test
    public void testNullInputResultMultFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q3");
        sleep(2);
        // enter numbers by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("2");
		ele = driver.findElement(By.id("result"));
		ele.clear();
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
        driver.quit();
    }    
    @Test
    public void testEmptyInput1MultFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q3");
        sleep(2);
        // enter numbers by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("2");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
        driver.quit();
    }    
    @Test
    public void testEmptyInput2MultFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q3");
        sleep(2);
        // enter numbers by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("2");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);   

        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
        driver.quit();
    }    
    @Test
    public void testEmptyInputResultMultFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q3");
        sleep(2);
        // enter numbers by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("2");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);   

        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
        driver.quit();
    }    
    @Test
    public void testStringInput1MultFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q3");
        sleep(2);
        // enter numbers by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("abc");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("2");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
        driver.quit();
    }
    @Test
    public void testStringInput2MultFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q3");
        sleep(2);
        // enter numbers by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("abc");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("2");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);   

        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
        driver.quit();
    }
    @Test
    public void testStringInputResultMultFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q3");
        // enter numbers by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("2");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("abc");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
        driver.quit();
    }
    @Test
    public void testNegativeInput1MultFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q3");
        sleep(2);
        // enter numbers by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("-1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("2");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("3");        
		// submit login
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  
		
        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
        driver.quit();
    }
    @Test
    public void testNegativeInput2MultFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q3");
        sleep(2);
        // enter numbers by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("-2");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("1");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
        driver.quit();
    }
    @Test
    public void testNegativeInputResultMultFail() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q3");
        sleep(2);
        // enter numbers by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("-2");        
		// submit login
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
        driver.quit();
    }
    @Test
    public void testNegativeInputsMultSuccess() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q3");
        sleep(2);
        // enter numbers by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("-2");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("-1");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("2");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  
		
        Assert.assertTrue(driver.getCurrentUrl().contains("/end"));
        driver.quit();
    }   
    @Test
    public void testNegativeMixedInputsMultSuccess() {
        WebDriver driver = createDriver();
        driver.get("http://127.0.0.1:8080/q3");
        sleep(2);
        // enter numbers by finding elements and sending keys
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();		ele.sendKeys("-2");
		ele = driver.findElement(By.id("number2"));
		ele.clear();		ele.sendKeys("1");
		ele = driver.findElement(By.id("result"));
		ele.clear();		ele.sendKeys("-2");        
		// submit 
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.click();		sleep(5);  

        Assert.assertTrue(driver.getCurrentUrl().contains("/end"));
        driver.quit();
    }    
    
    
    // screen flow test
    @Test
    public void testSmoothFlowLoginToQ1() {
        WebDriver driver = createDriver();
        // login
        loginSuccess(driver);
        // q1
        q1Success(driver);
        // q2
        q2Success(driver);
        // q3
        q3Success(driver);
        // go from end screen to q1 screen
        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(1);        
        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
        driver.quit();
    }    
    @Test
    public void testLoginCompletedTwice() {
        WebDriver driver = createDriver();
        // login fail
        driver.get("http://127.0.0.1:8080/login");
        driver.findElement(By.id("username")).sendKeys("user");
        driver.findElement(By.id("passwd")).sendKeys("password");
        driver.findElement(By.id("dob")).sendKeys("20-10-2001");
        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(1);
        // login success
        loginSuccess(driver);        
        // q1
        q1Success(driver);        
        // q2
        q2Success(driver);        
        // q3
        q3Success(driver);        
        Assert.assertTrue(driver.getCurrentUrl().contains("/end"));
        driver.quit();
    }    
    @Test
    public void testQ1CompletedTwice() {
        WebDriver driver = createDriver();
        // login
        loginSuccess(driver);
        // q1 fail
        driver.findElement(By.id("number1")).sendKeys("2");
        driver.findElement(By.id("number2")).sendKeys("1");
        driver.findElement(By.id("result")).sendKeys("5");
        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(1);        
        // q1 success
        q1Success(driver);        
        // q2
        q2Success(driver);
        // q3
        q3Success(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("/end"));
        driver.quit();
    }    
    @Test
    public void testQ2CompletedTwice() {
        WebDriver driver = createDriver();
        // login
        loginSuccess(driver);
        // q1
        q1Success(driver);        
        // q2 fail
        driver.findElement(By.id("number1")).sendKeys("4");
        driver.findElement(By.id("number2")).sendKeys("3");
        driver.findElement(By.id("result")).sendKeys("7");
        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(1);
        // q2 success
        q2Success(driver);
        // q3
        q3Success(driver);     
        Assert.assertTrue(driver.getCurrentUrl().contains("/end"));
        driver.quit();
    }    
    @Test
    public void testQ3CompletedTwice() {
        WebDriver driver = createDriver();
        // login
        loginSuccess(driver);        
        // q1
        q1Success(driver);        
        // q2
        q2Success(driver);
        // q3 fail
        driver.findElement(By.id("number1")).sendKeys("2");
        driver.findElement(By.id("number2")).sendKeys("3");
        driver.findElement(By.id("result")).sendKeys("1");
        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(1);        
        // q3 success
        q3Success(driver);        
        Assert.assertTrue(driver.getCurrentUrl().contains("/end"));
        driver.quit();
    }
    @Test
    public void testQ123CompletedTwice() {
        WebDriver driver = createDriver();
        // login
        loginSuccess(driver);        
        // q1 fail
        driver.findElement(By.id("number1")).sendKeys("2");
        driver.findElement(By.id("number2")).sendKeys("1");
        driver.findElement(By.id("result")).sendKeys("5");
        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(1);        
        // q1 success
        q1Success(driver);        
        // q2 fail
        driver.findElement(By.id("number1")).sendKeys("5");
        driver.findElement(By.id("number2")).sendKeys("3");
        driver.findElement(By.id("result")).sendKeys("7");
        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(1);
        // q2 success
        q2Success(driver);
        // q3 fail
        driver.findElement(By.id("number1")).sendKeys("1");
        driver.findElement(By.id("number2")).sendKeys("3");
        driver.findElement(By.id("result")).sendKeys("6");
        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(1);
        // q3 success
        q3Success(driver);        
        Assert.assertTrue(driver.getCurrentUrl().contains("/end"));
        driver.quit();
    }
    @Test
    public void testLoginToLoginToQ3() {
        WebDriver driver = createDriver();
        // login
        loginSuccess(driver);        
        // q1
        q1Success(driver);        
        // q2
        q2Success(driver);
        // q3
        q3Success(driver);        
        // go from end screen to Q1 screen
        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(1);        
        // q1
        q1Success(driver);
        // q2
        q2Success(driver);        
        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
        driver.quit();
    }
}