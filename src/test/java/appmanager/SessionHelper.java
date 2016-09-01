package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionHelper {

	private ChromeDriver wd;

	public SessionHelper(ChromeDriver wd) {
		this.wd = wd;
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
}
