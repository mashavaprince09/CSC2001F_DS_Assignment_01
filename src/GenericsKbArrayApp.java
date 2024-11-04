import java.io.*;
import java.util.*;
public class GenericsKbArrayApp {
        /**
        * Main method for Knowledge Base. Reads user input and performs actions based on the input. If user enters quit the program will quit
        * 
        * @param args - command line arguments not
        */
        public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
                Kb[] array = new Kb[100000];
                int choice =-1;
                int count = 0;
                // This method is used to select a knowledge base.
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
                // This method is called by the user to load knowledge base.
                if (choice == 1){
                        System.out.print("Enter file name: ");
			sc.nextLine();
                        String fileName = sc.nextLine();
                        //String fileName = "GenericsKB.txt";
                        //String fileName = "GenericsKB-additional.txt";                        
                        try {
                                Scanner x = new Scanner(new File(fileName));
                                int index = 0;
                                // Find the next line in the array.
                                while (x.hasNext()){
                                        String line = x.nextLine();
                                        Kb kb = new Kb(line);
                                        boolean bExists =false;
                                        // replace all the elements with the same confidence
                                        for (int i=0;i<index;i++){
                                                Kb ele = array[i];
                                                // replace ele with the same term if the term is less than the confidence threshold
                                                if ((ele.matchTerm(kb.getTerm())) && (ele.getConfidence()<=kb.getConfidence())){                                                                                                                  
                                                  	ele.replace(kb);
                                                        bExists = true;
                                                        break;
                                                }                                                  
                                        }
                                        // Set the kb to the current value.
                                        if (bExists==false){
                                                array[index] = kb;
                                                index++;
                                        }
                                }
                                count=index;
                                x.close();
				System.out.println();
                                System.out.println("Knowledge base loaded successfully.");
                        } catch (Exception e){
				System.out.println();
                                System.out.println("File not found");
                        }

                }
                // This method is used to find the choice of the choice 1 or 2.
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
                        Kb kb = new Kb(term+"\t"+statement+"\t"+String.valueOf(cs));
                        boolean bExists =false;
			boolean bUpdate =false;
                                // Replaces all the statements in the array with the new values.
                                for (int i=0;i<count;i++){
                                         Kb ele = array[i];
 					 // replace the statement with the given term.
 					 if ( (ele.matchTerm(kb.getTerm()))  ){
						 bExists = true;
						// Update the term with the confidence of the term.
						if (ele.getConfidence()<=kb.getConfidence()){
							bUpdate = true;
							ele.replace(kb);
							System.out.println();
	                                                System.out.println("Statement for term "+term+" has been updated.");
                                                	break;
						}
                                        }
					// If the statement already exists and cannot be updated.
					else if (bExists){					                                                						
                                                System.out.println();
                                                System.out.println("A statement for, "+term+" already exists and cannot be updated.");
						break;
                                        }					
                                        
				}
                                // Add a new statement to the term.
                                if ((!bExists) && (!bUpdate) ){
                                	array[count] = kb;
                                        count++;
					System.out.println();
                                        System.out.println("Statement for term "+term+" has been added.");
                                }


                }
                // This method is used to find the choice of the choice.
                else if (choice == 3){
                        System.out.print("Enter the term to search: ");
                        sc.nextLine();
                        String term = sc.nextLine();
                        boolean bFound = false;
                        // Searches for a term in the array for a matching term.
                        for (int i=0;i<count;i++){
                                Kb ele = array[i];
                                // Match the term of the sentence and confidence score.
                                if (ele.matchTerm(term)){
                                        bFound = true;
					System.out.println();
                                        System.out.println("Statement found: "+ele.getSentence()+" (Confidence score: "+ele.getConfidence()+")");
                                }
                        }
                        // If statement is not found print out a warning.
                        if (!bFound){
				System.out.println();
                                System.out.println("Statement not found");
                        }
                }
                // This method is called by the user to select a choice.
                else if (choice == 4){
                        System.out.print("Enter the term: ");
                        sc.nextLine();
                        String term = sc.nextLine();
                        System.out.print("Enter the statement to search for: ");
                        String sen = sc.nextLine();
                        boolean bFound = false;
                        // Searches the array for the matching term.
                        for (int i=0;i<count;i++){
                                Kb ele = array[i];
                                // Match the term of the statement.
                                if (ele.matchTerm(term)){
                                        bFound = true;
					System.out.println();
                                         System.out.println("The statement was found and has a confidence score of "+ele.getConfidence()+".");
                                }
                        }
                        // If statement is not found print out a warning.
                        if (!bFound){
				System.out.println();
                                System.out.println("Statement not found");
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
