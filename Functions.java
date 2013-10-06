import java.util.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Callable;

/**
 * Class that contains testing functions.
 * 
 * This class contains:
 * 		- do_nothing - used for <userMachineDialog> method in WebDev class
 *      - 10 test functions: - add_one
 *                           - add_two
 *                           - multiple_by_five
 *                           - subtract_four
 *                           - add_seven
 *                           - multiply_by_two
 *                           - subtract_one
 *                           - multiply_by_twenty
 *                           - multiply_by_eight
 *                           - add_eleven
 *      - manageFunc
 *      
 * The function <<manageFunc>> must handle an indeterminate 
 * number of testing functions, so all the test functions are
 * created with Callable structures.
 * 
 * @author  Matei Razvan Madalin 
 * @version 1.0 04/10/13
 */
public class Functions {
	
	// This function is used for <userMachineDialog> method in WebDev class
    public static Callable<Integer> do_nothing = new Callable<Integer>() {
        public Integer call() {
            return WebDev.getInput();
        }
    };
	
    // Function #1
    public static Callable<Integer> add_one = new Callable<Integer>() {
        public Integer call() {
            return WebDev.getInput() + 1;
        }
    };
    
    // Function #2
    public static Callable<Integer> add_two = new Callable<Integer>() {
        public Integer call() {
            return WebDev.getInput() + 2;
        }
    };

    // Function #3
    public static Callable<Integer> multiply_by_five = new Callable<Integer>() {
        public Integer call() {
            return WebDev.getInput() * 5;
        }
    };
    
    // Function #4
    public static Callable<Integer> subtract_four = new Callable<Integer>() {
        public Integer call() {
            return WebDev.getInput() - 4;
        }
    };
    
    // Function #5
    public static Callable<Integer> add_seven = new Callable<Integer>() {
        public Integer call() {
            return WebDev.getInput() + 7;
        }
    };
    
    // Function #6
    public static Callable<Integer> multiply_by_two = new Callable<Integer>() {
        public Integer call() {
            return WebDev.getInput() * 2;
        }
    };
    
    // Function #7
    public static Callable<Integer> subtract_one = new Callable<Integer>() {
        public Integer call() {
            return WebDev.getInput() - 1;
        }
    };
    
    // Function #8
    public static Callable<Integer> multiply_by_twenty = new Callable<Integer>() {
        public Integer call() {
            return WebDev.getInput() * 20;
        }
    };
    
    // Function #9
    public static Callable<Integer> multiply_by_eight = new Callable<Integer>() {
        public Integer call() {
            return WebDev.getInput() * 8;
        }
    };
    
    // Function #10
    public static Callable<Integer> add_eleven = new Callable<Integer>() {
        public Integer call() {
            return WebDev.getInput() + 11;
        }
    };
    
    public static List<Callable<Integer>> funcList = Arrays.asList(
    		do_nothing,
    		add_one,
    		add_two,
    		multiply_by_five,
    		subtract_four,
    		add_seven,
    		multiply_by_two,
    		subtract_one,
    		multiply_by_twenty,
    		multiply_by_eight,
    		add_eleven
    	);
    
    /**
     * This function manages an indeterminate number of functions (Callables)
     * 
     * @param   myFunc - an indeterminate number of functions
     * @return  returnValues - an array with the input value modified
     *                       by myFunc
     */
    public static int[] manageFunc(Callable<Integer>... myFunc) {
        try {
            int noFunc = 0; // number of functions called
            
            // Get number of functions
            for (Callable<Integer> auxFunc : myFunc) {
                noFunc++;
            }
            
            int[] returnValues = new int[noFunc]; // array to be returned
            int i = 0;
            // Call every function given as parameter and put the returned
            // values in returnValues array.
            for (Callable<Integer> auxFunc : myFunc) {
                returnValues[i++] = auxFunc.call();
            }
            return returnValues;
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Exception!");
            int[] bad = {-1};
            return bad;
        }
    }
}