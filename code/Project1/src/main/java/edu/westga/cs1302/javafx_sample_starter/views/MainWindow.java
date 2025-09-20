package edu.westga.cs1302.javafx_sample_starter.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import edu.westga.cs1302.javafx_sample_starter.model.DataClass;
import edu.westga.cs1302.javafx_sample_starter.model.DataClassList;

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
	    private TextArea descriptionOutput;

	    @FXML
	    private ListView<String> list;

	    @FXML
	    private TextField task;
	    
	    @FXML
	    private TextField taskPriority;

	    @FXML
	    private ComboBox<String> selector;
	    
	    private DataClassList taskList = new DataClassList();

    
    /**
     * Perform any needed initialization of UI components and underlying objects.
     */
    public void initialize() {
    	selector.getItems().addAll("High", "Med", "low");
    }
    
    @FXML
    void addName(ActionEvent event) {
    	addTask();
    }
    
    @FXML
    void changeDescription(ActionEvent event) {
    	this.updateDescription();
    }

    @FXML
    void popUp(ActionEvent event) {
  
    }
    @FXML
    void changeTask(MouseEvent event) {

    }
    
    public void addTask() {
    	String task = this.getDataClassName();
    	String description = this.getDataClassDescription();
    	String priority = selector.getValue();
    	
    	DataClass data = new DataClass(task, description, priority);
    	this.taskList.addItem(data);
    	
    	this.list.getItems().add(data.getTask());
    	this.descriptionOutput.setText(data.getDescription());
    	this.taskPriority.setText(data.getPriority());
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
    
    public void updateDescription() {
    	this.descriptionOutput.clear();
    	String description = this.getDataClassDescription();
    	DataClass data = new DataClass(this.getDataClassName(), description, this.selector.getValue());
    	this.descriptionOutput.setText(data.getDescription());
    }
    
    public void swapTask() {
    	
    }

}
