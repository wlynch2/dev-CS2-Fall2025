package edu.westga.cs1302.password_generator.viewmodel;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
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
    private StringProperty minimumLength;
    private StringProperty generatedPassword;
    private StringProperty errorMessage;
    
    public PasswordViewModel( ) {
    	this.includeDigits = new SimpleBooleanProperty(false);
    	this.includeLowerCase = new SimpleBooleanProperty(false);
    	this.includeUpperCase = new SimpleBooleanProperty(false);
    	this.minimumLength = new SimpleStringProperty("");
    	this.generatedPassword = new SimpleStringProperty("");
    	this.errorMessage = new SimpleStringProperty("");
    	
    }
    
    public BooleanProperty includeDigitsProperty() {
    	return this.includeDigits;
    }
    
    public BooleanProperty includeLowerCaseProperty() {
    	return this.includeLowerCase;
    }
    
    public BooleanProperty includeUpperCaseProperty() {
    	return this.includeUpperCase;
    }
    
    public StringProperty minimumLengthProperty() {
    	return this.minimumLength;
    }
    
    public StringProperty generatedPasswordProperty() {
    	return this.generatedPassword;
    }
    
    public StringProperty errorMessageProperty() {
    	return this.errorMessage;
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