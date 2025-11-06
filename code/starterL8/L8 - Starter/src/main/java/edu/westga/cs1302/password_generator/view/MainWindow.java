package edu.westga.cs1302.password_generator.view;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;

/** Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {

    @FXML private CheckBox mustIncludeDigits;
    @FXML private CheckBox mustIncludeLowerCaseLetters;
    @FXML private CheckBox mustIncludeUpperCaseLetters;
    @FXML private TextField minimumLength;
    @FXML private TextArea output;
    @FXML private Label errorTextLabel;
    @FXML private Button generatePasswordButton;
    @FXML private ListView passwordsList;
    
//    private StringProperty errorTxt;
    private ViewModel vm;
    
    @FXML
    void initialize() {
    	this.vm = new ViewModel();
    	this.vm.getRequireDigits().bind(this.mustIncludeDigits.selectedProperty());
    	this.vm.getRequireLowercase().bind(this.mustIncludeLowerCaseLetters.selectedProperty());
    	this.vm.getRequireUppercase().bind(this.mustIncludeUpperCaseLetters.selectedProperty());
    	this.minimumLength.setText(this.vm.getMinimumLength().getValue());
    	this.vm.getMinimumLength().bind(this.minimumLength.textProperty());
    	this.vm.getListOfPassword().bind(this.passwordsList.getSelectionModel().selectedItemProperty());
    	
//    	this.errorTxt = new SimpleStringProperty("");
//    	this.errorTxt.bind(this.vm.getErrorText());
//    	this.errorTxt.addListener(obvserable, oldValue, newValue) -> {
//    		if (newValue != null) {
//    			Alert alert = new Alert(AlertType.ERROR);
//    			ale
//    		}
//    	}
    	
    	this.output.textProperty().bind(this.vm.getPassword());
    	this.errorTextLabel.textProperty().bind(this.vm.getErrorText());
    	
    	this.generatePasswordButton.setOnAction(
    			(event) -> { 
    				this.vm.generatePassword();
    				
    			} 
    	);
    }
    

  
}
