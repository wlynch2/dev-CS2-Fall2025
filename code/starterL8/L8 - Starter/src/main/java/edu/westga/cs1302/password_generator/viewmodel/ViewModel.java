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
	private ObjectProperty<CollectionsData> selectedCollection;
	private ListProperty<CollectionsData> collectionList;
	
	/**
	 * constructor for ViewModel initializes all the fields as simpleProperties
	 */
	public ViewModel() {
		this.collectionName = new SimpleStringProperty("");
		this.selectedCollection = new SimpleObjectProperty<>();
		this.collectionList = new SimpleListProperty<CollectionsData>(FXCollections.observableArrayList(new ArrayList<CollectionsData>()));
	}
	
	/** getter method to get the name of the object 
	 *  method is going to be used to bind to the textField object collectionName
	 *  in the view class
	 * 
	 * @return collectionName a String property object meant to serve as the name
	 */
	public StringProperty getCollectionName() {
		return this.collectionName;
	}
	
	/** getter method for selectedColection to get the selected item in the listView
	 *  will be used to bind with the selectionModel of the listView
	 *  and to then remove any item that is focused
	 * 
	 * @return selectedCollection the objectProperty item that is currently selected
	 */
	public ObjectProperty<CollectionsData> getSelectedItem() {
		return this.selectedCollection;
	}
	
	/** getter method for collections list whos purpose is to get the current value of the 
	 * 	list, will be used to bind with the ListView object listOfCollections
	 *  and serve as the list holding all the data
	 * 
	 * @return collectionsList the current list of collectionsData;
	 */
	public ListProperty<CollectionsData> getCollectionsList() {
		return this.collectionList;
	}
	
	/** method used to add a item to the current list 
	 * creates a ColectionsData object and assigns it the value of the 
	 * collectionName String property than adds that data to the list
	 * 
	 * will be used in a lambda to set the action of the method with a event
	 * handler
	 */
	public void addItem() {
		CollectionsData data = new CollectionsData(this.collectionName.get());
		this.collectionList.add(data);
		
	}
	
	/** method used to remove the currently selected item from the list
	 *  creates a CollectionsData object assigns the value of the selectedCollection
	 *  ObjectProperty and removes that when the method is called
	 *  
	 *  will be used in a lambda to set the action of the method with a event
	 *  handler
	 */
	public void removeItem() {
		CollectionsData data = this.selectedCollection.get();
		if (data != null) {
			this.collectionList.remove(data);
		}
	}
	
}

