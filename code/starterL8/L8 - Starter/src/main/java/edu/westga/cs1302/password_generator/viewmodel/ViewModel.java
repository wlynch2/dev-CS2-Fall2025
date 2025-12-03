package edu.westga.cs1302.password_generator.viewmodel;

import java.util.ArrayList;
import edu.westga.cs1302.password_generator.model.CollectionsData;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

/** Manages utilizing the model and makes properties available to bind the UI elements.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class ViewModel {
	private StringProperty collectionName;
	private ListProperty<CollectionsData> selectedCollection;
	private ListProperty<CollectionsData> collectionList;
	
	public ViewModel() {
		this.collectionName = new SimpleStringProperty("");
		this.selectedCollection = new SimpleListProperty<CollectionsData>(FXCollections.observableArrayList(new ArrayList<CollectionsData>()));
		this.collectionList = new SimpleListProperty<CollectionsData>(FXCollections.observableArrayList(new ArrayList<CollectionsData>()));
	}
	
	public StringProperty getCollectionName() {
		return this.collectionName;
	}
	
	public ListProperty<CollectionsData> getSelectedItem(){
		return this.selectedCollection;
	}
	
	public ListProperty<CollectionsData> getCollectionsList(){
		return this.collectionList;
	}
	
	public void addItem() {
		CollectionsData data = new CollectionsData(collectionName.get());
		this.collectionList.add(data);
		
	}
	
	public void removeItem() {
	
		CollectionsData data = this.collectionList.get(0);
		this.collectionList.remove(data);
	}
	
}

