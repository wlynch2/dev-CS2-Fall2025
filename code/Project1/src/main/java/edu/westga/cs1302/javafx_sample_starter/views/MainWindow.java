package edu.westga.cs1302.javafx_sample_starter.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Controller class for drawing various things to our canvas window.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
	
	 @FXML
	    private TextArea description;

	    @FXML
	    private ListView<String> list;

	    @FXML
	    private TextField task;

	    @FXML
	    private ComboBox<String> selector;

    
    /**
     * Perform any needed initialization of UI components and underlying objects.
     */
    public void initialize() {
    	
    }
    
    @FXML
    void addName(ActionEvent event) {
    	this.list.getItems().add(this.task.getText());
    	this.selector.getItems().add(this.task.getText());
    }

    @FXML
    void popUp(ActionEvent event) {
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	alert.setContentText(this.selector.getValue());
    	alert.showAndWait();
    }
}
