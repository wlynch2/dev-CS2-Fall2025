package edu.westga.cs1302.javafx_sample_starter.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Priority;
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
	    private ListView<DataClass> list;

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
    	selector.getItems().addAll("High", "Med", "low");
    }
    
    @FXML
    void addName(ActionEvent event) {
    	String task = this.getDataClassName();
    	String description = this.getDataClassDescription();
    	String priority = selector.getValue();
    	
    	try {
        	DataClass data = new DataClass(task, description, priority);
        	this.taskPriority.setText(data.getPriority());
        	
        	this.list.getItems().add(data);
            this.descriptionOutput.setText(data.getDescription());
            this.taskPriority.setText(data.getPriority());
    	} 
    	catch (IllegalArgumentException e) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setContentText(e.getMessage());
    		alert.showAndWait();
    	}
    	

    	
    
    	
    	
    }
    
    @FXML
    void changeDescription(ActionEvent event) {
    	this.descriptionOutput.clear();
    	
    	String description = this.getDataClassDescription();
    	DataClass item = list.getSelectionModel().getSelectedItem();
    	String des = item.getDescription();
    	DataClass data = new DataClass("", des, "");
    	
    	if (item != null) {
    		this.descriptionOutput.clear();
    		
    		this.descriptionOutput.setText(description);
    	}
    }

    @FXML
    void popUp(ActionEvent event) {
  
    }
    @FXML
    void changeTask(MouseEvent event) {
    		
    		try {
    			DataClass item = list.getSelectionModel().getSelectedItem();
    			
    			String prevDescription = item.getDescription();
    			String prevPriority = item.getPriority();
    			
    			String d = description.getText();
    			DataClass data = new DataClass("", d, "");
    			if (item != null) {
    				
    				this.descriptionOutput.setText(prevDescription);
    				this.taskPriority.setText(prevPriority); 
    		
    			}
    	
    		}
    		catch(NullPointerException n) {
        		Alert alert = new Alert(Alert.AlertType.ERROR);
        		alert.setContentText("No Task In List");
        		alert.showAndWait();
    		}
    }
    
    @FXML
    void removeTask(ActionEvent event) {
    	DataClass item = list.getSelectionModel().getSelectedItem();
    	if (item != null) {
    		list.getItems().remove(item);
    		this.descriptionOutput.clear();
    		this.taskPriority.clear();
    	}
    }
    

    @FXML
    void displayTask(ActionEvent event) {
    	int listSize = list.getItems().size();
    	int high = 0;
    	int med = 0;
    	int low = 0;
    	
    	for (DataClass list : list.getItems()) {
    		if (list.getPriority().equals("High")) {
    			high++;
    		} else if (list.getPriority().equals("Med")) {
    			med++;
    		} else if (list.getPriority().equals("low")) {
    			low++;
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
