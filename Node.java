
public class Node {
	private String data; 
	private Node next; 
	
	public Node (String x) {
		data = x;
		next = null; 
	}
	
	public void setNext(Node x) {
		next = x; 
	}
	
	public Node getNext() {
		return next; 
	}
	
	public void setData (String x) {
		data = x; 
	}
	
	public String getData () {
		return data; 
	}

}
