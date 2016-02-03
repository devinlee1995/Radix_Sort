import java.io.PrintWriter;


public class Stack {
	private Node Top; 
	
	public Stack() {
		Top = null; 
	}
	
	public void push(Node n) {
		n.setNext(Top);
		Top = n; 
	}
	
	public Node pop() {
		if (!isEmpty()) {
			Node temp = Top; 
			Top = Top.getNext(); 
			return temp;  
		}
		else {
			throw new IllegalArgumentException("Empty!"); 
		}
	}
	
	public boolean isEmpty() {
		if (Top == null) {
			return true; 
		}
		return false; 
	}
	
	public void printStack(PrintWriter print_to_outputfile) {
			Node spot = Top;
		    print_to_outputfile.print("STACK: " + "\n");  
		    print_to_outputfile.print("TOP --> (" + spot.getData() + " , " + spot.getNext().getData()+ ")");
		    
		    while (spot!= null) {
		        spot = spot.getNext();
		        if (spot.getNext() == null) {
		        	print_to_outputfile.print("--> (" + spot.getData() + ", NULL)");
		            break;
		        }
		        else {
		        	print_to_outputfile.print("--> (" + spot.getData() + " , " + spot.getNext().getData() + ")");
		        }
		    }
		    print_to_outputfile.print("\n" + "\n" + "\n"); 
		
	}

}
