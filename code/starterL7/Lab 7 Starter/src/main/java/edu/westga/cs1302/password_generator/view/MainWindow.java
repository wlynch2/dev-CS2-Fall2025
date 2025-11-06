package edu.westga.cs1302.password_generator.view;

import java.util.Random;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import edu.westga.cs1302.password_generator.viewmodel.PasswordViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/** Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {

    @FXML private CheckBox mustIncludeDigits;
    @FXML private CheckBox mustIncludeLowerCaseLetters;
    @FXML private CheckBox mustIncludeUpperCaseLetters;
    @FXML private TextField minimumLength;
    @FXML private TextArea output;
   
    private PasswordGenerator generator;
    private PasswordViewModel vm;

    @FXML
    void generatePassword(ActionEvent event) {
    	 this.vm.generatePassword();
    }

    @FXML
    void initialize() {
        assert this.mustIncludeDigits != null : "fx:id=\"mustIncludeDigits\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.mustIncludeLowerCaseLetters != null : "fx:id=\"mustIncludeLowerCaseLetters\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.mustIncludeUpperCaseLetters != null : "fx:id=\"mustIncludeUpperCaseLetters\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.minimumLength != null : "fx:id=\"minimumLength\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.output != null : "fx:id=\"output\" was not injected: check your FXML file 'MainWindow.fxml'.";
        
        this.vm = new PasswordViewModel();
        
        this.mustIncludeDigits.selectedProperty().bindBidirectional(this.vm.includeDigitsProperty());
        this.mustIncludeLowerCaseLetters.selectedProperty().bindBidirectional(this.vm.includeLowerCaseProperty());
        this.mustIncludeUpperCaseLetters.selectedProperty().bindBidirectional(this.vm.includeUpperCaseProperty());
        this.minimumLength.textProperty().bindBidirectional(this.vm.minimumLengthProperty());
        this.output.textProperty().bind(this.vm.generatedPasswordProperty());
        
        this.minimumLength.setText("1");
        Random randomNumberGenerator = new Random();
        this.generator = new PasswordGenerator(randomNumberGenerator.nextLong());
    }
}
