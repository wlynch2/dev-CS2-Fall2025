package edu.westga.cs1302.javafx_sample_starter.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import edu.westga.cs1302.javafx_sample_starter.model.DataClass;

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
    	selector.getItems().addAll("High", "Med", "low");
    }
    
    @FXML
    void addName(ActionEvent event) {
    	String task = this.getDataClassName();
    	String description = this.getDataClassDescription();
    	String priority = selector.getValue();
    	
    	
    	DataClass data = new DataClass(task, description, priority);
    	
    	this.list.getItems().add(data.getTask() + " - " +
    	data.getDescription() + data.getPriority());
    	
    	
    	
 
    }

    @FXML
    void popUp(ActionEvent event) {
  
    }
    
    
    public String getDataClassName() {
    	String task = this.task.getText();
    	DataClass data = new DataClass(task, "", "");
    	return data.getTask();
    }
    
    public String getDataClassDescription() {
    	String description = this.description.getText();
    	DataClass data = new DataClass("", description, "");
    	return data.getDescription();
    }
    

}
