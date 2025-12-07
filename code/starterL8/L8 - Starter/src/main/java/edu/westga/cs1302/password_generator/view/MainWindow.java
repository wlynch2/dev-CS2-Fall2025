package edu.westga.cs1302.password_generator.view;

import java.io.IOException;

import edu.westga.cs1302.password_generator.Main;
import edu.westga.cs1302.password_generator.model.CollectionsData;
import edu.westga.cs1302.password_generator.model.Comics;
import edu.westga.cs1302.password_generator.viewmodel.OptionsWindowViewModel;
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
import javafx.scene.control.MenuItem;
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
	private ListView<Comics> comicsListView;
	 
	@FXML
	private ContextMenu collectionMenu;

	@FXML
	private TextField collectionName;

	@FXML
    private Button removeCollections;
	
    @FXML
    private Button removeComicButton;
    
    @FXML
    private MenuItem removebuttonContext;
   
    @FXML
    private Button setComic;
	
	private ViewModel vm;
	private OptionsWindowViewModel vm2;
	
	
	@FXML
	void initialize() {
		this.vm = new ViewModel();
		this.vm2 = new OptionsWindowViewModel();
		
		this.vm.getCollectionName().bind(this.collectionName.textProperty());
		this.listOfCollections.setItems(this.vm.getCollectionsList());
		this.vm.getSelectedItem().bind(this.listOfCollections.getSelectionModel().selectedItemProperty());
		this.comicsListView.setItems(this.vm2.getListOfComicsProperty());
		this.vm2.getSelectedComic().bind(this.comicsListView.getSelectionModel().selectedItemProperty());
		
		this.collectionName.textProperty().addListener((observable, oldValue, newValue) -> {
			this.addCollection.setVisible(!newValue.isEmpty());
		});
		
		this.addCollection.setOnAction((event) -> {
			this.vm.addItem();
		});
		
		this.removeCollections.setOnAction((event) -> {
			this.vm.removeItem();
		});
		
		this.removebuttonContext.setOnAction((event) -> {
			this.vm.removeItem();
		});
		
		this.addComicButton.setOnAction((event) -> {
			this.openOptionsWindow(event);
		});
		
		this.removeComicButton.setOnAction((event) -> {
			this.vm2.removeComic();
		});
	}
	
	@FXML
	void openOptionsWindow(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(Main.class.getResource("/edu/westga/cs1302/password_generator/view/OptionsWindow.fxml"));
    	try {
			loader.load();
	    	Parent parent = loader.getRoot();
	    	Scene scene = new Scene(parent);
	    	Stage optionsWindow = new Stage();
	    	optionsWindow.setTitle("");
	    	optionsWindow.setScene(scene);
	    	optionsWindow.initModality(Modality.APPLICATION_MODAL);
	    	OptionsWindow controller = (OptionsWindow) loader.getController();
	    	controller.setViewModel(this.vm2);
	    	
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
