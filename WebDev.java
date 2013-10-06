import java.util.Arrays;
import java.util.Scanner;

/**
 * Class that is supposed to put me in WebDev team.
 * 
 * @author  Matei Razvan Madalin 
 * @version 1.0 04/10/13
 */
public class WebDev {
    private static int input;
    
    /**
     * Setter for input
     */
    private static void setInput(int theInput) {
        input = theInput;
    }
    
    /**
     * Getter for input
     */
    public static int getInput() {
        return input;
    }
    
    private static void test1() {
    	int[] test1 = Functions.manageFunc(
		        Functions.add_one, 
		        Functions.subtract_four, 
		        Functions.add_seven);
        System.out.println("Test 1 for input = " + getInput() + ":");
        System.out.println(Arrays.toString(test1));
        System.out.println();
    }
    
    private static void test2() {
    	int[] test2 = Functions.manageFunc(
                Functions.multiply_by_five, 
                Functions.subtract_one, 
                Functions.add_eleven,
                Functions.multiply_by_eight,
                Functions.multiply_by_twenty);
        System.out.println("Test 2 for input = " + getInput() + ":");
        System.out.println(Arrays.toString(test2));
        System.out.println();
    }
    
    
    /**
     * If you want to do another test, use this method
     */
    private static void userMachineDialog() {
    	// Set input.
    	Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Enter input value: ");
            try {
                setInput(Integer.parseInt(in.nextLine()));
                break;
            } catch (Exception e) {
            	// Case when input is not an integer
                System.out.print("Error #1: Please enter a valid integer value!\n\n");
            }
        }
        System.out.print("\n\n");
        
        // Get functions for test.
        // You can chose maximum 10 functions.
        String optionString = "Select functions to apply to input:\n" + 
        					  "		0.  DONE\n" + 
        					  "		1.  add_one\n" + 
        					  "		2.  add_two\n" +
        					  "		3.  multiple_by_five\n" + 
        					  "		4.  subtract_four\n" + 
        					  "		5.  add_seven\n" + 
        					  "		6.  multiple_by_two\n" + 
        					  "		7.  subtract_one\n" +
        					  "		8.  multiple_by_twenty\n" +
        					  "		9.  multiple_by_eight\n" + 
        					  "		10. add_eleven\n" + 
        					  "Option: ";
        int[] optionValues = new int[10];
        int option;
        int cnt = 0;
        boolean firstChoice = true; // guarantee that at least 1 function is tested
        
        while(true) {
        	if (cnt == 10) break;
        	
        	System.out.print(optionString);
        	
        	try {
                option = Integer.parseInt(in.nextLine());
                
                if(option == 0) {
                	if (!firstChoice) break;
                	else System.out.print("Error #2: Must choose at least 1 function!\n\n");
                } else if(option < 0 || option > 10) {
                	System.out.print("Error #3: Please enter an option between 0 and 10!\n\n");
                } else {
                	optionValues[cnt++] = option;
                	firstChoice = false;
                	System.out.print("\n\n");
                }
            } catch (Exception e) {
            	// Case when is typed something else than an integer value.
                System.out.print("Error #4: Please enter a valid option!\n\n");
            }
        }
        
        // When not tested all functions, this array contains only <cnt> good values.
        int[] rawReturnValues = Functions.manageFunc(
        		Functions.funcList.get(optionValues[0]),
        		Functions.funcList.get(optionValues[1]),
        		Functions.funcList.get(optionValues[2]),
        		Functions.funcList.get(optionValues[3]),
        		Functions.funcList.get(optionValues[4]),
        		Functions.funcList.get(optionValues[5]),
        		Functions.funcList.get(optionValues[6]),
        		Functions.funcList.get(optionValues[7]),
        		Functions.funcList.get(optionValues[8]),
        		Functions.funcList.get(optionValues[9]));
        
        if (cnt == 10) {
        	// Case when all functions are tested.
        	System.out.println("\n\nReturned array: \n" + 
        			Arrays.toString(rawReturnValues) + "\n\n");
        	return;
        }
        
        // Get only good values.
        int[] preciseReturnValues = new int[cnt];
        for(int i = 0; i < cnt; i++) {
        	preciseReturnValues[i] = rawReturnValues[i];	
        }
        
        System.out.println("\n\nReturned array: \n" + 
        		Arrays.toString(preciseReturnValues) + "\n\n");
    }
    
    public static void main(String[] args) {
        setInput(10);
        
        test1();
        
        test2();
        
    //  userMachineDialog();
    }
}
