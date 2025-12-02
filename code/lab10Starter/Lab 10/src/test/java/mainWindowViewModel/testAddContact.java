package mainWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.contact_manager.model.Contact;

import edu.westga.cs1302.contact_manager.viewmodel.MainWindowViewModel;


public class testAddContact {
	
	@Test
	void testWhenDuplicateNameContact() {
		MainWindowViewModel viewModel = new MainWindowViewModel();
		
		viewModel.getPhoneNumber().set("1234567");
		viewModel.getName().set("will");
		
		viewModel.addContact();
		
		viewModel.getPhoneNumber().set("1234567");
		viewModel.getName().set("will");
		
		assertThrows(IllegalArgumentException.class, ()->{viewModel.addContact();});
	}
	
	@Test
	void testInvalidName() {
		MainWindowViewModel viewModel = new MainWindowViewModel();
		
		viewModel.getPhoneNumber().set("1234567");
		viewModel.getName().set("10");
		
		assertThrows(IllegalArgumentException.class, () -> {viewModel.addContact();});
	}
	
	void testInvalidPhoneNumber() {
		MainWindowViewModel viewModel = new MainWindowViewModel();
		
		viewModel.getPhoneNumber().set("1237");
		viewModel.getName().set("will");
		
		assertThrows(IllegalArgumentException.class, () -> {viewModel.addContact();});
	}
	
	@Test
	void testValidSize() {
		MainWindowViewModel viewModel = new MainWindowViewModel();
		viewModel.getPhoneNumber().set("1234567");
		viewModel.getName().set("will");
		
		viewModel.addContact();
		
		assertEquals(1 , viewModel.getContacts().size());
	}
	
	@Test
	void testSizeWithMultipleValues() {
		MainWindowViewModel viewModel = new MainWindowViewModel();
		viewModel.getPhoneNumber().set("1234567");
		viewModel.getName().set("will");
	
		
		viewModel.addContact();
		
		viewModel.getPhoneNumber().set("1334567");
		viewModel.getName().set("wll");
		
		viewModel.addContact();
		
		assertEquals(2 , viewModel.getContacts().size());
	}
	
	/**
	 * im not sure what im doing wrong with these test but i cant figure it out :( 
	 * im getting the value im looking for but instead of just getting the specific value im getting the entire Map 
	 * which is not what im looking for.
	 */
//	@Test
//	void testNameIsBeingAddedToMap() {
//		MainWindowViewModel viewModel = new MainWindowViewModel();
//		viewModel.getPhoneNumber().set("1234567");
//		viewModel.getName().set("will");
//		
//		viewModel.addContact();
//		
//		assertTrue(viewModel.getNameMap().containsValue("will"));
//		assertEquals("will", viewModel.getNameMap());
//	}
//	
//	@Test
//	void testPhoneNumberIsBeingAddedToMap() {
//		MainWindowViewModel viewModel = new MainWindowViewModel();
//		viewModel.getPhoneNumber().set("1234567");
//		viewModel.getName().set("will");
//		
//		viewModel.addContact();
//		
//		assertEquals("1234567", viewModel.getNameMap());
//		assertTrue(viewModel.getNameMap().containsKey("will"));
//	}
}
