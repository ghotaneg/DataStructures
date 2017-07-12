
public class Q2_LinkedList {
	
	Q2_Node head;
	
	public void prepend(String data){
		
		// Check if linked list is empty. if yes then add a new head.
		if(head == null){
			head = new Q2_Node(data);
			return;
		}
		Q2_Node newHead = new Q2_Node(data);
		
		newHead.next = head;
		head = newHead;
	}
	
	public void append(String data){
			
			// Check if linked list is empty. if yes then add a new head.
			if(head == null){
				head = new Q2_Node(data);
				return;
			}
			Q2_Node current = head;
			
			while(current.next != null){
				current = current.next;
			}
			
			current.next = new Q2_Node(data);
		}
	
	public void printLinkedList(){
		if(head == null){
			//System.out.println("Linked List is empty");
			System.out.println("| ");
			return;
		}
		Q2_Node current = head;
		
		while(current.next != null){
			System.out.print("| " + current.data + " ");
			current = current.next;
		}
		System.out.print("| " + current.data + " ");
		System.out.println();
	}
	
	public boolean getSearchedValue(String keyword){
		if(head == null){
			System.out.println("There are no keywords in the system");
			
			return false;
		}
		Q2_Node current = head;
		
		if(current.data.equals(keyword)){
			return true;
		}
		
		while(current.next != null){
			
			if(current.data.equals(keyword)){
				return true;
			}
			current = current.next;
		}
		// Check for the final node
		if(current.data.equals(keyword)){
			return true;
		}
		else{
			return false;
		}
		
	}

}
