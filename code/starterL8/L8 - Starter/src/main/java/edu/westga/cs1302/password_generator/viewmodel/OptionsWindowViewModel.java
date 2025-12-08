package edu.westga.cs1302.password_generator.viewmodel;

import java.util.ArrayList;

import edu.westga.cs1302.password_generator.model.CollectionsData;
import edu.westga.cs1302.password_generator.model.Comics;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

/** this class is meant to bind with the options window class. it handles the responsibilities of adding
 * a comic to the currently selected CollectionsData item.
 * 
 * @author wlynch2
 * @version CS1302 fall25
 */
public class OptionsWindowViewModel {
	private StringProperty comicTitleProperty;
	private StringProperty issueNumberProperty;
	private ListProperty<Comics> listOfComicsProperty;
	private ObjectProperty<CollectionsData> selectedCollection;
	private ObjectProperty<Comics> selectedComic;

	/**
	 * constructor for viewModel initializes all the properties with simple properties
	 */
	public OptionsWindowViewModel() {
		
		this.comicTitleProperty = new SimpleStringProperty("");
		this.issueNumberProperty = new SimpleStringProperty("");
		this.selectedCollection = new SimpleObjectProperty<>();
		this.listOfComicsProperty = new SimpleListProperty<Comics>(
				FXCollections.observableArrayList(new ArrayList<Comics>()));
		this.selectedComic = new SimpleObjectProperty<>();
	}
	
	/** getter method meant to bind with the Title textField in the OptionsWindow
	 *  will serve as the title as the comic and eventually be used in a map to find the object
	 * 
	 * @return String property the current comic Title
	 */
	public StringProperty getComicTitleProperty() {
		return this.comicTitleProperty;
	}
	
	/** getter method meant to bind with the issueNumer textField in the optionsWindow
	 * will serve as the issue number of the comic and eventually be used in a map to find the object
	 * 
	 * @return String property the current issueNumber
	 */
	public StringProperty getIssueNumberProperty() {
		return this.issueNumberProperty;
	}
	
	/** getter method meant to get the list of comics later to be used to add task to the comics list
	 * 
	 * @return listProperty the current list of comics
	 */
	public ListProperty<Comics> getListOfComicsProperty() {
		return this.listOfComicsProperty;
	}
	
	/** getter method meant to be used to find the currently selected item in the CollectionsData list
	 *  this method is important because it will be used to add items to specific collections in the list rather
	 *  than the entire list
	 * 
	 * @return ObjectProperty the currently selectedItem in the list
	 */
	public ObjectProperty<CollectionsData> getSelectedCollection() {
		return this.selectedCollection;
	}
	
	/** getter method meant to be used to find the currently selected item in the comics list
	 * 	used to remove items from the comics list
	 * 
	 * @return ObjectProperty the currently selected item in the comics list
	 */
	public ObjectProperty<Comics> getSelectedComic() {
		return this.selectedComic;
	}
	
	/** method that takes a CollectionsData object and finds its selection model
	 *  than if its not null defines a new comic object based on the textField inputs from the user
	 *  and adds that comic to the CollectionsData object
	 *  also adds it to the list of comics property
	 */
	public void addComic() {
		CollectionsData collection = this.selectedCollection.get();
		if (collection != null) {
			Comics comic = new Comics(this.comicTitleProperty.get(), Integer.parseInt(this.issueNumberProperty.get()));
			
			collection.getComicCollection().add(comic);
			this.listOfComicsProperty.add(comic);
		}
	}
	
	/** this is a helper method that clears the comics listview when the selected collection is changed. it than 
	 *  adds all the comics that were assigned to that selection collection
	 *  
	 *  @precondition selectedTask != null
	 * 
	 */
	public void showComics() {
		CollectionsData selectedTask = this.getSelectedCollection().get();
	    
    	if (selectedTask == null) {
    		throw new IllegalArgumentException("selectedTask cannot be null");
    	}
    	this.listOfComicsProperty.get().clear();

        if (selectedTask != null) {
            for (Comics currTask : selectedTask.getComicCollection()) {
                this.getListOfComicsProperty().get().add(currTask);
            }
        }
	}
	
	/** simple method makes a comic object and assigns it to its selection model than removes the currently selected comic
	 * in the list later to be used in a set on action
	 * 
	 */
	public void removeComic() {
		Comics comic = this.selectedComic.get();
		this.listOfComicsProperty.remove(comic);
	}
}
