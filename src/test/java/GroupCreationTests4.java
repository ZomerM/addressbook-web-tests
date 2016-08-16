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

public class GroupCreationTests4 {
	ChromeDriver wd;

	@Before
	public void setUp() throws Exception {
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wd.get("http://localhost/addressbook/group.php");
		login("admin", "secret");
	}

	private void login(String username, String password) {
		wd.findElement(By.name("pass")).click();
		wd.findElement(By.name("pass")).sendKeys("\\undefined");
		wd.findElement(By.name("user")).click();
		wd.findElement(By.name("user")).clear();
		wd.findElement(By.name("user")).sendKeys(username);
		wd.findElement(By.id("LoginForm")).click();
		wd.findElement(By.name("pass")).click();
		wd.findElement(By.name("pass")).clear();
		wd.findElement(By.name("pass")).sendKeys(password);
		wd.findElement(By.id("LoginForm")).click();
		wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
	}

	@Test
	public void testGroupCreation4() {
		wd.get("http://localhost/addressbook/group.php");
		login("admin", "secret");
		gotoGroupPage();
		initGroupCreation();
		fillGroupForm(new GroupData("tset", "test1", "test2"), "test3");
		submitGroupCreation();
		returnToGroupPage();
	}

	private void returnToGroupPage() {
		wd.findElement(By.linkText("group page")).click();
	}

	private void submitGroupCreation() {
		wd.findElement(By.name("submit")).click();
	}

	private void fillGroupForm(GroupData parameterObject, String huinya) {
		wd.findElement(By.parameterObject.name("group_name")).click();
		wd.findElement(By.parameterObject.name("group_name")).clear();
		wd.findElement(By.parameterObject.name("group_name")).sendKeys(parameterObject.name);
		wd.findElement(By.parameterObject.name("group_name")).click();
		wd.findElement(By.parameterObject.name("group_name")).clear();
		wd.findElement(By.parameterObject.name("group_name")).sendKeys(parameterObject.header);
		wd.findElement(By.parameterObject.name("group_header")).click();
		wd.findElement(By.parameterObject.name("group_header")).clear();
		wd.findElement(By.parameterObject.name("group_header")).sendKeys(parameterObject.footer);
		wd.findElement(By.parameterObject.name("group_footer")).click();
		wd.findElement(By.parameterObject.name("group_footer")).clear();
		wd.findElement(By.parameterObject.name("group_footer")).sendKeys(huinya);
	}

	private void initGroupCreation() {
		wd.findElement(By.name("new")).click();
	}

	private void gotoGroupPage() {
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
