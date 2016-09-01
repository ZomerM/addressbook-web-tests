package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper {

	public ChromeDriver wd;
	public void gotoGroupPage() {
		wd.findElement(By.linkText("groups")).click();
	}

}
