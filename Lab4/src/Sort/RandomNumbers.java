package Sort;

import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.*;

public class RandomNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BufferedWriter 	output;
		int				random;
		int				max;
		RandomNumbers	object;
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		Random number = new Random();
		object = new RandomNumbers();
		
		//  Check for two command line arguments.
        if (args.length != 1) {
            System.out.println("Usage:  java Sort.RandomNumbers [output file]");
            System.exit(1);
        }
		
        //  Open the output file and read in the count.
        try {
            output = new BufferedWriter(new FileWriter(args[0]));
        } catch (Exception exception) {
            System.err.println(exception.toString());
            return;
        }
		
		System.out.println(dateFormat.format(date) + "\n");
		
		max = 5000;
		for (int i = 0; i < max; i++) {
			
			random = number.nextInt(max);
			
			object.writeOutput(random, output);
		}
		
		
        // Close the output file and return to OS.
        try {
            output.close();
        } catch (Exception exception) {
            System.err.println(exception.toString());
        }
        return;
	}

	/**
	 * Write the random numbers to the output file.
	 * @param random	the random number
	 * @param output	the output file.
	 */
	private void writeOutput(int random, BufferedWriter output) {
		
		// use the following command to check for duplicates (changing the 2 to 3 or 4 as necessary):
		// "cat output.txt | uniq -c | awk '{print $1}' | grep 2"
		
		try {
			 	System.out.println(random);
			 	output.write(String.valueOf(random));
			 	output.newLine();
			 	
	        } catch (IOException ioException) {
	            System.err.println(ioException.toString());
	            System.exit(3);
	        }
	        
	        return;
	}
}
