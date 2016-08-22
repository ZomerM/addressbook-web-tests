package tests;
import org.junit.Test;

import model.GroupData;

public class GroupCreationTests extends TestBase {
	@Test
	public void testGroupCreation() {

		app.gotoGroupPage();
		app.getGroupHelper().initGroupCreation();
		//wd.findElement(By.name("group_name")).click();
		//wd.findElement(By.name("group_name")).clear();
		app.getGroupHelper().fillGroupForm(new GroupData("Test1", "Test2", "test3"));
		app.getGroupHelper().submitGroupCreation();
		app.getGroupHelper().returnToGroupPage();
	}
}
