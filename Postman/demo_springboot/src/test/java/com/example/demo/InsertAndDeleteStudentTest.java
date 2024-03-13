package com.example.demo;

// Generated by Selenium IDE

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertAndDeleteStudentTest {

	// @Test
	public void insertAndDeleteStudentAceptanceXLTest() {
		// given
		driver.get("http://127.0.0.1:8081/");

		// when
		driver.findElement(By.id("nombre")).sendKeys("pablo");
		driver.findElement(By.id("apellido")).sendKeys("gomez");
		driver.findElement(By.cssSelector("input:nth-child(6)")).click();

		// then
		assertEquals(driver.findElement(By.xpath("//td[contains(.,\'pablo\')]")).getText(), "pablo");
		assertEquals(driver.findElement(By.xpath("//td[contains(.,\'gomez\')]")).getText(), "gomez");

		// clean up
		driver.findElement(By.xpath("//a[@id=\'deleteBtn\']")).click();
	}
	
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/home/joterrance/Descargas/chrome-linux64/chrome");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		driver.manage().window().maximize();
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

}