package mainWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.contact_manager.model.Contact;

import edu.westga.cs1302.contact_manager.viewmodel.MainWindowViewModel;
import javafx.collections.ObservableList;

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
	void testValidSize() {
		MainWindowViewModel viewModel = new MainWindowViewModel();
		viewModel.getPhoneNumber().set("1234567");
		viewModel.getName().set("will");
		
		viewModel.addContact();
		
		assertEquals(1 , viewModel.getContacts().size());
	}
	
	@Test
	void testNameIsBeingAddedToMap() {
		MainWindowViewModel viewModel = new MainWindowViewModel();
		viewModel.getPhoneNumber().set("1234567");
		viewModel.getName().set("will");
		
		viewModel.addContact();
		
		
	}
}
