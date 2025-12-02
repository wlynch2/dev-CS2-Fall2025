package mainWindowViewModel;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.contact_manager.model.Contact;
import edu.westga.cs1302.contact_manager.viewmodel.MainWindowViewModel;

public class testMainWindowViewModelConstructor {
	
	@Test
	void testName() {
		MainWindowViewModel viewModel = new MainWindowViewModel();
		
		assertEquals("", viewModel.getName().get());
	}
	
	@Test
	void testPhoneNumber() {
		MainWindowViewModel viewModel = new MainWindowViewModel();
		
		assertEquals("", viewModel.getPhoneNumber().get());
	}
	
	@Test
	void testSearchCriteria() {
		MainWindowViewModel viewModel = new MainWindowViewModel();
		
		assertEquals("", viewModel.getSearchCriteria().get());
	}
	
	@Test
	void testIfListIsEmpty() {
		MainWindowViewModel viewModel = new MainWindowViewModel();
		
		assertTrue(viewModel.getContacts().isEmpty());
	}
	
	@Test
	void testPhoneNumberMap() {
		MainWindowViewModel viewModel = new MainWindowViewModel();
		
		assertTrue(viewModel.getPhoneNumberMap().isEmpty());
	}
	
	@Test
	void testNameMap() {
		MainWindowViewModel viewModel = new MainWindowViewModel();
		
		assertTrue(viewModel.getNameMap().isEmpty());
	}
}
