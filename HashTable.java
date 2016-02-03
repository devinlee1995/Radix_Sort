import java.io.PrintWriter;


public class HashTable {
	private int size = 10; 
	private Queue d[]; 
	
	public HashTable() {
		setD(new Queue[getSize()]);
		for (int i = 0; i < getSize(); i++) {
			getD()[i] = new Queue(); 
		}
	}
	
	public void printTable (PrintWriter print_to_outputfile) {
		print_to_outputfile.print("ENTIRE Queue: " + "\n"); 
	    
	    for (int i = 0; i < getSize(); i++) {
	        if (!getD()[i].isEmpty() && getD()[i].getHead().getNext() != null) {

	                Node spot = getD()[i].getHead();
	                print_to_outputfile.print("Queue w/ index: " + i + "\n");
	                print_to_outputfile.print("HEAD --> (" + spot.getData() + " , " + spot.getNext().getData() + ")");


	                while (spot.getNext() != null) {
	                	if (spot.getNext() != getD()[i].getTail()) {
	                    	spot = spot.getNext();
	                    	print_to_outputfile.print("--> (" + spot.getData()+ " , " + spot.getNext().getData() + ")");
	                    }
	                	else {
	                        spot = spot.getNext();
	                        print_to_outputfile.print("--> ("+ spot.getData() + " ,  NULL)");
	                        break;

	                    }
	                }
	            
	                print_to_outputfile.print("\n" + "\n"); 
	            
	        }
	    
	        
	        else {
	            
	        	 print_to_outputfile.print("Queue w/ index: " + i + "\n");
	        	 print_to_outputfile.print("HEAD --> (dummy ,  NULL)" + "\n" + "\n"); 
	                
	            
	        }
	        
	    }

	    print_to_outputfile.print("\n" + "\n" + "\n");
	}

	public Queue[] getD() {
		return d;
	}

	public void setD(Queue d[]) {
		this.d = d;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	

}
