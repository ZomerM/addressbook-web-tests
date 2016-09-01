package appmanager;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import model.GroupData;

public class ApplicationManager {
	public ChromeDriver wd;
	private NavigationHelper navigationHelper = new NavigationHelper(wd);
	
	public void init() {
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		login("admin", "secret");
		setNavigationHelper(new NavigationHelper(wd));
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

	public void returnToGroupPage() {
		wd.findElement(By.linkText("group page")).click();
	}

	public void submitGroupCreation() {
		wd.findElement(By.name("submit")).click();
	}

	public void fillGroupForm(GroupData parameterObject) {
		wd.findElement(By.name("group_name")).sendKeys(parameterObject.name);
		wd.findElement(By.name("group_header")).click();
		wd.findElement(By.name("group_header")).clear();
		wd.findElement(By.name("group_header")).sendKeys(parameterObject.header);
		wd.findElement(By.name("group_footer")).click();
		wd.findElement(By.name("group_footer")).clear();
		wd.findElement(By.name("group_footer")).sendKeys(parameterObject.footer);
	}

	public void initGroupCreation() {
		wd.findElement(By.name("new")).click();
	}

	public void stop() {
		wd.quit();
	}

	public void deletSelectedGroups() {
		wd.findElement(By.name("delete")).click();
	}

	public void selectGroup() {
		wd.findElement(By.name("selected[]")).click();
	}

	public static boolean isAlertPresent(FirefoxDriver wd) {
		try {
			wd.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public NavigationHelper getNavigationHelper() {
		return navigationHelper;
	}

	public void setNavigationHelper(NavigationHelper navigationHelper) {
		this.navigationHelper = navigationHelper;
	}

}
