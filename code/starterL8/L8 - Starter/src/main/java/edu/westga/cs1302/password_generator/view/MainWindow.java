package edu.westga.cs1302.password_generator.view;

import edu.westga.cs1302.password_generator.model.CollectionsData;
import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


/** Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
	@FXML
	private Button addCollection;
	
	@FXML
	private Button addComicButton;

	@FXML
	private ListView<CollectionsData> listOfCollections;
	
	@FXML
	private ListView<?> comicsListView;
	 
	@FXML
	private ContextMenu collectionMenu;

	@FXML
	private TextField collectionName;

	@FXML
    private Button removeCollections;
	
    @FXML
    private Button removeComicButton;
	
	private ViewModel vm;
	
	@FXML
	void initialize() {
		this.vm = new ViewModel();
		
		this.vm.getCollectionName().bind(this.collectionName.textProperty());
		this.listOfCollections.setItems(this.vm.getCollectionsList());
		this.vm.getSelectedItem().bind(this.listOfCollections.getSelectionModel().selectedItemProperty());
		
		this.collectionName.textProperty().addListener((observable, oldValue, newValue) -> {
			this.addCollection.setVisible(!newValue.isEmpty());
		});
		
		this.addCollection.setOnAction((event) -> {
			this.vm.addItem();
		});
		
		this.removeCollections.setOnAction((event) -> {
			this.vm.removeItem();
		});
	}

}
