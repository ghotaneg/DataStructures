import java.util.Arrays;

public class CountingSort {
	
	public void countingSort(int[] arr){
		int min = 0;
		int max = 0;
		
		// Array to store the sorted output.
		int[] sortedOutput = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++){
			
			// Identify the min value of the range.
			if(arr[i] < min){
				min = arr[i];
			}
			
			// Identify the max value of the range.
			if(arr[i] > max){
				max = arr[i];
			}
		}
		
		// Initialize a new counter array.
		int[] counterArray = new int[max+1]; // max + 1 is used to avoid complexity. You will also see max - min + 1
		
		// Fill the counter array with all zeroes.
		Arrays.fill(counterArray, 0);
		
		// Just for debugging purpose to see how each index has 0 as the value.
		displayArray("INITIAL -  Counter Array", counterArray);
		
		// Fill the counter array indexes with counts of no. of occurrences of numbers in the input array.
		for(int j = 0; j < arr.length; j++){
			if(counterArray[arr[j]] == 0){
				counterArray[arr[j]] = 1;
			}else{
				counterArray[arr[j]] += 1;
			}
		}
		
		// Just for debugging purpose to verify if the counts are getting populated correctly.
		displayArray("Check COUNTS -  Counter Array", counterArray);
		
		// Calculate the sums.
		for(int c = 1; c < counterArray.length; c++){
			counterArray[c] = counterArray[c-1] + counterArray[c];
		}
		
		// Just for debugging purpose to verify if the sums are getting populated correctly.
		displayArray("Check SUMS - Counter Array", counterArray);
		
		for(int inputNum:arr){
			sortedOutput[counterArray[inputNum]-1] = inputNum;
			counterArray[inputNum] -= 1;
		}
		
		displayArray("Final Output - Sorted Array", sortedOutput);
		
		
	}
	
	public void displayArray(String header, int[] arrayToDisplay){
		System.out.println("****** " + header +  " ******");
		String values = "";
		String indices = "";
		String stars = "";
		for(int m = 0; m < arrayToDisplay.length; m++){
			//System.out.print("| " + arrayToDisplay[m] + " ");
			values += "| " + arrayToDisplay[m] + " ";
			indices += "  " + m + " ";
			stars += "*";
		}
		System.out.println(values);
		System.out.println(indices);
		System.out.println(stars);
		//System.out.println("\n*****************************************************************************************");
	}

	public static void main(String[] args) {
		
		CountingSort cs = new CountingSort();
		
		int[] inputArray = {5,27,43,33,1,56,98,2,78,2};
		
		cs.displayArray("Input Unsorted Array", inputArray);
		cs.countingSort(inputArray);
		

	}

}
