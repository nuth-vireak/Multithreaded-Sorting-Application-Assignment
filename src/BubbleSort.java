import java.util.ArrayList;

/**
 * This BubbleSort class contains the bubble sort algorithm.
 */
public class BubbleSort {

    // ----------------------------------------------------------------------------------
    // Methods
    //-----------------------------------------------------------------------------------

    /**
     * This method is used to sort an array using the bubble sort algorithm.
     * @param array The array to be sorted.
     */
    public static void bubbleSort(ArrayList<Integer> array) {

        int n = array.size(); // Get the size of the array
        int temp; // Temporary variable for swapping

        for (int i = 0; i < n; i++) { // Loop through the array
            for (int j = 1; j < (n - i); j++) { // Loop through the array
                if (array.get(j - 1) > array.get(j)) { // If the previous element is greater than the current element
                    // Swap elements
                    temp = array.get(j - 1); // Store the previous element in the temporary variable
                    array.set(j - 1, array.get(j)); // Set the previous element to the current element
                    array.set(j, temp); // Set the current element to the temporary variable
                }
            }
        }
    }
} // End of BubbleSort class
