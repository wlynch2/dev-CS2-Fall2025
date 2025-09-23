package edu.westga.cs1302.cms.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.westga.cs1302.cms.model.Student;

/** Suppports saving and loading student data,
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class StudentDataPersistenceManager {
	
	/** Save the students!
	 * 
	 * @precondition students != null
	 * @postcondition none
	 * 
	 * @param students the set of students to save
	 * @throws IOException
	 */
	public static void saveStudentData(Student[] students) throws IOException {
		try (FileWriter writer = new FileWriter("names.txt")) {
		
			for (Student currStudent : students) {
				writer.write(currStudent.getName() + System.lineSeparator());
				writer.write(currStudent.getGrade());
				writer.write(System.lineSeparator());
		
			}
		} 
		
			
	}

	/** Load the students!
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the set of students loaded
	 * @throws FileNotFoundException
	 * @throws NumberFormatException file is not properly formatted. failed to convert grade value to int when reading
	 * @throws NoSuchElementException file is not formatted properly, to read a line when trying to read a grade value
	 */
	public static Student[] loadStudentData() throws FileNotFoundException, NumberFormatException, NoSuchElementException {
		ArrayList<Student> students = new ArrayList<Student>();
		File inputFile = new File("names.txt");
		try (Scanner reader = new Scanner(inputFile)) {
			while (reader.hasNextLine()) {
				String name = reader.nextLine();
				int grade = Integer.parseInt(reader.nextLine());
				Student nextStudent = new Student(name, grade);
				students.add(nextStudent);
			}
		}catch (NumberFormatException e) {
				throw new IOException(e.getMessage());
			} catch (NoSuchElementException e) {
				throw new IOException(e.getMessage());
			}
			
	}
		return (Student[]) students.toArray();
		
	}
	
}
