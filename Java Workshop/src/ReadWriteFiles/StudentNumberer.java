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
public class StudentNumberer {
	public static void main(String[] args) {
		String inputFilename = "src/ReadWriteFiles/Students.txt"; 
		String outputFilename = "src/ReadWriteFiles/StudentsLine.txt"; 

		try {
			System.out.println("Opening file: " + inputFilename);
			File inputFile = new File(inputFilename); 
			Scanner in = new Scanner(inputFile); 

			try {
				System.out.println("Writing to file: " + outputFilename);
				PrintWriter out = new PrintWriter(outputFilename); 

				int lineNum = 1; 
				while(in.hasNextLine()) {
					String content = in.nextLine(); 
					out.println(lineNum + ": " + content);
					lineNum++; 
				}

				out.close();
				System.out.println("--- Done ---");
			} catch(FileNotFoundException e) {
				System.out.println("Error occurred when writing to file " + outputFilename);
			} 
			in.close();
		} catch(FileNotFoundException e) {
			System.out.println("Error: Unable to open file " + inputFilename); 
		}
	}
}
