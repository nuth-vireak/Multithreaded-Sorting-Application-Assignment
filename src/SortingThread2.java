import java.util.ArrayList;

/**
 * This SortingThread2 class contains the thread for sorting the second half of the array.
 */
public class SortingThread2 extends Thread {

    // ----------------------------------------------------------------------------------
    // Fields
    //-----------------------------------------------------------------------------------
    public ArrayList<Integer> array2; // The second half of the array to be sorted by this thread


    // ----------------------------------------------------------------------------------
    // Constructors
    //-----------------------------------------------------------------------------------

    /**
     * This constructor is used to create a new SortingThread2 object. It takes one parameter.
     * @param array2 The second half of the array to be sorted by this thread.
     */
    public SortingThread2(ArrayList<Integer> array2) {
        this.array2 = array2; // Set the array2 field to the parameter
        BubbleSort.bubbleSort(array2); // Sort the array using the bubble sort algorithm
        System.out.println("Array 2 after sorting: " + array2); // Print the array after sorting
    }


    // ----------------------------------------------------------------------------------
    // Methods
    //-----------------------------------------------------------------------------------

    @Override
    public void run() {
        super.run();
    }
} // End of SortingThread2 class
