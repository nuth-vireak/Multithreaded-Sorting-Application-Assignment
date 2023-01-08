import java.util.ArrayList;

/**
 * This SortingThread1 class contains the thread for sorting the first half of the array.
 */
public class SortingThread1 extends Thread {

    // ----------------------------------------------------------------------------------
    // Fields
    //-----------------------------------------------------------------------------------
    public ArrayList<Integer> array1; // The first half of the array to be sorted by this thread


    // ----------------------------------------------------------------------------------
    // Constructors
    //-----------------------------------------------------------------------------------

    /**
     * This constructor is used to create a new SortingThread1 object. It takes one parameter.
     * @param array1 The first half of the array to be sorted by this thread.
     */
    public SortingThread1(ArrayList<Integer> array1) {

        this.array1 = array1; // Set the array1 field to the parameter
        BubbleSort.bubbleSort(array1); // Sort the array using the bubble sort algorithm
        System.out.println("Array 1 after sorting: " + array1); // Print the array after sorting
    }

    // ----------------------------------------------------------------------------------
    // Methods
    //-----------------------------------------------------------------------------------

    @Override
    public void run() {
        super.run();
    }
} // End of SortingThread1 class