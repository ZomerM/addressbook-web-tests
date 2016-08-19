import org.junit.Test;
import org.openqa.selenium.By;

public class GroupCreationTests extends TestBase {
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
}
