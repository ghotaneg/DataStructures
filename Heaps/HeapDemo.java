import java.util.Arrays;

public class HeapDemo {
	
	int sizeOfHeap = 10;
	int noOfElementsInHeap = 0;
	int[] heapTree = new int[sizeOfHeap];
	
	// Method to swipe to elements of an array.
	public void swap(int indexOne, int indexTwo){
		int temp = heapTree[indexTwo];
		heapTree[indexTwo] = heapTree[indexOne];
		heapTree[indexOne] = temp;
	}
	
	// Method to check if array is full? If yes, then double the size of the array.
	public void checkArraySize(){
		if(noOfElementsInHeap == sizeOfHeap){
			heapTree = Arrays.copyOf(heapTree, sizeOfHeap*2);
			sizeOfHeap *= 2;
		}
	}
	
	// Method to get the left child index.
	public int getLeftChildIndex(int parentIndex){
		return (2 * parentIndex) + 1;
	}
	
	// Method to get the right child index.
	public int getRightChildIndex(int parentIndex){
		return (2 * parentIndex) + 2;
	}
	
	// Method to get the parent index.
	public int getParentIndex(int childIndex){
		return (childIndex - 1) / 2;
	}
	// ------------------------------------------------
	// Method to check if an element has left child.
	public boolean hasLeftChild(int index){
		return getLeftChildIndex(index) < noOfElementsInHeap;
	}
	
	// Method to check if an element has right child.
	public boolean hasRightChild(int index){
		return getRightChildIndex(index) < noOfElementsInHeap;
	}
	
	// Method to check if an elements has a parent.
	public boolean hasParent(int index){
		return getParentIndex(index) >= 0;
	}
	//--------------------------------------------------
	// Method to get the value of left child of an element.
	public int leftChildValue(int index){
		return heapTree[getLeftChildIndex(index)];
	}
	
	// Method to get the value of right child of an element.
	public int rightChildValue(int index){
		return heapTree[getRightChildIndex(index)];
	}
	
	// Method to get the value of parent of an element.
	public int parentValue(int index){
		return heapTree[getParentIndex(index)];
	}
	//*********************************************************
	
	// Method to get the root of the tree which will MIN or MAX based on if its MIN HEAP Or MAX HEAP.	
	public int peek(){	
		// If there are no elements in the heap then throw an exception;
		if(noOfElementsInHeap == 0) throw new IllegalStateException();
		
		// Else return the root value of the heap. i.e. the first element in the array.
		return heapTree[0];
	}
	
	// Method to remove the root element and assign a new root.
	public int removeRoot(){
		// If there are no elements in the heap then throw an exception;
		if(noOfElementsInHeap == 0) throw new IllegalStateException();
		
		int root = heapTree[0];
		heapTree[0] = heapTree[noOfElementsInHeap - 1];
		noOfElementsInHeap--;
		heapifyDown();
		return root;
	}
	
	// Method to add a new element to the heap.
	public void add(int data){
		checkArraySize();
		heapTree[noOfElementsInHeap] = data;
		noOfElementsInHeap++;
		heapifyUp();
	}
	
	// Heapify up - Assign the newly inserted value to its correct place in the heap.
	public void heapifyUp(){
		
		// Get the index of the last element.
		int index = noOfElementsInHeap - 1;
		
//		Continue looping through elements while the 
//		i)  index has a parent and 
//		ii) its parent's value is greater than the 
		while(hasParent(index) && parentValue(index) > heapTree[index]){
			swap(getParentIndex(index),index);
			index = getParentIndex(index);
		}
	}
	
	public void heapifyDown(){
		
		// Start with the root element index.
		int index = 0;
		
		// While there is a child continue to compare the values.
		while(hasLeftChild(index)){
			
			// Initially assume that the left child to be the smaller child.
			int smallerChildIndex = getLeftChildIndex(index);
			
			// Check if our assumption was right or whether right child exists and has a smaller value.
			if(hasRightChild(index) && rightChildValue(index) < leftChildValue(index)){
				// If yes, then the right child exists and is the smaller child then left child.
				smallerChildIndex = getRightChildIndex(index);
			}
			
			// Check if the elements is smaller then both its children.
			if(heapTree[index] < heapTree[smallerChildIndex]){
				// If true then the element is already smaller then its child nodes hence do nothing and continue.
				break;
			}else{
				// The element is bigger then its child node hence swap them.
				swap(index, smallerChildIndex);
			}
			
			// Go down to the next level in tree for next iteration.
			index = smallerChildIndex;
		}
	}
	
	public void displayTheHeap(){
		for(int i = 0; i < noOfElementsInHeap; i++){
			System.out.print("| " + heapTree[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		HeapDemo hd = new HeapDemo();
		hd.add(58);
		hd.add(78);
		hd.add(12);
		hd.add(89);
		hd.add(64);
		hd.add(30);
		hd.add(57);
		hd.displayTheHeap();
		hd.removeRoot();
		hd.displayTheHeap();
	}

}
