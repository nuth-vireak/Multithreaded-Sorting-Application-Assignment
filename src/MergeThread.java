
import java.util.ArrayList;

/**
 * This class is used to merge two sorted arrays.
 */
public class MergeThread extends Thread {

    // ----------------------------------------------------------------------------------
    // Fields
    //-----------------------------------------------------------------------------------
    public SortingThread1 sortingThread1;
    public SortingThread2 sortingThread2;


    // ----------------------------------------------------------------------------------
    // Constructors
    //-----------------------------------------------------------------------------------

    /**
     * This constructor is used to create a new MergeThread object. It takes two parameters.
     * @param sortingThread1 The first sorting thread.
     * @param sortingThread2 The second sorting thread.
     */
    public MergeThread(SortingThread1 sortingThread1, SortingThread2 sortingThread2) {
        this.sortingThread1 = sortingThread1;
        this.sortingThread2 = sortingThread2;
    }


    // ----------------------------------------------------------------------------------
    // Methods
    //-----------------------------------------------------------------------------------

    @Override
    public void run() {
        super.run(); // Call the run method of the Thread class
        mergeSortingThread1And2(); // Merge the two arrays together and print the result
    }

    /**
     * This method is used to merge the two arrays together and print the result.
     */
    private void mergeSortingThread1And2() {

        ArrayList<Integer> array1 = sortingThread1.array1; // Get the first array from the first sorting thread object
        ArrayList<Integer> array2 = sortingThread2.array2; // Get the second array from the second sorting thread object

        ArrayList<Integer> mergedArray = new ArrayList<>(); // Create a new array to store the merged array

        int i = 0; // Index for array1
        int j = 0; // Index for array2

        // Merge the two arrays together into the mergedArray array
        while (i < array1.size() && j < array2.size()) { // Loop through the arrays
            if (array1.get(i) < array2.get(j)) { // If the element in array1 is less than the element in array2
                mergedArray.add(array1.get(i)); // Add the element in array1 to the merged array
                i++; // Increment the index for array1
            } else { // If the element in array2 is less than the element in array1
                mergedArray.add(array2.get(j)); // Add the element in array2 to the merged array
                j++; // Increment the index for array2
            }
        }

        // Add the remaining elements in array1 to the merged array
        while (i < array1.size()) { // Loop through the remaining elements in array1
            mergedArray.add(array1.get(i)); // Add the element to the merged array
            i++; // Increment the index for array1
        }

        // Add the remaining elements in array2 to the merged array
        while (j < array2.size()) { // Loop through the remaining elements in array2
            mergedArray.add(array2.get(j)); // Add the element to the merged array
            j++; // Increment the index for array2
        }

        System.out.println("Merged array: " + mergedArray); // Print the merged array
    }
} // End of MergeThread class
