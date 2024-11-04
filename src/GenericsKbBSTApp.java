import java.io.*;
import java.util.*;
public class GenericsKbBSTApp {
        /**
        * Entry point for the program. This is the main method that starts the program. If you don't want to run this program you can use the constructor of BinarySearchTree as the first argument.
        * 
        * @param args - command line arguments ( not used in this method
        */
        public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
                int choice =-1;
                BinarySearchTree BST = new BinarySearchTree ();
                // This method is used to load a knowledge base from a file and load it from a file.
                while (choice!=5){
                System.out.println("Choose an action from the menu: ");
                System.out.println("1. Load a knowledge base from a file");
                System.out.println("2. Add a new statement to the knowledge base");
                System.out.println("3. Search for an item in the knowledge base by term");
                System.out.println("4. Search for a item in the knowledge base by term and sentence");
                System.out.println("5. Quit");
                System.out.println();
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                System.out.println();
                // This method is called by the user to load the knowledge base.
                if (choice == 1){
                        System.out.print("Enter file name: ");
                        String fileName = sc.next();                     
                        System.out.println();
			try {
                                Scanner x = new Scanner(new File(fileName));                                
                                // Find the next line in the input stream.
                                while (x.hasNext()){
                                        String line = x.nextLine();
                                        Kb kb = new Kb(line);
                                       // inserts or updates a node in the database.
                                       if (BST.findTerm(kb.getTerm()) == null){
                                          BST.insert(kb);                         
                                       }
                                       else {
                                          // Update the BST with the confidence of the term.
                                          if (BST.findTerm(kb.getTerm()).getData().getConfidence()<=kb.getConfidence()){                                                                                  BST.update(kb,BST.findNode(kb.getTerm()));                                                           
                                          }

                                       }

                                }
                                x.close();
                                System.out.println("Knowledge base loaded successfully.");
                        } catch (Exception e){
                                System.out.println("File not found");
                        }

                }
                // This method is used to find the choice of the choice 1 search 2 search 3 search 4 search for term and statement.
                else if (choice == 2){
                        System.out.print("Enter the term: ");
                        sc.nextLine();
                        String term = sc.nextLine();
                        System.out.print("Enter the statement: ");
                        String statement = sc.nextLine();
                        System.out.print("Enter the confidence score: ");
                        double cs =sc.nextDouble();
			// This method will try to find the next confidence score.
			while ( (cs<0) || (cs>1) ){
				System.out.println("That score is invalid. Please try again.");
				System.out.print("Enter the confidence score: ");
                        	cs =sc.nextDouble();
			}	
			//double cs = sc.nextDouble();
			System.out.println();                        
                        Kb kb = new Kb(term+"\t"+statement+"\t"+String.valueOf(cs));
                        
                        // Insert or update a term.
                        if (BST.findTerm(term) == null){
                           BST.insert(kb);
                           System.out.println("Statement for term, "+term+" has been added.");                           
                        }
                        else {
                           // Update the term with the new confidence.
                           if (BST.findTerm(term).getData().getConfidence()<=cs){
                              BST.update(kb,BST.findNode(term));                              
                              System.out.println("Statement for term, "+term+" has been updated.");                              
                           }
                           else{
                              System.out.println("Statement for term, "+term+" has not been updated. The new confidence is lower than the existing one.");     
                           }                   
                        }
                }
                // This method is used to find the choice of the choice.
                else if (choice == 3){
                        System.out.print("Enter the term to search: ");
                        sc.nextLine();
                        String term = sc.nextLine();
			System.out.println();
                        // Find the term in the term.
                        if (BST.findTerm(term) == null){
                           System.out.println("Statement not found");
                        }
                        else {
                           Kb kb = BST.findTerm(term).getData();
                           System.out.println("Statement found: "+kb.getSentence()+" (Confidence score: "+kb.getConfidence()+")");
                        }
                }
                // This method is called by the user to select a choice.
                else if (choice == 4){
                        System.out.print("Enter the term: ");
                        sc.nextLine();
                        String term = sc.nextLine();
                        System.out.print("Enter the statement to search for: ");
                        String sen = sc.nextLine();
			System.out.println();                        
			// Find the statement that matches the term.
			if (BST.findTermPartial(term,sen) == null){
                           System.out.println("Statement not found.");
                        }
                        else {
                           Kb kb = BST.findTermPartial(term,sen).getData();
                           System.out.println("The statement was found and has a confidence score of "+kb.getConfidence()+".");                           
                        }                        

                }
                // This is an option. Please select an option from the menu above.
                else if (choice == 5){
                	System.out.println("Quitting program.");
		}
		else System.out.println("This is an invalid option. Please select an option from the menu above.");
      		System.out.println();
        } // while
        } //main


} //class
