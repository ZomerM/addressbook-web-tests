package tests;
import org.junit.Test;

public class GroupDeletionTests extends TestBase {

	@Test
	public void testGroupDeletion() {

		app.gotoGroupPage();
		app.selectGroup();
		app.deletSelectedGroups();
		app.returnToGroupPage();

	}
}
