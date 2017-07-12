
public class Q1_LinkedList {
	Q1_Node head;
	
	public void append(int data){
		if(head == null){
			head = new Q1_Node(data);
			return;
		}
		Q1_Node current = head;
		while(current.next != null){
			current = current.next;
		}
		current.next = new Q1_Node(data);
	}
	
	public void deleteWithValue(int data){
		if(head == null){
			System.out.println("The linked list is empty hence cannot delete the data");
			return;
		}

		if(head.data == data){
			head = head.next;
			return;
		}
		
		Q1_Node current = head;
		while(current.next != null){
			if(current.next.data == data){
				current.next = current.next.next;
				return;
			}
		}
	}
	
	public String deleteAllNonPrimes(){
		
		String result = "";
		// Check if Linked List is empty.
		if(head == null){
			System.out.println("Delete All Non Primes - The linked list is empty hence cannot delete any data");
			result = "Delete All Non Primes - The linked list is empty hence cannot delete any data";
			return result;
		}
		
		Q1_Node current = head;
		
		while(current.next != null){
			 
			if(checkIfNonPrime(current.next.data)){
				current.next = current.next.next;
			}
			// Check if we have reached the end of the linked list. If yes, then stop.
			if(current.next == null) {
				System.out.println("*** END OF LINKED LIST ***");
				
				return result;
			}else{ // Move to the next element in linked list
				result += current.next.data+",";
				current = current.next;
			}
		}
		return result;
		
	}
	
	public boolean checkIfNonPrime(int num){
		
		// Check if Linked List is empty.
		if(head == null){
			System.out.println("The linked list is empty hence cannot check any data");
			return false;
		}
			
		int maxNoToCheck = num / 2;
		boolean flag = false;
		
		for(int i = 2; i <= maxNoToCheck; i++){
			if(num % i == 0){
				flag = true;
				System.out.println("The number '" + num + "' IS A NON PRIME number hence DELETED.");
				break;
			}
		}
		if(!flag){
			System.out.println("The number '" + num + "' is a prime number.");
		}
		return flag;
	}
	
	// My Method to print the linked list.
	public void printLinkedList(){
		if(head == null){
			System.out.println("The linked list is EMPTY.");
			return;
		}
		Q1_Node current = head;
		String result = "";
		while(current.next != null){
			result += "| " + current.data + ", " + current.next;
			current = current.next;
		}
		result += "| " + current.data + ", " + current.next;
		
		System.out.println("----------------------------");
		System.out.println("-------- LINKED LIST-------");
		System.out.println("----------------------------");
		System.out.println(result);
	}
}
