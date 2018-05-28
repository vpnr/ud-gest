package fr.fo.ud.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.fo.ud.app.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class LoginControllerTest {

	private WebDriver driver = new FirefoxDriver();
	
	@Test
	public void loginTestOK() {
		
		//Given
		driver.navigate().to("http://localhost:8880/ud-gest/login");
		WebElement login = driver.findElement(By.id("login_user"));
		login.sendKeys("admin");
		WebElement password = driver.findElement(By.id("password_user"));
		password.sendKeys("admin");
		
		//When
		WebElement submit = driver.findElement(By.name("Submit"));
		submit.click();
		
		//then
		assertFalse(driver.getCurrentUrl().endsWith("login"));
		driver.close();
		
		
	}
	
	@Test
	public void loginTestKO() {
		
		//Given
		driver.navigate().to("http://localhost:8880/ud-gest/login");
		WebElement login = driver.findElement(By.id("login_user"));
		login.sendKeys("unknown_user");
		WebElement password = driver.findElement(By.id("password_user"));
		password.sendKeys("wrong_password");
		
		//When
		WebElement submit = driver.findElement(By.name("Submit"));
		submit.click();
		
		//then
		assertTrue(driver.getCurrentUrl().endsWith("login"));
		driver.close();
	}
	
}
