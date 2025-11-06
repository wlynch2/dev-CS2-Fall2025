package passwordViewModel;

import static org.junit.jupiter.api.Assertions.*; 

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.PasswordViewModel;

public class testPasswordViewModelConstuctor {
	
	@Test
	void testIncludeDigitsPropertyValue() {
		PasswordViewModel viewModel = new PasswordViewModel();
		
		assertFalse(viewModel.includeDigitsProperty().get());
	}
	
	@Test
	void testIncludeLowerCasePropertyValue() {
		PasswordViewModel viewModel = new PasswordViewModel();
		
		assertFalse(viewModel.includeLowerCaseProperty().get());
	}
	
	@Test
	void testIncludeUpperCasePropertyPropertyValue() {
		PasswordViewModel viewModel = new PasswordViewModel();
		
		assertFalse(viewModel.includeUpperCaseProperty().get());
	}
	
	@Test
	void testGeneratedPasswordPropertyValue() {
		PasswordViewModel viewModel = new PasswordViewModel();
		
		assertEquals("", viewModel.generatedPasswordProperty().get());
	}
	
//	@Test
//	void testMinimumLengthPropertyValue() {
//		PasswordViewModel viewModel = new PasswordViewModel();
//		
//		assertEquals("", viewModel.minimumLengthProperty().get());
//	}
//	
//	@Test
//	void testGeneratePasswordWithUpperCaseAndDigits() {
//		PasswordViewModel viewModel = new PasswordViewModel();
//		
//		viewModel.includeDigitsProperty().set(true);
//		viewModel.includeUpperCaseProperty().set(true);
//		
//		viewModel.generatePassword();
//		
//		String password = viewModel.generatedPasswordProperty().get();
//		
//		assertFalse(password.isBlank());
//	}
	
}
