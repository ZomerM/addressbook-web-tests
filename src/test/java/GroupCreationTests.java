import org.junit.After;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.OutputType.*;

public class GroupCreationTests {
	ChromeDriver wd;

	@Before
	public void setUp() throws Exception {
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

	@Test
	public void testGroupCreation() {

		gotoGroupPage();
		initGroupCreation();
		wd.findElement(By.name("group_name")).click();
		wd.findElement(By.name("group_name")).clear();
		fillGroupForm(new GroupData("Test1", "Test2", "test3"));
		submitGroupCreation();
		returnToGroupPage();
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

	public void gotoGroupPage() {
		wd.findElement(By.linkText("groups")).click();
	}

	@After
	public void tearDown() {
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
}
