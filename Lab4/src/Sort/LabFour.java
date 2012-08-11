package Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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
		int					number;
		int					index;
		int[]				values;
		
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
        
        // start with the first integer in the file
        z = lab.readInput(input);
        
        // determine the size of the array based on the number of integers in the input file
        index = 0;
        while (z != null) {
        	
        	index++;
        	z = lab.readInput(input);
        }
        
        System.out.println("There are " + index + " integers in the input file.");
        
        
		//  Open the input file again to begin processing.
        try {
           input = new BufferedReader(new FileReader(args[0]));
        } catch (Exception exception) {
            System.err.println(exception.toString());
            return;
        }
        
        // store the input for processing
        number = 0;
        values = new int[index];    	
        for (int i = 0; i < index; i++) {
        	
        	z = lab.readInput(input);
        	
        	if (z == null)
        		break;
        	else
        		number = Integer.parseInt(z);
        		values[i] = number;
        }
        
        //what does the array look like?
        System.out.println(Arrays.toString(values));
        System.out.println(values.length);
        
        
        // store the time just before the sort begins
        startTime = dateFormat.format(date);
        
        //lets start sorting!
        //Heap Sort is up first
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
