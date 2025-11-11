package edu.westga.cs1302.password_generator.viewmodel.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.beans.property.ListProperty;

class TestGeneratePassword {

	@Test
	void testMinimumLengthNotANumber() {
		ViewModel vm = new ViewModel();
		vm.getMinimumLength().setValue("apple");
		
		vm.generatePassword();
		
		assertEquals("", vm.getPassword().getValue(), "checking the password property");
		assertEquals("Invalid Minimum Length: must be a positive integer, but was apple", vm.getErrorText().getValue(), "checking the error text property");
	}
	
	@Test
	void testMinimumLengthNotAValidNumber() {
		ViewModel vm = new ViewModel();
		vm.getMinimumLength().setValue("-2");
		
		vm.generatePassword();
		
		assertEquals("", vm.getPassword().getValue(), "checking the password property");
		assertEquals("Invalid Minimum Length: minimum length must be at least 1", vm.getErrorText().getValue(), "checking the error text property");
	}
	
	@Test
	void testValidInputProvided() {
		ViewModel vm = new ViewModel();
		vm.getMinimumLength().setValue("2");
		
		vm.generatePassword();
		
		assertTrue(vm.getPassword().getValue().length() >= 2, "checking the password property has an appropriate number of characters");
		assertEquals("", vm.getErrorText().getValue(), "checking the error text property");
	}
	
	@Test
	void testListIsEmptyWithNoValue() {
		ViewModel vm = new ViewModel();
		ListProperty<String> newList = vm.getListOfPassword();
		
		assertTrue(newList.isEmpty());
	}
	
	@Test
	void testWhenUserGeneratesPassword() {
		ViewModel vm = new ViewModel();
		ListProperty<String> newList = vm.getListOfPassword();
		
		vm.generatePassword();
		assertFalse(newList.isEmpty());
	}
	
	@Test
	void testSizeWhenUserGeneratesPassword() {
		ViewModel vm = new ViewModel();
		ListProperty<String> newList = vm.getListOfPassword();
		
		vm.generatePassword();
		assertEquals(1, newList.size());
	}
	
	@Test
	void testValWhenListHasOneItem() {
		ViewModel vm = new ViewModel();
		ListProperty<String> newList = vm.getListOfPassword();
		
		vm.generatePassword();
		assertEquals(newList.get(0), vm.getListOfPassword().get());
	}

}
