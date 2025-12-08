package edu.westga.cs1302.password_generator.viewmodel;

import java.util.ArrayList;

import edu.westga.cs1302.password_generator.model.CollectionsData;
import edu.westga.cs1302.password_generator.model.Comics;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

public class OptionsWindowViewModel {
	private StringProperty comicTitleProperty;
	private StringProperty issueNumberProperty;
	private ListProperty<Comics> listOfComicsProperty;
	private ObjectProperty<CollectionsData> selectedComic;
	private ViewModel vm;
	
	
	
	public OptionsWindowViewModel() {
		
		this.vm = new ViewModel();
		this.comicTitleProperty = new SimpleStringProperty("");
		this.issueNumberProperty = new SimpleStringProperty("");
		this.selectedComic = new SimpleObjectProperty<>();
		this.listOfComicsProperty = new SimpleListProperty<Comics>(
				FXCollections.observableArrayList(new ArrayList<Comics>()));
	}
	
	public StringProperty getComicTitleProperty() {
		return this.comicTitleProperty;
	}
	
	public StringProperty getIssueNumberProperty() {
		return this.issueNumberProperty;
	}
	
	public ListProperty<Comics> getListOfComicsProperty(){
		return this.listOfComicsProperty;
	}
	
	public ObjectProperty<CollectionsData> getSelectedComic() {
		return this.selectedComic;
	}
	
	public void addComic() {
		CollectionsData collection = this.selectedComic.get();
		if (collection != null) {
			Comics comic = new Comics(this.comicTitleProperty.get(), Integer.parseInt(this.issueNumberProperty.get()));
			
			collection.getComicCollection().add(comic);
			this.listOfComicsProperty.add(comic);
		}
		
		
		
//		CollectionsData collection = this.selectedComic.get();
//		if (collection != null) {
//			Comics comic = new Comics(this.comicTitleProperty.get(), Integer.parseInt(this.issueNumberProperty.get()));
//			this.listOfComicsProperty.add(comic);
//		}
	}
	
	public void showComics() {
		CollectionsData selectedTask = this.getSelectedComic().get();
	    
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
	
	public void removeComic() {
		Comics comic = this.selectedComic.get();
		this.vm.getCollectionsList();
		
	}
	
}
