package edu.westga.cs1302.password_generator.view;

import edu.westga.cs1302.password_generator.viewmodel.OptionsWindowViewModel;
import javafx.fxml.FXML;
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
    	this.vm = new OptionsWindowViewModel();
    	
    	this.vm.getComicTitleProperty().bindBidirectional(this.comicTitle.textProperty());
    	this.vm.getIssueNumberProperty().bindBidirectional((this.issueNumber.textProperty()));
    	
    	this.confirmAdd.setOnAction((event) -> {
    		this.vm.addComic();
    	});
    	
    }
}
