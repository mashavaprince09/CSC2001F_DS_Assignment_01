import java.util.*;
public class main{
	/**
	* Entry point for the application. Reads user input and chooses which data structure to load knowledge base into
	* 
	* @param args - command line arguments not
	*/
	public static void main(String[] args){
                Scanner sc = new Scanner(System.in);		
		System.out.println("Select a data structure to load to knowledge base into"); 
		System.out.println("Choose your data structure: ");
		System.out.println("1. Array");
		System.out.println("2. Binary Search Tree");
		System.out.println();
		System.out.println("Choose your data structure: ");
		String option = sc.nextLine();           
                System.out.println();
		// This method is called by the application.
		if (option.equals("1")){
                        GenericsKbArrayApp.main(null);
                }
                // This method is called when the option is 2.
                else if (option.equals("2")){
                        GenericsKbBSTApp.main(null);
                }
		else {
        	System.out.println("That option is invalid. Please try again.");

		}
	}
}
