package appmanager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager{


	private GroupHelper groupHelper;

	public void init() {
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		login("admin", "secret");
	}

	public void login(String login, String password) {
		wd.get("http://localhost/addressbook/");
		wd.findElement(By.name("pass")).click();
		wd.findElement(By.name("pass")).clear();
		wd.findElement(By.name("pass")).sendKeys(password);
		wd.findElement(By.name("user")).click();
		wd.findElement(By.name("user")).clear();
		wd.findElement(By.name("user")).sendKeys(login);
		wd.findElement(By.id("LoginForm")).click();
		wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
	}

	public void gotoGroupPage() {
		wd.findElement(By.linkText("groups")).click();
	}

	public void stop() {
		wd.quit();
	}

	public static boolean isAlertPresent(FirefoxDriver wd) {
		try {
			wd.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public GroupHelper getGroupHelper() {
		return groupHelper;
	}

}
