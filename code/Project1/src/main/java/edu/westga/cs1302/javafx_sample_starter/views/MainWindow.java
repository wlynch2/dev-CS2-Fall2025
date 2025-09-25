package edu.westga.cs1302.javafx_sample_starter.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import edu.westga.cs1302.javafx_sample_starter.model.TaskDetails;

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
    
    @FXML
    void addName(ActionEvent event) {
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
    
    @FXML
    void changeDescription(ActionEvent event) {
    	
    	try {
    		this.descriptionOutput.clear();
    		String description = this.getDataClassDescription();
    		TaskDetails item = this.list.getSelectionModel().getSelectedItem();
    		String des = item.getDescription();
    		
    		TaskDetails data = new TaskDetails("", des, "");
    	
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
    }

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
    
    @FXML
    void displayTask(ActionEvent event) {
    	   	
    	int listSize = this.list.getItems().size();
    	TaskDetails item = this.list.getSelectionModel().getSelectedItem();
    	int high = 0;
    	int med = 0;
    	int low = 0;   
    	
    	for (TaskDetails list : list.getItems()) {
    		if (list.getPriority().equals("High")) {
    			high++;
    		} else if (list.getPriority().equals("Med")) {
    			med++;
    		} else if (list.getPriority().equals("low")) {
    			low++;
    		} else if (list.getPriority().isEmpty()) {
    			this.numTask.setText("0");
    		}
    		
      		String strHigh = Integer.toString(high);
    		String strMed = Integer.toString(med);
    		String strLow = Integer.toString(low);
    		String strTask = Integer.toString(listSize);
    		
    		this.numHigh.setText(strHigh);
    		this.numMed.setText(strMed);
    		this.numLow.setText(strLow);
    		this.numTask.setText(strTask);
    		
    	}
    }
    
    /**
     * used to grab the value from the DataClass task param for further use
     * @return the task that is assigned to the DataClasses first param
     */
    public String getDataClassName() {
    	String task = this.task.getText();
    	TaskDetails data = new TaskDetails(task, "", "");
    	return data.getTask();
    }
    
    /**
     * Used to grab the Value from DataClass second param for further use
     * @return the description that is assigned to the DataClasses second param
     */
    public String getDataClassDescription() {
    	String description = this.description.getText();
    	TaskDetails data = new TaskDetails("", description, "");
    	return data.getDescription();
    }
}
