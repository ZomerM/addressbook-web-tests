import org.junit.Test;
import org.openqa.selenium.By;

public class GroupCreationTests extends TestBase {
	@Test
	public void testGroupCreation() {

		app.gotoGroupPage();
		app.initGroupCreation();
		//wd.findElement(By.name("group_name")).click();
		//wd.findElement(By.name("group_name")).clear();
		app.fillGroupForm(new GroupData("Test1", "Test2", "test3"));
		app.submitGroupCreation();
		app.returnToGroupPage();
	}
}
