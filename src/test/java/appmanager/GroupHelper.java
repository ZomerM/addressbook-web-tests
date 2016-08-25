package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import model.GroupData;

public class GroupHelper {

	protected ChromeDriver wd;

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

	public void deletSelectedGroups() {
		wd.findElement(By.name("delete")).click();
	}

	public void selectGroup() {
		wd.findElement(By.name("selected[]")).click();
	}

}
