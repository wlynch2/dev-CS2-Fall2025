package mainWindowViewModel;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.contact_manager.viewmodel.MainWindowViewModel;

public class testFindContact {
	/**
	 * ran out of time i procracinated :(
	 */
	
	@Test
	void testExceptionWhenEmpty() {
		MainWindowViewModel viewModel = new MainWindowViewModel();
		
		assertThrows(IllegalArgumentException.class, () -> {viewModel.findContact();});
	}
	
	@Test
	void testExceptionWhenInvalidPhoneNumber() {
		MainWindowViewModel viewModel = new MainWindowViewModel();
		
		viewModel.getPhoneNumber().set("10");
		viewModel.getName().set("Will");
	
		assertThrows(IllegalArgumentException.class, () -> {viewModel.findContact();});
	}
	
	
	@Test
	void testExceptionWhenInvalidName() {
		MainWindowViewModel viewModel = new MainWindowViewModel();
		
		viewModel.getPhoneNumber().set("1234567");
		viewModel.getName().set("15");
	
		assertThrows(IllegalArgumentException.class, () -> {viewModel.findContact();});
	}
	
	
	
	
}
