package edu.westga.cs1302.password_generator.view;


import edu.westga.cs1302.password_generator.viewmodel.OptionsWindowViewModel;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class OptionsWindow {

    @FXML
    private Button cancelAdd;

    @FXML
    private TextField comicTitle;

    @FXML
    private Button confirmAdd;

    @FXML
    private TextField issueNumber;
    
    private OptionsWindowViewModel vm;

    @FXML
    void initialize() {
  
    }
    
    /** sets the view model elements for the mainWindows pop up window
     * 	initializes the viewModel with the constructor and binds the text fields with their relative
     *  textProperties. has two lamdas responsible for adding a comic and canceling the addition of a comic by closing
     *  the window 
     * 
     * @precondition vm cannot be null
     * @postcondition none
     * 
     * @param vm the set viewmodel for the window to read from
     */
    public void setViewModel(OptionsWindowViewModel vm) {
    	if (vm == null) {
    		throw new IllegalArgumentException("vm cannot be null");
    	}
    	
    	this.vm = vm;
    	
    	this.vm.getComicTitleProperty().bindBidirectional(this.comicTitle.textProperty());
    	this.vm.getIssueNumberProperty().bindBidirectional((this.issueNumber.textProperty()));
    	
    	this.confirmAdd.setOnAction((event) -> {

    		this.vm.addComic();
    		
    	});
    	
    	this.cancelAdd.setOnAction((event) -> {
    		((Node) (this.comicTitle)).getScene().getWindow().hide();
    	});
    }
  
}
