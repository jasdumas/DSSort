package Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LabFour {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BufferedReader 		input;
		BufferedWriter 		output;
		LabFour				lab;
		String				z;
		SimpleDateFormat 	dateFormat;
		Date				date;
		String				startTime;
		String				endTime;
		
		lab = new LabFour();
		dateFormat = new SimpleDateFormat("HH:mm:ss:SSS");
		date = new Date();
		
		//  Check for two command line arguments.
        if (args.length != 2) {
            System.out.println("Usage:  java Recursion.LabTwo [input file]" +
                " [output file]");
            System.exit(1);
        }
        
		//  Open the input and output files.
        try {
            input = new BufferedReader(new FileReader(args[0]));
            output = new BufferedWriter(new FileWriter(args[1]));
        } catch (Exception exception) {
            System.err.println(exception.toString());
            return;
        }
        
        z = lab.readInput(input);
        
        
        // store the time just before the sort begins
        startTime = dateFormat.format(date);
        
        
        System.out.println("Test");
		
        
		// store the time just after the sort completes
        endTime = dateFormat.format(date);
		
        // send data to output
        lab.writeOutput(startTime, endTime, output);
        
        // Close the input and output files and return to OS.
        try {
            input.close();
            output.close();
        } catch (Exception exception) {
            System.err.println(exception.toString());
        }
        return;
	}
	
	private String readInput(BufferedReader input) {
		
		String z = "";
		
        try {
             z = input.readLine();
        } catch (IOException ioException) {
            System.err.println(ioException.toString());
            System.exit(2);
        }
        
        return z;
	}
	
	/**
	 * Write the results to the output file in an easy-to-read format.
	 * @param intArray	the original matrix passed into the program
	 * @param det		the value of the determinant for the matrix.
	 * @param output	the output file.
	 */
	private void writeOutput(String startTime, String endTime, BufferedWriter output) {
		
		 try {
			 	output.write("Start Time = " + startTime);
			 	output.newLine();
			 	output.newLine();
			 	
			 	output.write("End Time = " + endTime);
			 	output.newLine();
			 	output.newLine();
			 	
	        } catch (IOException ioException) {
	            System.err.println(ioException.toString());
	            System.exit(3);
	        }
	        
	        return;
	}

}
