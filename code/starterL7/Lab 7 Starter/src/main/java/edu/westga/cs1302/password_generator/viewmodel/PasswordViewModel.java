package edu.westga.cs1302.password_generator.viewmodel;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * View model for the MainWindow.
 * manages business logic
 * 
 * @author CS1302
 * @version Fall 2025
 */
public class PasswordViewModel {

    private PasswordGenerator generator;

    private BooleanProperty includeDigits;
    private BooleanProperty includeLowerCase;
    private BooleanProperty includeUpperCase;
    private StringProperty minimumLength;
    private StringProperty generatedPassword;
    private StringProperty errorMessage;
    
    /**
     * constructor for view model assigns all the fields with a new property
     */
    public PasswordViewModel() {
    	this.includeDigits = new SimpleBooleanProperty(false);
    	this.includeLowerCase = new SimpleBooleanProperty(false);
    	this.includeUpperCase = new SimpleBooleanProperty(false);
    	this.minimumLength = new SimpleStringProperty("");
    	this.generatedPassword = new SimpleStringProperty("");
    	this.errorMessage = new SimpleStringProperty("");
    	
    }
    
    /**
     * getter for the include digits property
     * 
     * @return the boolean property includeDigits
     */
    public BooleanProperty includeDigitsProperty() {
    	return this.includeDigits;
    }
    
    /**
     * getter for the  includeUpperCase property
     * 
     * @return the boolean property includeLowerCase
     */
    public BooleanProperty includeLowerCaseProperty() {
    	return this.includeLowerCase;
    }
    
    /**
     * getter for the  includeUpperCase property
     * 
     * @return the boolean property includeUpperCase
     */
    public BooleanProperty includeUpperCaseProperty() {
    	return this.includeUpperCase;
    }
    
    /**
     * getter for the  minimumLength property
     * 
     * @return the StringProperty property minimumLength
     */
    public StringProperty minimumLengthProperty() {
    	return this.minimumLength;
    }
    
    /**
     * getter for the  generatedPassword property
     * 
     * @return the StringProperty property generatedPassword
     */
    public StringProperty generatedPasswordProperty() {
    	return this.generatedPassword;
    }
    
    /**
     * getter for the  errorMessage property
     * 
     * @return the StringProperty property errorMessage
     */
    public StringProperty errorMessageProperty() {
    	return this.errorMessage;
    }
    
    /** method used to handle generating password for view
     * 
     * @precondition none
     * @postcondition none
     * 
     */
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