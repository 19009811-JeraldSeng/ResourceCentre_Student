import static org.junit.Assert.*;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;

	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;

	public ResourceCentreTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList = new ArrayList<Camcorder>();
		chromebookList = new ArrayList<Chromebook>();
	}

	@Test
	public void addCamcorderTest() {
		// Item list is not null, so that a new item can be added
		assertNotNull("Test if there is a valid Camcorder arraylist to add to", camcorderList);

		// Given an empty list, the size of the list is 1 after 1 item is added
		ResourceCentre.addCamcorder(camcorderList, cc1);
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());

		// The item just added is the same as the first item of the list
		assertSame("Test that Camcorder added is the same as 1st item of the list?", cc1, camcorderList.get(0));

		// Add another item. test if the size of the list is 2?
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that the Camcorder arraylist size is 2?", 2, camcorderList.size());
	}

	@Test
	public void addChromebookTest() {
		// fail("Not yet implemented");
		// write your code here
		// Item list is not null, so that a new item can be added
		assertNotNull("Test if there is a valid Chromebook arraylist to add to", chromebookList);

		// Given an empty list, the size of the list is 1 after 1 item is added
		ResourceCentre.addChromebook(chromebookList, cb1);
		assertEquals("Test if that Chromebook arraylist size is 1?", 1, chromebookList.size());

		// The item just added is the same as the first item of the list
		assertSame("Test that the Chromebook added is the same as 1st item of the list?", cb1, chromebookList.get(0));

		// Add another item. test if the size of the list is 2?
		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test that the Camcorder arraylist size is 2?", 2, chromebookList.size());
	}

	@Test
	public void retrieveAllCamcorderTest() {
		// fail("Not yet implemented");
		// write your code here
		// Item list is not null, so that the item list can be retrieved
		assertNotNull("Test if there is valid Camcorder arraylist to view", camcorderList);

		// Given a list with items, test if the expected output string same as the list
		// of Camcorders retrieved
		// from the SourceCentre
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());
		String allCamcorder = ResourceCentre.retrieveAllCamcorder(camcorderList);
		String testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n", "CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n", "CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);

	}

	@Test
	public void retrieveAllChromebookTest() {
		// fail("Not yet implemented");
		// write your code here
		// Item list is not null, so that the item list can be retrieved
		assertNotNull("Test if there is valid Camcorder arraylist to view", chromebookList);

		// Given a list with items, test if the expected output string same as the list
		// of Chromebook retrieved
		// from the SourceCentre
		assertEquals("Test if that Chromebook arraylist size is 2?", 2, chromebookList.size());
		String allChromebook = ResourceCentre.retrieveAllChromebook(chromebookList);
		String testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n", "CB0011", "My Google Chromebook 1st",
				"Yes", "", "Mac OS");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n", "CB0012", "SAMSUNG Chromebook 4+", "Yes", "",
				"Win 10");
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allChromebook);

	}

	@Test
	public void doLoanCamcorderTest() {
		// fail("Not yet implemented");
		// write your code here
		// Item list is not null, so that an item can be loaned
		assertNotNull("Test if there is valid Camcorder available to loan", camcorderList);

		// Approve the loan of the first item
		Boolean approved = ResourceCentre.doLoanCamcorder(camcorderList, "CC0011", "21-7-2020");
		assertTrue("Test if available item is approved to loan", approved);

		// Given an approved status, item is not available to loan again
		approved = ResourceCentre.doLoanCamcorder(camcorderList, "CC0011", "21-7-2020");
		assertFalse("Test if approved item is not available to loan again", approved);

		// Setting the status of the second item to unavailable
		cc2.setIsAvailable(false);

		// Given the status unavailable, item is not available to loan
		approved = ResourceCentre.doLoanCamcorder(camcorderList, "CC0012", "21-7-2020");
		assertFalse("Test that unavailable item is not approved to loan", approved);

		// Item is not available to loan for non-existing items
		approved = ResourceCentre.doLoanCamcorder(camcorderList, "CC0013", "21-7-2020");
		assertFalse("Test that non-existing item is not approved to loan", approved);
	}

	@Test
	public void doLoanChromebookTest() {
		// fail("Not yet implemented");
		// write your code here
		// Item list is not null, so that an item can be loaned
		assertNotNull("Test if there is valid Chromebook available to loan", chromebookList);

		// Approve the loan of the first item
		Boolean approved = ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "21-7-2020");
		assertTrue("Test if available item is approved to loan", approved);

		// Given an approved status, item is not available to loan again
		approved = ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "21-7-2020");
		assertFalse("Test if approved item is not available to loan again", approved);

		// Setting the status of the second item to unavailable
		cb2.setIsAvailable(false);

		// Given the status unavailable, item is not available to loan
		approved = ResourceCentre.doLoanChromebook(chromebookList, "CB0012", "21-7-2020");
		assertFalse("Test that unavailable item is not approved to loan", approved);

		// Item is not available to loan for non-existing items
		approved = ResourceCentre.doLoanChromebook(chromebookList, "CB0013", "21-7-2020");
		assertFalse("Test that non-existing item is not approved to loan", approved);
	}

	@Test
	public void doReturnCamcorderTest() {
		// fail("Not yet implemented");
		// write your code here
		// Item list is not null, so that an item can be returned
		assertNotNull("Test if there is valid Camcorder to be returned", camcorderList);

		// Given a list of items, check if the available camcorder has been returned
		Boolean isTrue = ResourceCentre.doReturnCamcorder(camcorderList, "CC0011");
		assertFalse("Test if available camcorder is being returned", isTrue);

		// Check if unavailable item has been returned
		cc2.setIsAvailable(false);
		isTrue = ResourceCentre.doReturnCamcorder(camcorderList, "CC0012");
		assertTrue("Test if loaned camcorder is being returned", isTrue);

		// Check if non-existing item can be returned
		isTrue = ResourceCentre.doReturnCamcorder(camcorderList, "CC0013");
		assertFalse("Test if non-existing camcorder is being returned", isTrue);

	}

	@Test
	public void doReturnChromebookTest() {
		// fail("Not yet implemented");
		// write your code here
		// Item list is not null, so that an item can be returned
		assertNotNull("Test if there is valid Chromebook to be returned", chromebookList);

		// Given a list of items, check if the available chromebook has been returned
		Boolean isTrue = ResourceCentre.doReturnChromebook(chromebookList, "CB0011");
		assertFalse("Test if available chromebook is being returned", isTrue);

		// Check if unavailable item has been returned
		cb2.setIsAvailable(false);
		isTrue = ResourceCentre.doReturnChromebook(chromebookList, "CB0012");
		assertTrue("Test if loaned chromebook is being returned", isTrue);

		// Check if non-existing item can be returned
		isTrue = ResourceCentre.doReturnChromebook(chromebookList, "CB0013");
		assertFalse("Test if non-existing chromebook is being returned", isTrue);

	}

	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		camcorderList = null;
		chromebookList = null;

	}

}
