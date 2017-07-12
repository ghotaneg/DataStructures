import java.util.Arrays;

public class TheStack {

	private int[] stackArray; 
	private int stackSize;
	private int topOfStack;
	
	public TheStack(int size) {
		stackArray = new int[size];
		stackSize = size;
		topOfStack = -1;
		Arrays.fill(stackArray, -1);
	}
	
	// Method to add new values on to the stack.
	public void push(int value){
		if(topOfStack + 1 < stackSize){
			topOfStack++;
			stackArray[topOfStack] = value;
			System.out.println("PUSH - The value '" + value + "' was added at top of the stack");
		}else{
			System.out.println("Sorry! The Stack is full.");
		}
	}
	
	// Method to remove the value from top of the stack.
	public int pop(){
		if(topOfStack >= 0){
			System.out.println("POP - The value '" + stackArray[topOfStack] + "' was removed from the stack");
			return stackArray[topOfStack--];
		}else{
			System.out.println("The stack is empty.");
			return -1;
		}
	}
	
	// Method to check if the stack if empty.
	public boolean isEmpty(){
		return topOfStack == -1;
	}
	
	// Method to check if the stack is full.
	public boolean isFull(){
		return (topOfStack == stackSize - 1);
	}
	
	// Method to check the value at top of the stack.
	public int peek(){
		System.out.println("The value at top of the stack is : " + stackArray[topOfStack]);
		return stackArray[topOfStack];
	}
	
	// Method to add multiple values to the stack.
	public void pushMany(String multipleValues){
		String[] stringArray = multipleValues.split(" ");
		for(String val : stringArray){
			push(Integer.parseInt(val));
		}
	}
	
	// Method to remove all the values from the stack.
	public void popMany(){
		for(int i = topOfStack; i >= 0; i--){
			pop();
		}
	}
	
	// Derek Banas's code to display the stack.
	public void displayTheStack(){
		
		for(int n = 0; n < 61; n++)System.out.print("-");
		
		System.out.println();
		
		for(int n = 0; n < stackSize; n++){
			
			System.out.format("| %2s "+ " ", n);
			
		}
		
		System.out.println("|");
		
		for(int n = 0; n < 61; n++)System.out.print("-");
		
		System.out.println();
		
		for(int n = 0; n < stackSize; n++){
			
			
			
			if(stackArray[n]== -1) System.out.print("|     ");
			
			else System.out.print(String.format("| %2s "+ " ", stackArray[n]));
			
		}
		
		System.out.println("|");
		
		for(int n = 0; n < 61; n++)System.out.print("-");
		
		System.out.println();
	
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TheStack theStack = new TheStack(10);
		theStack.displayTheStack();
		theStack.push(10);
		theStack.push(70);
		theStack.push(30);
		theStack.push(50);
		theStack.displayTheStack();
		System.out.println("Is the stack empty? : " + theStack.isEmpty());
		theStack.pop();
		theStack.pop();
		theStack.displayTheStack();
		System.out.println("Is the stack Full? : " + theStack.isFull());
		theStack.push(67);
		theStack.displayTheStack();
		theStack.peek();
		theStack.push(80);
		theStack.peek();
		theStack.pop();
		theStack.pop();
		theStack.pop();
		theStack.pop();
		theStack.pop();
		theStack.pop();
		theStack.pushMany("234 77 12 35 98");
		theStack.displayTheStack();
		theStack.popMany();
		System.out.println("Is the stack empty? : " + theStack.isEmpty());
	}

}
