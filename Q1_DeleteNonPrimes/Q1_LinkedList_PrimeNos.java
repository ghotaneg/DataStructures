import java.io.*;
import java.net.URL;

public class Q1_LinkedList_PrimeNos {
	
	public static void main(String[] args) {
		
		Q1_LinkedList_PrimeNos q1MainClass = new Q1_LinkedList_PrimeNos();
		
		// The name of the file to open.
        String fileName = "q1_input_data.txt";

        // This will reference one line at a time
        String line = null;
        
        URL url = q1MainClass.getClass().getClassLoader().getResource("inputFiles/q1_input_data.txt");

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(url.getPath());

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            
            Q1_LinkedList myQ1LinkedList = new Q1_LinkedList();

            while((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
            	String[] inputNos = line.split(",");
            	for(String num:inputNos){
            		myQ1LinkedList.append(Integer.parseInt(num));
            	}
            }
            
            myQ1LinkedList.printLinkedList();
            
            // Delete all non prime nos.
            String output = myQ1LinkedList.deleteAllNonPrimes();
            System.out.println("********** After deleting all non prime ************");
            System.out.println(output);
            myQ1LinkedList.printLinkedList();
            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            ex.printStackTrace();
        }

	}

}
