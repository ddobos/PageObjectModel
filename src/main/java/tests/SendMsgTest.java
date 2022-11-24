package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ContactsPage;
import pages.MenuPage;
import utils.BaseTest;

/*
 * AC : 4 fields (name, email, subject, message) din care 3 mandatory  (name, email, message) si 1 optional (subject)
 * 
 * 1.  Send success message (All fields completed) --> Expect message : Thank you for your message. It has been sent.
 * 2.  Send message without name filed --> Expect message : The field is required
 * 3.  Send message without email filed --> Expect message : The field is required
 * 4.  Send message without message filed --> Expect message : The field is required
 * 5.  Send message without subject field --> Expect message : Thank you for your message. It has been sent.
 */

public class SendMsgTest extends BaseTest{
	
	@Test(priority = 1)
	public void sendSuccessMsgTest() {
		
//		MenuPage menu = new MenuPage(driver);
		ContactsPage contacts = menu.navigateToContactPage();
//		menu.navigateTo(menu.contactsLink);
		contacts.sendMessage("Test", "test@test.com", "My subject", "My message");
		
		assertTrue(contacts.getMessage(contacts.messageSendMsg, "Thank you for your message. It has been sent."));
	}
	
	@Test(priority = 2)
	public void sendMessageWithOutNameTest() {
		
		ContactsPage contacts = menu.navigateToContactPage();
		contacts.sendMessage("", "test@test.com", "My subject", "My message");
		
		assertTrue(contacts.getMessage(contacts.emptyFieldMsg, "The field is required"));
		assertTrue(contacts.getMessage(contacts.messageSendMsg, "One or more fields have an error. Please check and try again."));
	}

	@Test(priority = 3)
	public void sendMessageWithOutEmailTest() {
		
		ContactsPage contacts = menu.navigateToContactPage();
		contacts.sendMessage("Test", "", "My subject", "My message");
		
		assertTrue(contacts.getMessage(contacts.emptyFieldMsg, "The field is required"));
		assertTrue(contacts.getMessage(contacts.messageSendMsg, "One or more fields have an error. Please check and try again."));
	}
	
	@Test(priority = 4)
	public void sendMessageWithOutMessageTest() {
		
		ContactsPage contacts = menu.navigateToContactPage();
		contacts.sendMessage("Test", "test@test.com", "My subject", "");
		
		assertTrue(contacts.getMessage(contacts.emptyFieldMsg, "The field is required"));
		assertTrue(contacts.getMessage(contacts.messageSendMsg, "One or more fields have an error. Please check and try again."));
	}
	
	@Test(priority = 5)
	public void sendMessageWithOutSubjectTest() {
		ContactsPage contacts = menu.navigateToContactPage();
		contacts.sendMessage("Test", "test@test.com", "", "My message");
		
		assertTrue(contacts.getMessage(contacts.messageSendMsg, "Thank you for your message. It has been sent."));
	}
}
