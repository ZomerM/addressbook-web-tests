package tests;

import org.junit.Test;

import model.GroupData;

public class GroupCreationTests extends TestBase {
	@Test
	public void testGroupCreation() {

		app.gotoGroupPage();
		app.initGroupCreation();
		app.fillGroupForm(new GroupData("Test1", "Test2", "test3"));
		app.submitGroupCreation();
		app.returnToGroupPage();
	}
}
