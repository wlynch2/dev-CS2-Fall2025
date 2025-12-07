package edu.westga.cs1302.password_generator.viewmodel;

import java.util.ArrayList;

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
	private ObjectProperty<Comics> selectedComic;
	
	public OptionsWindowViewModel() {
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
	
	public ObjectProperty<Comics> getSelectedComic() {
		return this.selectedComic;
	}
	
	public void addComic() {
		Comics comic = new Comics(this.comicTitleProperty.get(), Integer.parseInt(this.issueNumberProperty.get()));
		this.listOfComicsProperty.add(comic);
	}
	
	public void removeComic() {
		Comics comic = this.selectedComic.get();
		this.listOfComicsProperty.remove(comic);
	}
	
}
