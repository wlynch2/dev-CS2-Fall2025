package edu.westga.cs1302.javafx_sample_starter.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

import edu.westga.cs1302.javafx_sample_starter.model.TaskDetails;
import edu.westga.cs1302.javafx_sample_starter.model.PriorityCount;

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
	    private ListView<TaskDetails> list;

	    @FXML
	    private TextField task;
	    
	    @FXML
	    private TextField taskPriority;

	    @FXML
	    private ComboBox<String> selector;
	  
	    @FXML
	    private TextField numHigh;

	    @FXML
	    private TextField numLow;

	    @FXML
	    private TextField numMed;

	    @FXML
	    private TextField numTask;
    
    /**
     * Perform any needed initialization of UI components and underlying objects.
     */
    public void initialize() {
    	this.selector.getItems().addAll("High", "Med", "low");
    	this.numHigh.setText("0");
    	this.numLow.setText("0");
    	this.numMed.setText("0");
    	this.numTask.setText("0");
    }
    
    /**
     * used to get all the data from the task, selector, and description and assign that values to the listView taskPriority and description output
     * 
     * @param event the button used to perform the method
     */
    @FXML
    void addTask(ActionEvent event) {
    	String task = this.getDataClassName();
    	String description = this.getDataClassDescription();
    	String priority = this.selector.getValue();
    	
    	try {
        	TaskDetails data = new TaskDetails(task, description, priority);
        	this.taskPriority.setText(data.getPriority());
        	
        	this.list.getItems().add(data);
            this.descriptionOutput.setText(data.getDescription());
            this.taskPriority.setText(data.getPriority());
            this.task.clear();
        	this.description.clear();
        	this.selector.getItems().clear();
        	this.selector.getItems().addAll("High", "Med", "low");
       
    	} catch (IllegalArgumentException error) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setContentText(error.getMessage());
    		alert.showAndWait();
    	}
    }
    
    /**
     * used to clear the current description and replace and 
     * set the description variable with the new description
     * 
     * @param event the button used to perform the method
     */
    @FXML
    void changeDescription(ActionEvent event) {
    	
    	try {
    		this.descriptionOutput.clear();
    		String description = this.getDataClassDescription();
    		TaskDetails item = this.list.getSelectionModel().getSelectedItem();
   
    		if (item != null) {
    			this.descriptionOutput.clear();
    			item.setDescription(description);
    		
    			this.descriptionOutput.setText(description);
    			
    		}
    	} catch (NullPointerException error) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setContentText("No Task In List");
    		alert.showAndWait();
    	}
    	this.description.clear();
    }
    
    /**
     * used to select the current item in the list view and change the taskPriority and the 
     * description output respectively 
     * @param event the button used to perform the method
     */
    @FXML
    void changeTask(MouseEvent event) {
    		
    		try {
    			TaskDetails item = this.list.getSelectionModel().getSelectedItem();
    			
    			String prevDescription = item.getDescription();
    			String prevPriority = item.getPriority();
    		
    			if (item != null) {
    				
    				this.descriptionOutput.setText(prevDescription);
    				this.taskPriority.setText(prevPriority); 
    		
    			}
    	
    		} catch (NullPointerException error) {
        		Alert alert = new Alert(Alert.AlertType.ERROR);
        		alert.setContentText("No Task In List");
        		alert.showAndWait();
    		}
    }
    
    /**
     * used to remove a task from the list and set the task counts all to zero
     * 
     * @param event the button used to perform the method
     */
    @FXML
    void removeTask(ActionEvent event) {
    	TaskDetails item = this.list.getSelectionModel().getSelectedItem();
    	
    	if (item != null) {
    		this.list.getItems().remove(item);
    		
    		this.descriptionOutput.clear();
    		this.taskPriority.clear();
    		
    		this.numHigh.setText("0");
    		this.numMed.setText("0");
    		this.numLow.setText("0");
    		this.numTask.setText("0");
    	}
    }
    
    /**
     * used to count the amount of each priority in the list and add it the total to its relative textField
     * 
     * @param event the button used to perform the method
     */
    @FXML
    void countPriority(ActionEvent event) {
    	   	
    	int listSize = this.list.getItems().size();
 
    	int high = PriorityCount.getPriortyCount("High", new ArrayList<>(this.list.getItems()));
    	int med = PriorityCount.getPriortyCount("Med", new ArrayList<>(this.list.getItems()));
    	int low = PriorityCount.getPriortyCount("low", new ArrayList<>(this.list.getItems()));
    
      	String strHigh = Integer.toString(high);
    	String strMed = Integer.toString(med);
    	String strLow = Integer.toString(low);
    	String strTask = Integer.toString(listSize);
    		
    	this.numHigh.setText(strHigh);
    	this.numMed.setText(strMed);
    	this.numLow.setText(strLow);
    	this.numTask.setText(strTask);
    	
    }
    
    /**
     * used to grab the value from the DataClass task parameter for further use
     * 
     * @return the task that is assigned to the DataClasses first parameter
     */
    public String getDataClassName() {
    	String task = this.task.getText();
    	TaskDetails data = new TaskDetails(task, "", "");
    	return data.getTask();
    }
    
    /**
     * Used to grab the Value from DataClass second parameter for further use
     * 
     * @return the description that is assigned to the DataClasses second parameter
     */
    public String getDataClassDescription() {
    	String description = this.description.getText();
    	TaskDetails data = new TaskDetails("", description, "");
    	return data.getDescription();
    }
}
