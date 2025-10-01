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
	
	@Test
	void testWithValidStudentName() throws IllegalArgumentException, IOException  {
		Student[] array = new Student[1];
		Student student = new Student("will", 100);
		array[0] = student;
 		StudentDataPersistenceManager.saveStudentData(array, "test-data.txt");
		File inputFile = new File("test-data.txt");
		try(Scanner reader = new Scanner(inputFile)){ 
			assertEquals("will,100", reader.nextLine());
		}
		
	}
	
	@Test
	void testWithMultipleStudentNames() throws IllegalArgumentException, IOException {
		Student[] array = new Student[3];
		Student student = new Student("will", 100);
		Student student2 = new Student("john", 80);
		Student student3 = new Student("doe", 70);
		array[0] = student;
		array[1] = student2;
		array[2] = student3;
 		StudentDataPersistenceManager.saveStudentData(array, "test-data.txt");
		File inputFile = new File("test-data.txt");
		try(Scanner reader = new Scanner(inputFile)){ 
			assertEquals("will,100", reader.nextLine());
			assertEquals("john,80", reader.nextLine());
			assertEquals("doe,70", reader.nextLine());
		}
	}
	
	@Test
	void testWhenSecondItemIsNull() throws IllegalArgumentException, IOException {
		Student[] array = new Student[3];
		Student student = new Student("will", 100);
		Student student3 = new Student("doe", 70);
		array[0] = student;
		array[1] = null;
		array[2] = student3;
 		StudentDataPersistenceManager.saveStudentData(array, "test-data.txt");
		File inputFile = new File("test-data.txt");
		try(Scanner reader = new Scanner(inputFile)){ 
			assertEquals("will,100", reader.nextLine());
			assertEquals("doe,70", reader.nextLine(), "purpose is to check if it skips over null elements");
			
		}
	}
	
	@Test
	void testWhenFirstItemIsNull() throws IllegalArgumentException, IOException {
		Student[] array = new Student[3];
		Student student = new Student("will", 100);
		Student student3 = new Student("doe", 70);
		array[0] = null;
		array[1] = student;
		array[2] = student3;
 		StudentDataPersistenceManager.saveStudentData(array, "test-data.txt");
		File inputFile = new File("test-data.txt");
		try(Scanner reader = new Scanner(inputFile)){ 
			assertEquals("will,100", reader.nextLine());
			assertEquals("doe,70", reader.nextLine(), "purpose is to check if it skips over null elements");
			
		}
	}
	
	@Test
	void testWhenlastItemItemIsNull() throws IllegalArgumentException, IOException {
		Student[] array = new Student[3];
		Student student = new Student("will", 100);
		Student student2 = new Student("doe", 70);
		array[0] = student;
		array[1] = student2;
		array[2] = null;
 		StudentDataPersistenceManager.saveStudentData(array, "test-data.txt");
		File inputFile = new File("test-data.txt");
		try(Scanner reader = new Scanner(inputFile)){ 
			assertEquals("will,100", reader.nextLine(), "purpose is to check if it skips over null elements");
			assertEquals("doe,70", reader.nextLine(), "purpose is to check if it skips over null elements");
			
		}
	}
	
	
	@Test
	void testWhenAllItemsAreNull()  throws IllegalArgumentException, IOException{
		Student[] array = new Student[3];

		array[0] = null;
		array[1] = null;
		array[2] = null;
 		StudentDataPersistenceManager.saveStudentData(array, "test-data.txt");
		File inputFile = new File("test-data.txt");
		try(Scanner reader = new Scanner(inputFile)){ 
			assertFalse(reader.hasNextLine());
		
		}
	}
}
