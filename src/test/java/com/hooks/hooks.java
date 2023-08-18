package com.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class hooks {
	protected WebDriver driver;
	@BeforeMethod
	public void launch() {
		driver = new ChromeDriver();
		driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_csharp_search/862b0faa506b8487c25a3384cfde8af4/static/attachments/reference_page.html");
	}
	
	@AfterMethod
	public void quitBrowser() {
		driver.quit();//
	}

}
