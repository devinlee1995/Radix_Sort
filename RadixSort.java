import java.io.PrintWriter;


public class RadixSort {
	private HashTable array_hash[]; 
	private int index;
	private int currentDigit_value; 
	private int total_number_of_Digit; 
	private int currentTable;
	private int previousTable; 
	
	public RadixSort() {
		array_hash = new HashTable[2]; 
		for (int i = 0; i < 2; i++) {
			array_hash[i] = new HashTable(); 
		}
	}
	
	public int hashFunction(String digit) {
		index = Integer.parseInt(digit); 
		return index; 
	}
	
	void totalDigit(String max_number) {
	    total_number_of_Digit = max_number.length();
	    
	}
	public String currentDigit(String value) {
		int number = value.length()-(currentDigit_value+1); 
		if (number < 0) {
			return "0"; 
		}
		else {
			return value.substring((value.length())-(currentDigit_value+1), (value.length())-(currentDigit_value));
		}
	}
	
	public void add_from_stack(Stack stack1, PrintWriter print_to_outputfile) {
		currentDigit_value = 0;//which digit in the number
	    currentTable = 0; //index of currentTable in array of hash tables
	    
	    
	    print_to_outputfile.print("ADDTAIL QUEUE Process: " + "\n");
	    while (!stack1.isEmpty()) {//Step 3
	        Node popped = stack1.pop();
	        String digit = currentDigit(popped.getData()); //gets the specified digit needed
	        hashFunction(digit); //gets index value
	        array_hash[currentTable].getD()[index].addTail(popped.getData()); //adding popped node to tail of queue 
	    }
	    
	    print_to_outputfile.print("\n" + "\n"); 
	    
	    array_hash[currentTable].printTable(print_to_outputfile);
	}
	
	public void sort_rest_of_table(PrintWriter print_to_outputfile) {
		currentDigit_value++;
	    currentTable = 1;
	    previousTable = 0;
	    int currentQueue = 0;
	    
	    while (currentDigit_value < total_number_of_Digit) {
	    	print_to_outputfile.print("Previous: " + "\n");
	        array_hash[previousTable].printTable(print_to_outputfile);
	        
	        while (currentQueue < array_hash[previousTable].getSize()) {
	            while (!array_hash[previousTable].getD()[currentQueue].isEmpty() && array_hash[previousTable].getD()[currentQueue].getHead().getNext() != null && array_hash[previousTable].getD()[currentQueue].getHead() != array_hash[previousTable].getD()[currentQueue].getHead().getNext())  {
	                Node deleted = new Node(array_hash[previousTable].getD()[currentQueue].deleteHead());
	                String current_digit = currentDigit(deleted.getData());
	                hashFunction(current_digit);
	                array_hash[currentTable].getD()[index].addTail(deleted.getData());//adding popped node to tail of queue
	            }
	            currentQueue++;
	        }
	        
	        
	        if (currentDigit_value+1 != total_number_of_Digit) {
	            int temp = currentTable;
	            currentTable = previousTable;
	            previousTable = temp;
	            currentQueue = 0;
	            currentDigit_value++;
	        }
	        else {
	            break;
	        }
	    }
	    
	    print_to_outputfile.print("Current: " + "/n");
	    array_hash[currentTable].printTable(print_to_outputfile);


	}

}
