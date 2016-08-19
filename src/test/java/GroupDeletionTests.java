import org.junit.Test;

public class GroupDeletionTests extends TestBase {

	@Test
	public void testGroupDeletion() {

		gotoGroupPage();
		selectGroup();
		deletSelectedGroups();
		returnToGroupPage();

	}
}
