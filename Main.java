import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main {
	public static void main (String [] args) {
		if (args.length < 2) {
			throw new IllegalArgumentException("Not enough arguments!"); 
		}
			String input_file_name = args[0]; 
			Scanner input_file;
			try {
				input_file = new Scanner(new File(input_file_name));
				String output_file_name = args[1]; 
				FileWriter fWriter;
				
				fWriter = new FileWriter(output_file_name, true);
				PrintWriter print_to_outputfile = new PrintWriter(fWriter);
				
				Stack stack1 = new Stack(); 
				
				String num;
				String max_num = input_file.next(); 
				Node data_in1 = new Node(max_num); 
				stack1.push(data_in1); 
				
				
				while (input_file.hasNext()) { 
					num = input_file.next(); 
					if (Integer.parseInt(num) > Integer.parseInt(max_num)) {
						max_num = num; 
					}
					Node data_in2 = new Node(num);
		            stack1.push(data_in2);
				}
				
				stack1.printStack(print_to_outputfile); 
				
				
				RadixSort radix = new RadixSort();
		        //Step 2: Determines digits in max number
		        radix.totalDigit(max_num);
		        
		        //Step 3: Take nodes from stack and addTail to Queue of currentTable
		        radix.add_from_stack(stack1, print_to_outputfile);
		        
		        //Steps 4, 5, 6, 7, 8: Make currentTable into previousTable, delete nodes from previousTable and sort them by the next digit in currentTable and keep doing this until current_digit_value >= total_digit_value
		        radix.sort_rest_of_table(print_to_outputfile);

		        
		        input_file.close();
		        print_to_outputfile.close();
		       
				
				
			} 
				catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	
	
			}
	}





