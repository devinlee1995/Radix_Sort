
public class Queue {
	private Node head;
	private Node tail;
	private Node dummy;
	
	public Queue() {
		dummy = new Node ("dummy");  
		head = dummy;
		tail = dummy; 
	}
	
	public Node getHead() {
		return head;
	}
	
	public Node getTail() {
		return tail; 
	}
	
	public void addTail(String x) {
		Node added = new Node(x); 
		if (isEmpty()) {
			head = dummy; 
			head.setNext(added); 
			tail = added; 
			tail.setNext(null);
		}
		
		else {
			tail.setNext(added);
			tail = tail.getNext(); 
		}
		
	}
	
	public String deleteHead() {
	    if (!isEmpty()) {
	        String return_data = head.getNext().getData();
	        head = head.getNext(); 
	        if (head == tail) {
	            head = head.getNext();
	        }
	        return return_data;
	    }
	    else {
	        throw new IllegalArgumentException("No!"); 
	    }
	}

	boolean isEmpty() {
	    return (head == null);
	}
	
	
	
}
