package edu.westga.cs1302.password_generator.viewmodel;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.Random;

/**
 * ViewModel for the MainWindow.
 * Handles business logic and state management.
 * 
 * @author CS1302
 * @version Fall 2024
 */
public class PasswordViewModel {

    private PasswordGenerator generator;

    private BooleanProperty includeDigits;
    private BooleanProperty includeLowerCase;
    private BooleanProperty includeUpperCase;
    private IntegerProperty minimumLength;
    private StringProperty generatedPassword;
    private StringProperty errorMessage;
    
    public PasswordViewModel(BooleanProperty includeDigits, BooleanProperty includeLowerCase, BooleanProperty includeUpperCase ) {
    	this.includeDigits = includeDigits;
    	this.includeLowerCase = includeLowerCase;
    	this.includeUpperCase = includeUpperCase;
    }
    
    
    public void generatePassword() {
    	int minimumLength = -1;
    	
    	try {
    		minimumLength = Integer.parseInt(this.minimumLength.getName());
    	} catch (NumberFormatException numberError) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("Invalid Minimum Length: must be a positive integer, but was " + this.minimumLength.getName());
    		alert.show();
    		return;
    	}
    	
    	try {
    		this.generator.setMinimumLength(minimumLength);
    	} catch (IllegalArgumentException invalidLengthError) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("Invalid Minimum Length: " + invalidLengthError.getMessage());
    		alert.show();
    		return;
    	}
    	
    	this.generator.setMustHaveAtLeastOneDigit(this.includeDigits.get());
    	this.generator.setMustHaveAtLeastOneLowerCaseLetter(this.includeLowerCase.get());
    	this.generator.setMustHaveAtLeastOneUpperCaseLetter(this.includeUpperCase.get());
    	
    	String password = this.generator.generatePassword();
    	
    	this.generatedPassword.set(password);
    }
   
}