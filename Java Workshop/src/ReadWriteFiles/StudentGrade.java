package ReadWriteFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Add line no. to a file. 
 * 
 * Reference: 
 * Cay S. Horstmann. Big Java, 4th Edition, John Wiley & Sons. Feb, 2010 - Chapter 10.1 Reading and Writing Text Files
 * 
 * @author Emil Tan
 */
public class StudentGrade {
	public static void main(String[] args) {
		String studentFilename = "src/ReadWriteFiles/Students.txt"; 
		String gradeFilename = "src/ReadWriteFiles/Grades.txt"; 
		String outputFilename = "src/ReadWriteFiles/StudentsGrade.txt"; 

		try {
			System.out.println("Opening file: " + studentFilename);
			System.out.println("Opening file: " + gradeFilename);
			
			File studentFile = new File(studentFilename); 
			File gradeFile = new File(gradeFilename); 

			Scanner studentIn = new Scanner(studentFile); 
			Scanner gradeIn = new Scanner(gradeFile);
			
			try {
				System.out.println("Writing to file: " + outputFilename);
				PrintWriter out = new PrintWriter(outputFilename); 
				
				int gradeTotal = 0;
				int gradeNum = 0; 
				
				while(studentIn.hasNextLine() && gradeIn.hasNextLine()) {
					int grade = gradeIn.nextInt(); 
					out.println(studentIn.nextLine() + ": " + grade);
					
					gradeTotal += grade; 
					gradeNum++; 
				}
				
				double gradeAvg = (double)gradeTotal / (double)gradeNum; 
				out.print("Average Grade of Class: " + gradeAvg); 
				
				out.close();
			} catch(FileNotFoundException e) {
				System.out.println("Error occurred when writing to file " + outputFilename);
			}
			
			studentIn.close();
			gradeIn.close(); 
		} catch(FileNotFoundException e) {
			System.out.println("Error: Unable to open file!");
		}
	}
}
