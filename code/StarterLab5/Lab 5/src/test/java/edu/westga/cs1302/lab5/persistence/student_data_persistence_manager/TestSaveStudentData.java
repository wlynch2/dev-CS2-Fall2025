package edu.westga.cs1302.lab5.persistence.student_data_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab5.model.Student;
import edu.westga.cs1302.lab5.persistence.StudentDataPersistenceManager;

class TestSaveStudentData {

	@Test
	void testWhenNoStudents() throws IllegalArgumentException, IOException {
		StudentDataPersistenceManager.saveStudentData(new Student[0], "test-data.txt");
		
		File inputFile = new File("test-data.txt");
		try(Scanner reader = new Scanner(inputFile)) {
			assertFalse(reader.hasNextLine(), "Checking if file is empty (Should have no lines)");
		}
	}
	
	@Test
	void testWhenArrayIsNull() throws IllegalArgumentException, IOException {		
			assertThrows(IllegalArgumentException.class, ()->{
				StudentDataPersistenceManager.saveStudentData(null, "test-data.txt");
			});
	}
	
	@Test
	void testWhenStudentisNull() throws IllegalArgumentException, IOException {
		Student[] array = new Student[0];
		StudentDataPersistenceManager.saveStudentData(array, "test-data.txt");
		File inputFile = new File("test-data.txt");
		try(Scanner reader = new Scanner(inputFile)){ 
			assertFalse(reader.hasNextLine());
		}
	}

}
