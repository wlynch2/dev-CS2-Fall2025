package edu.westga.cs1302.password_generator.view;

import java.io.IOException;

import edu.westga.cs1302.password_generator.Main;
import edu.westga.cs1302.password_generator.model.CollectionsData;
import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;


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
	
	@FXML
	void openOptionsWindow(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(Main.class.getResource(Main.GUI_RESOURCE2));
    	try {
			loader.load();
	    	Parent parent = loader.getRoot();
	    	Scene scene = new Scene(parent);
	    	Stage optionsWindow = new Stage();
	    	optionsWindow.setTitle("");
	    	optionsWindow.setScene(scene);
	    	optionsWindow.initModality(Modality.APPLICATION_MODAL);
	    	
	    	OptionsWindow controller = (OptionsWindow) loader.getController();
	    	optionsWindow.showAndWait();
		} catch (IOException error) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Failed to load options window. Error loading UI components;");
			alert.showAndWait();
		} catch (IllegalArgumentException error) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Failed to load options window. Error passing password generator to options window.");
			alert.showAndWait();
		}
	}

}
