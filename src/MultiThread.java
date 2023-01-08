import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MultiThread {

    // ----------------------------------------------------------------------------------
    // Fields
    //-----------------------------------------------------------------------------------

    static Scanner input = new Scanner(System.in);


    // ----------------------------------------------------------------------------------
    // Methods
    //-----------------------------------------------------------------------------------

    public void multiThreadProgram() throws InterruptedException {

        System.out.println("----------------------------------");
        System.out.println("-> Multi Thread Sorting");
        System.out.println("----------------------------------");

        // User input
        System.out.print("Enter array size: ");
        int size = input.nextInt();

        // Create a random array
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            array.add((int) (Math.random() * 100));
        }

        System.out.println(); // Empty line

        // Print the array before sorting
        System.out.println("Generated Array----------------------------------------------------------------------------------");
        System.out.println(array);
        System.out.println("-------------------------------------------------------------------------------------------------");

        // Divide array into two parts
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) { // Loop through the array
            if (i < array.size() / 2) { // If the index is less than half of the array size
                array1.add(array.get(i)); // Add the element to array1
            } else { // If the index is greater than or equal to half of the array size
                array2.add(array.get(i)); // Add the element to array2
            }
        }

        System.out.println(); // Empty line

        // Display the first half of the array
        System.out.println("Array 1 Before Sorting---------------------------------------------------------------------------");
        System.out.println(array1);
        System.out.println("-------------------------------------------------------------------------------------------------");

        System.out.println(); // Empty line

        // Display the second half of the array
        System.out.println("Array 2 Before Sorting---------------------------------------------------------------------------");
        System.out.println(array2);
        System.out.println("-------------------------------------------------------------------------------------------------");

        Date startTime = new Date(); // Get the start time

        System.out.println(); // Empty line

        // Create a new thread for sorting array1
        System.out.println("Sorting Thread 1 Started-------------------------------------------------------------------------");
        SortingThread1 sortingThread1 = new SortingThread1(array1); // Create a new thread for sorting array1
        sortingThread1.start(); // Start the thread for sorting array1
        sortingThread1.join(); // Wait for the thread to finish
        System.out.println("-------------------------------------------------------------------------------------------------");

        System.out.println(); // Empty line

        // Create a new thread for sorting array2
        System.out.println("Sorting Thread 2 Started-------------------------------------------------------------------------");
        SortingThread2 sortingThread2 = new SortingThread2(array2); // Create a new thread for sorting array2
        sortingThread2.start(); // Start the thread for sorting array2
        sortingThread2.join(); // Wait for the thread to finish
        System.out.println("-------------------------------------------------------------------------------------------------");

        System.out.println(); // Empty line

        // Create a new thread for merging array1 and array2
        System.out.println("Merge Thread Started----------------------------------------------------------------------------");
        MergeThread mergeThread = new MergeThread(sortingThread1, sortingThread2); // Create a new thread for merging array1 and array2
        mergeThread.start(); // Start the thread for merging array1 and array2
        mergeThread.join(); // Wait for the thread to finish
        System.out.println("-------------------------------------------------------------------------------------------------");

        Date endTime = new Date(); // Get the end time

        long timeTaken = endTime.getTime() - startTime.getTime(); // Calculate the time taken to sort the array

        System.out.println();
        System.out.println("EXECUTION TIME--------------");
        System.out.println(timeTaken + " ms");
        System.out.printf("%02d min, %02d sec, %03d ms%n",
                TimeUnit.MILLISECONDS.toMinutes(timeTaken),
                TimeUnit.MILLISECONDS.toSeconds(timeTaken) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeTaken)),
                timeTaken % 1000);

        System.out.println("----------------------------");
    }
} // End of MultiThread class
