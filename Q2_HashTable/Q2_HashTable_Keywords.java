import java.util.Scanner;

public class Q2_HashTable_Keywords {
	
	Q2_LinkedList[] arrayOfKeywords;
	
	public Q2_HashTable_Keywords(){
		arrayOfKeywords = new Q2_LinkedList[20];
		
		for(int i=0 ; i < arrayOfKeywords.length; i++){
			arrayOfKeywords[i] = new Q2_LinkedList();
		}
	}
	
	public int hashFunction(String keyword){
		return keyword.length();
	}

	public static void main(String[] args) {
		
		Q2_HashTable_Keywords q2 = new Q2_HashTable_Keywords();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter the keywords to store:");
		String inputData = scan.nextLine();
	    String[] keywords = inputData.split(" ");
		for(String key:keywords){
			q2.arrayOfKeywords[q2.hashFunction(key)].prepend(key);
		}
//	    for(Q2_LinkedList keyList:q2.arrayOfKeywords){
//	    	keyList.printLinkedList();
//	    }
		
		for(int i = 0; i < q2.arrayOfKeywords.length; i++){
			System.out.print("|"+i+"");
			q2.arrayOfKeywords[i].printLinkedList();
		}
		
		System.out.println("*****************************");
		System.out.println("SEARCH : ");
		String inputKeyword = scan.nextLine();
		System.out.println("*****************************");
		int index = q2.hashFunction(inputKeyword);
		
		if(q2.arrayOfKeywords[q2.hashFunction(inputKeyword)].getSearchedValue(inputKeyword)){
			System.out.println("It is found at index = " + index);
		}
		else{
			System.out.println("THIS IS NOT A RECOGNIZED KEYWORD");
		}
	}

}
